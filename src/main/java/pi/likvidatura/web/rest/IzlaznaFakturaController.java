package pi.likvidatura.web.rest;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pi.likvidatura.repository.IzlaznaFakturaRepository;
import pi.likvidatura.service.IzlaznaFakturaService;
import pi.likvidatura.service.dto.IzlaznaFakturaDTO;

/**
 * REST controller for managing {@link pi.likvidatura.domain.IzlaznaFaktura}.
 */

@CrossOrigin
@RestController
@RequestMapping("/api/izlazne-fakture")
public class IzlaznaFakturaController {

    private final Logger log = LoggerFactory.getLogger(IzlaznaFakturaController.class);

    private final IzlaznaFakturaService izlaznaFakturaService;
    private final IzlaznaFakturaRepository izlaznaFakturaRepository;

    public IzlaznaFakturaController(IzlaznaFakturaService izlaznaFakturaService, IzlaznaFakturaRepository izlaznaFakturaRepository) {
        this.izlaznaFakturaService = izlaznaFakturaService;
        this.izlaznaFakturaRepository = izlaznaFakturaRepository;
    }

    @PostMapping()
    public ResponseEntity<IzlaznaFakturaDTO> createIzlaznaFaktura(@RequestBody IzlaznaFakturaDTO izlaznaFakturaDTO)
        throws URISyntaxException {
        log.debug("REST request to save IzlaznaFaktura : {}", izlaznaFakturaDTO);
        if (izlaznaFakturaDTO.getId() != null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);        
        }
        IzlaznaFakturaDTO result = izlaznaFakturaService.save(izlaznaFakturaDTO);
        return ResponseEntity
            .created(new URI("/api/izlazne-fakture/" + result.getId()))
            .body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IzlaznaFakturaDTO> updateIzlaznaFaktura(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody IzlaznaFakturaDTO izlaznaFakturaDTO
    ) throws URISyntaxException {
        log.debug("REST request to update IzlaznaFaktura : {}, {}", id, izlaznaFakturaDTO);
        if (izlaznaFakturaDTO.getId() == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!Objects.equals(id, izlaznaFakturaDTO.getId())) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (!izlaznaFakturaRepository.existsById(id)) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        IzlaznaFakturaDTO result = izlaznaFakturaService.save(izlaznaFakturaDTO);
        return ResponseEntity
            .ok()
            .body(result);
    }

    @GetMapping()
    public Page<IzlaznaFakturaDTO> getAllIzlazneFakture(
            @RequestParam(defaultValue="") String brojFakture,
            @RequestParam(defaultValue="0") int pageNum) {
        log.debug("REST request to get all");
        return izlaznaFakturaService.findAll(brojFakture, pageNum);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IzlaznaFakturaDTO> getIzlaznaFaktura(@PathVariable Long id) {
        log.debug("REST request to get IzlaznaFaktura : {}", id);
        Optional<IzlaznaFakturaDTO> izlaznaFakturaDTO = izlaznaFakturaService.findOne(id);
        if(izlaznaFakturaDTO.isEmpty()) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity
                .ok()
                .body(izlaznaFakturaDTO.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIzlaznaFaktura(@PathVariable Long id) {
        log.debug("REST request to delete IzlaznaFaktura : {}", id);
        izlaznaFakturaService.delete(id);
        return ResponseEntity
            .noContent()
            .build();
    }

    @GetMapping("/pdf")
    public ResponseEntity<Object> getPdf(@RequestParam Long poslovniPartnerId)
            throws FileNotFoundException{
        var pdf = izlaznaFakturaService.generatePdf(poslovniPartnerId);
        var headers = new HttpHeaders();
        headers.setContentLength(pdf.available());
        headers.setContentType(MediaType.APPLICATION_PDF);
        var isr = new InputStreamResource(pdf);
        return new ResponseEntity(isr, headers, HttpStatus.OK);
    }
}
