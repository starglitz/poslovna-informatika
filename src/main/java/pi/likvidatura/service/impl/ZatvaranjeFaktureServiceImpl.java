package pi.likvidatura.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pi.likvidatura.repository.ZatvaranjeFaktureRepository;
import pi.likvidatura.service.ZatvaranjeFaktureService;
import pi.likvidatura.service.dto.StavkaIzvodaDTO;
import pi.likvidatura.service.dto.ZatvaranjeFaktureDTO;

import java.util.Optional;

@Service
@Transactional
public class ZatvaranjeFaktureServiceImpl implements ZatvaranjeFaktureService {

    @Autowired
    private ZatvaranjeFaktureRepository zatvaranjeFaktureRepository;

    private final Logger log = LoggerFactory.getLogger(StavkaIzvodaServiceImpl.class);


    @Override
    public ZatvaranjeFaktureDTO save(ZatvaranjeFaktureDTO zatvaranjeFaktureDTO) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ZatvaranjeFaktureDTO> findAll(int pageNum) {
        log.debug("Request to get all zatvaranja");
        Page<ZatvaranjeFaktureDTO> zatvaranja = zatvaranjeFaktureRepository
                .findAll(PageRequest.of(pageNum, 10))
                .map(ZatvaranjeFaktureDTO::fromEntity);
        return zatvaranja;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ZatvaranjeFaktureDTO> findOne(Long id) {
        return Optional.empty();
    }
}
