package sn.isi.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import sn.isi.entities.Declarant;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeclarationDto {
	Long id;
	@NotNull(message = "La date de declaration ne doit pas etre null")
    Date dateDeclaration;
	@NotNull(message = "Le montant de la declaration ne doit pas etre null")
    Double montantDeclaration;
	@NotNull(message = "On doit forcément savoir le declarant")
    Declarant declarant;

}
