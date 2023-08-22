package sn.isi.doa;

import org.springframework.data.jpa.repository.JpaRepository; 
import sn.isi.entities.Declarant;

public interface IDeclarantRepository extends JpaRepository<Declarant, Long> {
	Declarant findByEmail(String email);
}
