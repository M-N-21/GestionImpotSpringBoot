package sn.isi.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Declaration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    Date dateDeclaration;
    @Column(nullable = false)
    Double montantDeclaration;
    @JsonBackReference
    @ManyToOne
    Declarant declarant;
    @JsonManagedReference
    @OneToMany(mappedBy = "declaration")
    List<Paiement> paiements;
}
