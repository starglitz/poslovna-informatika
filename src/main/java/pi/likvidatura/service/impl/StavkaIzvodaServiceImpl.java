package pi.likvidatura.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pi.likvidatura.domain.StavkaIzvoda;
import pi.likvidatura.repository.StavkaIzvodaRepository;
import pi.likvidatura.service.StavkaIzvodaService;
import pi.likvidatura.service.dto.IzlaznaFakturaDTO;
import pi.likvidatura.service.dto.StavkaIzvodaDTO;
import pi.likvidatura.service.mapper.StavkaIzvodaMapper;

/**
 * Service Implementation for managing {@link StavkaIzvoda}.
 */
@Service
@Transactional
public class StavkaIzvodaServiceImpl implements StavkaIzvodaService {

    private final Logger log = LoggerFactory.getLogger(StavkaIzvodaServiceImpl.class);

    private final StavkaIzvodaRepository stavkaIzvodaRepository;

    private final StavkaIzvodaMapper stavkaIzvodaMapper;

    public StavkaIzvodaServiceImpl(StavkaIzvodaRepository stavkaIzvodaRepository, StavkaIzvodaMapper stavkaIzvodaMapper) {
        this.stavkaIzvodaRepository = stavkaIzvodaRepository;
        this.stavkaIzvodaMapper = stavkaIzvodaMapper;
    }

    @Override
    public StavkaIzvodaDTO save(StavkaIzvodaDTO stavkaIzvodaDTO) {
        log.debug("Request to save StavkaIzvoda : {}", stavkaIzvodaDTO);
        StavkaIzvoda stavkaIzvoda = stavkaIzvodaMapper.toEntity(stavkaIzvodaDTO);
        stavkaIzvoda = stavkaIzvodaRepository.save(stavkaIzvoda);
        return stavkaIzvodaMapper.toDto(stavkaIzvoda);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<StavkaIzvodaDTO> findAll(String svrhaPlacanja, int pageNum) {
        log.debug("Request to get all");
        Page<StavkaIzvodaDTO> stavke = stavkaIzvodaRepository
                .findBySvrhaPlacanja(svrhaPlacanja, PageRequest.of(pageNum, 10))
                .map(StavkaIzvodaDTO::fromEntity);;
        return stavke;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<StavkaIzvodaDTO> findOne(Long id) {
        log.debug("Request to get StavkaIzvoda : {}", id);
        return stavkaIzvodaRepository.findById(id).map(stavkaIzvodaMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete StavkaIzvoda : {}", id);
        stavkaIzvodaRepository.deleteById(id);
    }
}
