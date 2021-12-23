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
import pi.likvidatura.domain.IzlaznaFaktura;
import pi.likvidatura.repository.IzlaznaFakturaRepository;
import pi.likvidatura.service.IzlaznaFakturaService;
import pi.likvidatura.service.dto.IzlaznaFakturaDTO;
import pi.likvidatura.service.mapper.IzlaznaFakturaMapper;

/**
 * Service Implementation for managing {@link IzlaznaFaktura}.
 */
@Service
@Transactional
public class IzlaznaFakturaServiceImpl implements IzlaznaFakturaService {

    private final Logger log = LoggerFactory.getLogger(IzlaznaFakturaServiceImpl.class);

    private final IzlaznaFakturaRepository izlaznaFakturaRepository;

    private final IzlaznaFakturaMapper izlaznaFakturaMapper;

    public IzlaznaFakturaServiceImpl(IzlaznaFakturaRepository izlaznaFakturaRepository, IzlaznaFakturaMapper izlaznaFakturaMapper) {
        this.izlaznaFakturaRepository = izlaznaFakturaRepository;
        this.izlaznaFakturaMapper = izlaznaFakturaMapper;
    }

    @Override
    public IzlaznaFakturaDTO save(IzlaznaFakturaDTO izlaznaFakturaDTO) {
        log.debug("Request to save IzlaznaFaktura : {}", izlaznaFakturaDTO);
        IzlaznaFaktura izlaznaFaktura = izlaznaFakturaMapper.toEntity(izlaznaFakturaDTO);
        izlaznaFaktura = izlaznaFakturaRepository.save(izlaznaFaktura);
        return izlaznaFakturaMapper.toDto(izlaznaFaktura);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<IzlaznaFakturaDTO> findAll(String brojFakture, int pageNum) {
        log.debug("Request to get all");
        Page<IzlaznaFakturaDTO> fakture = izlaznaFakturaRepository
                .findByBrojFakture(brojFakture, PageRequest.of(pageNum, 10))
                .map(IzlaznaFakturaDTO::fromEntity);;

        return fakture;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<IzlaznaFakturaDTO> findOne(Long id) {
        log.debug("Request to get IzlaznaFaktura : {}", id);
        return izlaznaFakturaRepository.findById(id).map(izlaznaFakturaMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete IzlaznaFaktura : {}", id);
        izlaznaFakturaRepository.deleteById(id);
    }
}
