package sn.isi.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.Paiement;

public interface IPaiementRepository extends JpaRepository<Paiement, Long> {
}
