package pi.likvidatura.service;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;

import com.itextpdf.text.DocumentException;
import org.springframework.data.domain.Page;
import pi.likvidatura.service.dto.IzlaznaFakturaDTO;


/**
 * Service Interface for managing {@link pi.likvidatura.domain.IzlaznaFaktura}.
 */
public interface IzlaznaFakturaService {
    /**
     * Save a izlaznaFaktura.
     *
     * @param izlaznaFakturaDTO the entity to save.
     * @return the persisted entity.
     */
    IzlaznaFakturaDTO save(IzlaznaFakturaDTO izlaznaFakturaDTO);

    /**
     * Get all the izlaznaFakturas.
     *
     * @return the list of entities.
     */
    Page<IzlaznaFakturaDTO> findAll(String brojFakture, int pageNum);

    /**
     * Get the "id" izlaznaFaktura.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<IzlaznaFakturaDTO> findOne(Long id);

    /**
     * Delete the "id" izlaznaFaktura.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    ByteArrayInputStream generatePdf(Long poslovniPartnerId) throws DocumentException, FileNotFoundException;
}
