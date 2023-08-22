package sn.isi.dto;

import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeclarantDto {
	private Long id;
    @NotNull(message = "La raison sociale ne doit pas etre null")
    private String raisonSociale;
    @NotNull(message = "L'adresse ne doit pas etre null")
    private String adresse;
   
    private String email;
    
    private String telephone;

}
