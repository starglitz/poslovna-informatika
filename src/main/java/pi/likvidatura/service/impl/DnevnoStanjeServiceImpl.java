package pi.likvidatura.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pi.likvidatura.domain.DnevnoStanje;
import pi.likvidatura.domain.StavkaIzvoda;
import pi.likvidatura.repository.DnevnoStanjeRepository;
import pi.likvidatura.repository.StavkaIzvodaRepository;
import pi.likvidatura.service.DnevnoStanjeService;
import pi.likvidatura.service.dto.DnevnoStanjeDTO;
import pi.likvidatura.service.mapper.DnevnoStanjeMapper;

/**
 * Service Implementation for managing {@link DnevnoStanje}.
 */
@Service
@Transactional
public class DnevnoStanjeServiceImpl implements DnevnoStanjeService {

    private final Logger log = LoggerFactory.getLogger(DnevnoStanjeServiceImpl.class);

    private final DnevnoStanjeRepository dnevnoStanjeRepository;

    private final StavkaIzvodaRepository stavkaIzvodaRepository;

    private final DnevnoStanjeMapper dnevnoStanjeMapper;

    public DnevnoStanjeServiceImpl(DnevnoStanjeRepository dnevnoStanjeRepository,
                                   DnevnoStanjeMapper dnevnoStanjeMapper,
                                   StavkaIzvodaRepository stavkaIzvodaRepository) {
        this.dnevnoStanjeRepository = dnevnoStanjeRepository;
        this.dnevnoStanjeMapper = dnevnoStanjeMapper;
        this.stavkaIzvodaRepository = stavkaIzvodaRepository;
    }

    @Override
    public DnevnoStanjeDTO save(DnevnoStanjeDTO dnevnoStanjeDTO) {
        log.debug("Request to save DnevnoStanje : {}", dnevnoStanjeDTO);
        DnevnoStanje dnevnoStanje = dnevnoStanjeMapper.toEntity(dnevnoStanjeDTO);
        dnevnoStanje = dnevnoStanjeRepository.save(dnevnoStanje);
        return dnevnoStanjeMapper.toDto(dnevnoStanje);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DnevnoStanjeDTO> findAll() {
        log.debug("Request to get all");
        return dnevnoStanjeRepository.findAll().stream().map(dnevnoStanjeMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DnevnoStanjeDTO> findOne(Long id) {
        log.debug("Request to get DnevnoStanje : {}", id);
        return dnevnoStanjeRepository.findById(id).map(dnevnoStanjeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete DnevnoStanje : {}", id);
        dnevnoStanjeRepository.deleteById(id);
    }

    @Override
    public void uploadFile(MultipartFile file) throws IOException {
        DnevnoStanje stanje = getDnevnoStanjeFromFile(file);
        for(StavkaIzvoda stavka : stanje.getStavkaIzvodas()) {
            stavkaIzvodaRepository.save(stavka);
        }
        dnevnoStanjeRepository.save(stanje);
    }

    public DnevnoStanje getDnevnoStanjeFromFile(MultipartFile file) throws IOException {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        DnevnoStanje stanje = mapper.readValue(convertMultiPartToFile(file), DnevnoStanje.class);
        return stanje;
    }

    private File convertMultiPartToFile(MultipartFile file)
            throws IOException, FileNotFoundException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
