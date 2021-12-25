package pi.likvidatura.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.likvidatura.domain.StavkaIzvoda;
import pi.likvidatura.domain.ZatvaranjeFakture;

@Repository
public interface ZatvaranjeFaktureRepository  extends JpaRepository<ZatvaranjeFakture, Long> {
    Page<ZatvaranjeFakture> findAll(Pageable pageable);
}
