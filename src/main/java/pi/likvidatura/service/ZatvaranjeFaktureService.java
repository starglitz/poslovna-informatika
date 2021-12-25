package pi.likvidatura.service;

import org.springframework.data.domain.Page;
import pi.likvidatura.service.dto.StavkaIzvodaDTO;
import pi.likvidatura.service.dto.ZatvaranjeFaktureDTO;

import java.util.Optional;

public interface ZatvaranjeFaktureService {

    ZatvaranjeFaktureDTO save(ZatvaranjeFaktureDTO zatvaranjeFaktureDTO);

    Page<ZatvaranjeFaktureDTO> findAll(int pageNum);

    Optional<ZatvaranjeFaktureDTO> findOne(Long id);
}
