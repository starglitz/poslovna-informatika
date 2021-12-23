package pi.likvidatura.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import pi.likvidatura.domain.IzlaznaFaktura;

/**
 * Spring Data SQL repository for the IzlaznaFaktura entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IzlaznaFakturaRepository extends JpaRepository<IzlaznaFaktura, Long> {

    @Query("SELECT f FROM IzlaznaFaktura f WHERE "
            + "f.brojFakture like %:brojFakture%")
    public Page<IzlaznaFaktura> findByBrojFakture(String brojFakture, Pageable pageable);
}
