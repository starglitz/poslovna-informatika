package pi.likvidatura.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pi.likvidatura.repository.StavkaIzvodaRepository;
import pi.likvidatura.service.StavkaIzvodaService;
import pi.likvidatura.service.dto.StavkaIzvodaDTO;

/**
 * REST controller for managing {@link pi.likvidatura.domain.StavkaIzvoda}.
 */
@CrossOrigin
@RestController
@RequestMapping("/api/stavke-izvoda")
public class StavkaIzvodaController {

    private final Logger log = LoggerFactory.getLogger(StavkaIzvodaController.class);

    private final StavkaIzvodaService stavkaIzvodaService;

    private final StavkaIzvodaRepository stavkaIzvodaRepository;

    public StavkaIzvodaController(StavkaIzvodaService stavkaIzvodaService, StavkaIzvodaRepository stavkaIzvodaRepository) {
        this.stavkaIzvodaService = stavkaIzvodaService;
        this.stavkaIzvodaRepository = stavkaIzvodaRepository;
    }

    @PostMapping()
    public ResponseEntity<StavkaIzvodaDTO> createStavkaIzvoda(@RequestBody StavkaIzvodaDTO stavkaIzvodaDTO) throws URISyntaxException {
        log.debug("REST request to save StavkaIzvoda : {}", stavkaIzvodaDTO);
        if (stavkaIzvodaDTO.getId() != null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        StavkaIzvodaDTO result = stavkaIzvodaService.save(stavkaIzvodaDTO);
        return ResponseEntity
            .created(new URI("/api/stavke-izvoda/" + result.getId()))
            .body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StavkaIzvodaDTO> updateStavkaIzvoda(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody StavkaIzvodaDTO stavkaIzvodaDTO
    ) throws URISyntaxException {
        log.debug("REST request to update StavkaIzvoda : {}, {}", id, stavkaIzvodaDTO);
        if (stavkaIzvodaDTO.getId() == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!Objects.equals(id, stavkaIzvodaDTO.getId())) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (!stavkaIzvodaRepository.existsById(id)) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        StavkaIzvodaDTO result = stavkaIzvodaService.save(stavkaIzvodaDTO);
        return ResponseEntity
            .ok()
            .body(result);
    }

    
    @GetMapping()
    public Page<StavkaIzvodaDTO> getAllStavkeIzvoda(
            @RequestParam(defaultValue="") String svrhaPlacanja,
            @RequestParam(defaultValue="0") int pageNum) {
        log.debug("REST request to get all");
        return stavkaIzvodaService.findAll(svrhaPlacanja, pageNum);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StavkaIzvodaDTO> getStavkaIzvoda(@PathVariable Long id) {
        log.debug("REST request to get StavkaIzvoda : {}", id);
        Optional<StavkaIzvodaDTO> stavkaIzvodaDTO = stavkaIzvodaService.findOne(id);
        if(stavkaIzvodaDTO.isEmpty()) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity
                .ok()
                .body(stavkaIzvodaDTO.get());
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStavkaIzvoda(@PathVariable Long id) {
        log.debug("REST request to delete StavkaIzvoda : {}", id);
        stavkaIzvodaService.delete(id);
        return ResponseEntity
            .noContent()
            .build();
    }
}
