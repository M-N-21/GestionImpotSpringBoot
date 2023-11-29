package sn.isi.mapping;

import org.mapstruct.Mapper; 
import sn.isi.dto.DeclarationDto;
import sn.isi.entities.Declaration;

@Mapper
public interface DeclarationMapper {
    DeclarationDto toDeclarationDto(Declaration declaration);
    Declaration toDeclaration(DeclarationDto declarationDto);
}
