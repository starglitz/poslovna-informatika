package pi.likvidatura.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pi.likvidatura.service.PoslovniPartnerService;
import pi.likvidatura.service.dto.PoslovnaGodinaDTO;
import pi.likvidatura.service.dto.PoslovniPartnerDTO;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/poslovni-partneri")
public class PoslovniPartnerController {

    private final Logger log = LoggerFactory.getLogger(PoslovniPartnerController.class);

    @Autowired
    private PoslovniPartnerService poslovniPartnerService;

    @GetMapping()
    public List<PoslovniPartnerDTO> getAllPartneri() {
        log.debug("REST request to get all");
        return poslovniPartnerService.getAll();
    }
}
