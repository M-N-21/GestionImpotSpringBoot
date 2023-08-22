package sn.isi.mapping;

import org.mapstruct.Mapper; 
import sn.isi.dto.DeclarantDto;
import sn.isi.entities.Declarant;

@Mapper
public interface DeclarantMapper {
    DeclarantDto toDeclarantDto(Declarant declarant);
    Declarant toDeclarant(DeclarantDto declarantDto);
}
