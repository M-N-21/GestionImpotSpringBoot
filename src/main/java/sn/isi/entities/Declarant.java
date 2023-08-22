package sn.isi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Declarant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String raisonSociale;
    @Column(nullable = false, length = 100)
    private String adresse;
    @Column(unique = true, nullable = false, length = 100)
    private String email;
    @Column(nullable = false, length = 20)
    private String telephone;
    @JsonManagedReference
    @OneToMany(mappedBy = "declarant")
    private List<Declaration> declarations;
}
