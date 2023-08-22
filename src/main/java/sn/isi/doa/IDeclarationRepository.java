package sn.isi.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.Declaration;

public interface IDeclarationRepository extends JpaRepository<Declaration, Long> {
   
}
