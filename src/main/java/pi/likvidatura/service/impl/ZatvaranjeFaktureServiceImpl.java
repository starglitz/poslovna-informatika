package pi.likvidatura.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pi.likvidatura.domain.StavkaIzvoda;
import pi.likvidatura.domain.ZatvaranjeFakture;
import pi.likvidatura.exception.FakturaVecZatvorenaException;
import pi.likvidatura.exception.NedovoljnoSredstavaException;
import pi.likvidatura.exception.NeispravanIznosException;
import pi.likvidatura.repository.IzlaznaFakturaRepository;
import pi.likvidatura.repository.StavkaIzvodaRepository;
import pi.likvidatura.repository.ZatvaranjeFaktureRepository;
import pi.likvidatura.service.ZatvaranjeFaktureService;
import pi.likvidatura.service.dto.IzlaznaFakturaDTO;
import pi.likvidatura.service.dto.StavkaIzvodaDTO;
import pi.likvidatura.service.dto.ZatvaranjeFaktureDTO;
import pi.likvidatura.service.mapper.IzlaznaFakturaMapper;
import pi.likvidatura.service.mapper.StavkaIzvodaMapper;
import pi.likvidatura.service.mapper.ZatvaranjeFaktureMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ZatvaranjeFaktureServiceImpl implements ZatvaranjeFaktureService {

    @Autowired
    private ZatvaranjeFaktureRepository zatvaranjeFaktureRepository;

    @Autowired
    private StavkaIzvodaRepository stavkaIzvodaRepository;

    @Autowired
    private IzlaznaFakturaRepository izlaznaFakturaRepository;

    @Autowired
    private ZatvaranjeFaktureMapper zatvaranjeFaktureMapper;

    @Autowired
    private StavkaIzvodaMapper stavkaIzvodaMapper;

    @Autowired
    private IzlaznaFakturaMapper izlaznaFakturaMapper;

    private final Logger log = LoggerFactory.getLogger(StavkaIzvodaServiceImpl.class);


    @Override
    public ZatvaranjeFaktureDTO zatvoriFakturu(ZatvaranjeFaktureDTO zatvaranjeFaktureDTO) {
        checkIfMozeDaUplati(zatvaranjeFaktureDTO);

        IzlaznaFakturaDTO faktura = zatvaranjeFaktureDTO.getFaktura();
        StavkaIzvodaDTO stavka = zatvaranjeFaktureDTO.getStavkaIzvoda();

        stavka.setIskorisceniIznos(stavka.getIskorisceniIznos() + zatvaranjeFaktureDTO.getIznos());
        faktura.setIsplaceniIznos(faktura.getIsplaceniIznos() + zatvaranjeFaktureDTO.getIznos());

        if(faktura.getIsplaceniIznos().equals(faktura.getIznosZaPlacanje())) {
            faktura.setZatvorena(true);
        }
        //ovde ce trebati optimisticko zakljucavanje?
        stavkaIzvodaRepository.save(stavkaIzvodaMapper.toEntity(stavka));
        izlaznaFakturaRepository.save(izlaznaFakturaMapper.toEntity(faktura));


        ZatvaranjeFakture zatvaranje = zatvaranjeFaktureRepository.save(zatvaranjeFaktureMapper.toEntity(zatvaranjeFaktureDTO));

        return ZatvaranjeFaktureDTO.fromEntity(zatvaranje);
    }

    private void checkIfMozeDaUplati(ZatvaranjeFaktureDTO zatvaranjeFaktureDTO) {
        if(zatvaranjeFaktureDTO.getIznos() <= 0) {
            throw new NeispravanIznosException("Iznos uplate mora biti veci od 0");
        }

        if(zatvaranjeFaktureDTO.getFaktura().isZatvorena()) {
            throw new FakturaVecZatvorenaException("Izabrana faktura je vec zatvorena");
        }

        if(zatvaranjeFaktureDTO.getStavkaIzvoda().getIznos()
                .equals(zatvaranjeFaktureDTO.getStavkaIzvoda().getIskorisceniIznos())) {
            throw new NedovoljnoSredstavaException("Vec je iskoriscen sav novac sa stavke izvoda");
        }

        Double raspolozivoSaStavke = zatvaranjeFaktureDTO.getStavkaIzvoda().getIznos() -
                zatvaranjeFaktureDTO.getStavkaIzvoda().getIskorisceniIznos();

        if(Double.compare(raspolozivoSaStavke, zatvaranjeFaktureDTO.getIznos()) < 0) {
            throw new NedovoljnoSredstavaException("Stavka ima manje raspolozivog novca nego sto je trazeni iznos");
        }

    }

    @Override
    @Transactional(readOnly = true)
    public List<ZatvaranjeFaktureDTO> findAll(Long fakturaId, Long stavkaId) {
        log.debug("Request to get all zatvaranja");
        List<ZatvaranjeFaktureDTO> zatvaranja = zatvaranjeFaktureRepository
                .findAll().stream().map(ZatvaranjeFaktureDTO::fromEntity)
                .collect(Collectors.toList());

        return filterZatvaranja(fakturaId, stavkaId, zatvaranja);
    }

        private List<ZatvaranjeFaktureDTO> filterZatvaranja(Long fakturaId,
        Long stavkaId, List<ZatvaranjeFaktureDTO> zatvaranja) {

            if(fakturaId == null && stavkaId == null) {
                return zatvaranja;
            }

            List<ZatvaranjeFaktureDTO> filtrirani = new ArrayList<>();

            if(fakturaId != null && stavkaId != null) {
                for(ZatvaranjeFaktureDTO zatvaranje : zatvaranja) {
                    if(fakturaId.equals(zatvaranje.getFaktura().getId())
                            && stavkaId.equals(zatvaranje.getStavkaIzvoda().getId())) {
                        filtrirani.add(zatvaranje);
                    }
                }
                return filtrirani;
            }

            else if(fakturaId == null && stavkaId != null) {
                for(ZatvaranjeFaktureDTO zatvaranje : zatvaranja) {
                    if(stavkaId.equals(zatvaranje.getStavkaIzvoda().getId())) {
                        filtrirani.add(zatvaranje);
                    }
                }
                return filtrirani;
            }

            else if(fakturaId != null && stavkaId == null) {
                for(ZatvaranjeFaktureDTO zatvaranje : zatvaranja) {
                    if(fakturaId.equals(zatvaranje.getFaktura().getId())) {
                        filtrirani.add(zatvaranje);
                    }
                }
                return filtrirani;
            }

        return zatvaranja;
        }

    @Override
    @Transactional(readOnly = true)
    public Optional<ZatvaranjeFaktureDTO> findOne(Long id) {
        return Optional.empty();
    }
}
