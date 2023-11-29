package sn.isi.mapping;

import org.mapstruct.Mapper; 
import sn.isi.dto.PaiementDto;
import sn.isi.entities.Paiement;

@Mapper
public interface PaiementMapper {
    PaiementDto toPaiementDto(Paiement paiement);
    Paiement toPaiement(PaiementDto paiementDto);
}
