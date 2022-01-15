package pi.likvidatura.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import pi.likvidatura.domain.IzlaznaFaktura;

import java.util.List;

/**
 * Spring Data SQL repository for the IzlaznaFaktura entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IzlaznaFakturaRepository extends JpaRepository<IzlaznaFaktura, Long> {

    @Query("SELECT f FROM IzlaznaFaktura f WHERE "
            + "f.brojFakture like %:brojFakture% and f.zatvorena = false")
    Page<IzlaznaFaktura> findByBrojFaktureNezatvorene(String brojFakture, Pageable pageable);

    @Query("SELECT f FROM IzlaznaFaktura f WHERE "
            + "f.poslovniPartner.id = :poslovniPartnerId")
    List<IzlaznaFaktura> findByPoslovniPartner(Long poslovniPartnerId);
}
