package pi.likvidatura.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.likvidatura.domain.StavkaIzvoda;
import pi.likvidatura.service.dto.DnevnoStanjeDTO;
import pi.likvidatura.service.dto.StavkaIzvodaDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-15T13:23:32+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class StavkaIzvodaMapperImpl implements StavkaIzvodaMapper {

    @Autowired
    private DnevnoStanjeMapper dnevnoStanjeMapper;

    @Override
    public StavkaIzvoda toEntity(StavkaIzvodaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        StavkaIzvoda stavkaIzvoda = new StavkaIzvoda();

        stavkaIzvoda.setId( dto.getId() );
        stavkaIzvoda.setBrojStavke( dto.getBrojStavke() );
        stavkaIzvoda.setIznos( dto.getIznos() );
        stavkaIzvoda.setDuznik( dto.getDuznik() );
        stavkaIzvoda.setSvrhaPlacanja( dto.getSvrhaPlacanja() );
        stavkaIzvoda.setPrimalac( dto.getPrimalac() );
        stavkaIzvoda.setRacunDuznika( dto.getRacunDuznika() );
        stavkaIzvoda.setRacunPrimaoca( dto.getRacunPrimaoca() );
        stavkaIzvoda.setModel( dto.getModel() );
        stavkaIzvoda.setPozivNaBroj( dto.getPozivNaBroj() );
        stavkaIzvoda.dnevnoStanje( dnevnoStanjeMapper.toEntity( dto.getDnevnoStanje() ) );
        stavkaIzvoda.setIskorisceniIznos( dto.getIskorisceniIznos() );
        stavkaIzvoda.setVerzija( dto.getVerzija() );

        return stavkaIzvoda;
    }

    @Override
    public List<StavkaIzvoda> toEntity(List<StavkaIzvodaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<StavkaIzvoda> list = new ArrayList<StavkaIzvoda>( dtoList.size() );
        for ( StavkaIzvodaDTO stavkaIzvodaDTO : dtoList ) {
            list.add( toEntity( stavkaIzvodaDTO ) );
        }

        return list;
    }

    @Override
    public List<StavkaIzvodaDTO> toDto(List<StavkaIzvoda> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<StavkaIzvodaDTO> list = new ArrayList<StavkaIzvodaDTO>( entityList.size() );
        for ( StavkaIzvoda stavkaIzvoda : entityList ) {
            list.add( toDto( stavkaIzvoda ) );
        }

        return list;
    }

    @Override
    public StavkaIzvodaDTO toDto(StavkaIzvoda s) {
        if ( s == null ) {
            return null;
        }

        DnevnoStanjeDTO dnevnoStanje = null;
        Long id = null;
        Integer brojStavke = null;
        Double iznos = null;
        String duznik = null;
        String svrhaPlacanja = null;
        String primalac = null;
        String racunDuznika = null;
        String racunPrimaoca = null;
        Integer model = null;
        String pozivNaBroj = null;
        Double iskorisceniIznos = null;
        int verzija = 0;

        dnevnoStanje = dnevnoStanjeMapper.toDtoId( s.getDnevnoStanje() );
        id = s.getId();
        brojStavke = s.getBrojStavke();
        iznos = s.getIznos();
        duznik = s.getDuznik();
        svrhaPlacanja = s.getSvrhaPlacanja();
        primalac = s.getPrimalac();
        racunDuznika = s.getRacunDuznika();
        racunPrimaoca = s.getRacunPrimaoca();
        model = s.getModel();
        pozivNaBroj = s.getPozivNaBroj();
        iskorisceniIznos = s.getIskorisceniIznos();
        verzija = s.getVerzija();

        StavkaIzvodaDTO stavkaIzvodaDTO = new StavkaIzvodaDTO( id, brojStavke, iznos, duznik, svrhaPlacanja, primalac, racunDuznika, racunPrimaoca, model, pozivNaBroj, dnevnoStanje, iskorisceniIznos, verzija );

        return stavkaIzvodaDTO;
    }
}
