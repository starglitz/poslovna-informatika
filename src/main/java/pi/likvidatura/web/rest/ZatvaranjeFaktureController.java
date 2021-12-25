package pi.likvidatura.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.likvidatura.service.ZatvaranjeFaktureService;
import pi.likvidatura.service.dto.StavkaIzvodaDTO;
import pi.likvidatura.service.dto.ZatvaranjeFaktureDTO;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/zatvaranje-fakture")
public class ZatvaranjeFaktureController {

    private final Logger log = LoggerFactory.getLogger(StavkaIzvodaController.class);

    @Autowired
    private ZatvaranjeFaktureService zatvaranjeFaktureService;

    @GetMapping()
    public Page<ZatvaranjeFaktureDTO> getAllZatvaranja(
            @RequestParam(defaultValue="0") int pageNum) {
        log.debug("REST request to get all");
        return zatvaranjeFaktureService.findAll(pageNum);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZatvaranjeFaktureDTO> getZatvaranje(@PathVariable Long id) {
        log.debug("REST request to get Zatvaranje Fakture : {}", id);
        Optional<ZatvaranjeFaktureDTO> zatvaranjeFaktureDTO = zatvaranjeFaktureService.findOne(id);
        if(zatvaranjeFaktureDTO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity
                .ok()
                .body(zatvaranjeFaktureDTO.get());
    }
}
