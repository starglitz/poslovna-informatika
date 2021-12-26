package pi.likvidatura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pi.likvidatura.domain.PoslovniPartner;
import pi.likvidatura.domain.Preduzece;

public interface PoslovniPartnerRepository extends JpaRepository<PoslovniPartner, Long> {
}
