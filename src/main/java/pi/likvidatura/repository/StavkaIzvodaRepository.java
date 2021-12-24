package pi.likvidatura.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import pi.likvidatura.domain.IzlaznaFaktura;
import pi.likvidatura.domain.StavkaIzvoda;

/**
 * Spring Data SQL repository for the StavkaIzvoda entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StavkaIzvodaRepository extends JpaRepository<StavkaIzvoda, Long> {
    @Query("SELECT f FROM StavkaIzvoda f WHERE "
            + "f.svrhaPlacanja like %:svrhaPlacanja%")
    Page<StavkaIzvoda> findBySvrhaPlacanja(String svrhaPlacanja, Pageable pageable);
}
