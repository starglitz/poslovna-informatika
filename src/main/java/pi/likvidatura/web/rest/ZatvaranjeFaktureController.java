package pi.likvidatura.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.likvidatura.service.ZatvaranjeFaktureService;
import pi.likvidatura.service.dto.IzlaznaFakturaDTO;
import pi.likvidatura.service.dto.StavkaIzvodaDTO;
import pi.likvidatura.service.dto.ZatvaranjeFaktureDTO;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/zatvaranje-fakture")
public class ZatvaranjeFaktureController {

    private final Logger log = LoggerFactory.getLogger(StavkaIzvodaController.class);

    @Autowired
    private ZatvaranjeFaktureService zatvaranjeFaktureService;

    @GetMapping()
    public List<ZatvaranjeFaktureDTO> getAllZatvaranja(
            @RequestParam(required = false) Long fakturaId,
            @RequestParam(required = false) Long stavkaId) {
        log.debug("REST request to get all");
        return zatvaranjeFaktureService.findAll(fakturaId, stavkaId);
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

    @PostMapping
    public ResponseEntity zatvoriFakturu(@RequestBody ZatvaranjeFaktureDTO zatvaranjeFaktureDTO)
            throws URISyntaxException {
        if (zatvaranjeFaktureDTO.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ZatvaranjeFaktureDTO result = zatvaranjeFaktureService.zatvoriFakturu(zatvaranjeFaktureDTO);
        return ResponseEntity
                .created(new URI("/api/zatvaranje-fakture/" + result.getId()))
                .body(result);
    }
}
