package pi.likvidatura.service;

import java.util.List;
import java.util.Optional;
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
    List<IzlaznaFakturaDTO> findAll();

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
}
