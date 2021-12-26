package pi.likvidatura.service;

import org.springframework.data.domain.Page;
import pi.likvidatura.service.dto.StavkaIzvodaDTO;
import pi.likvidatura.service.dto.ZatvaranjeFaktureDTO;

import java.util.List;
import java.util.Optional;

public interface ZatvaranjeFaktureService {

    ZatvaranjeFaktureDTO zatvoriFakturu(ZatvaranjeFaktureDTO zatvaranjeFaktureDTO);

    List<ZatvaranjeFaktureDTO> findAll(Long fakturaId, Long stavkaId);

    Optional<ZatvaranjeFaktureDTO> findOne(Long id);
}
