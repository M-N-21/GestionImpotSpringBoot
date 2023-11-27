package sn.isi.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import sn.isi.entities.Declaration;
import java.util.Date;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaiementDto {
	private Long id;
	@NotNull(message = "La date de paiement ne doit pas etre null")
    Date datePaiement;
	@NotNull(message = "Le montan payé ne doit pas etre null")
    Double montantPaiement;
	@NotNull(message = "On doit forcément savoir la declaration")
    private Declaration declaration;

}
