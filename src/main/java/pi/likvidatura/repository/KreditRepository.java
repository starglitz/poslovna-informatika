package pi.likvidatura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pi.likvidatura.domain.Kredit;

public interface KreditRepository extends JpaRepository<Kredit, Long> {
}
