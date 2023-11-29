# Projet GestionImpo

Ce projet Spring Boot est conçu pour gérer les déclarations, les paiements et les déclarants. Il utilise Java 8 comme version requise.

## Structure du Projet

Le projet est organisé en plusieurs packages pour une meilleure séparation des préoccupations :

### `sn.isi.entities`

Ce package contient les entités JPA avec les annotations nécessaires pour la génération de la base de données.

1. `Declarant` : représente un déclarant avec les propriétés `id`, `raisonSociale`, `adresse`, `email` et `telephone`.
2. `Declaration` : représente une déclaration avec les propriétés `id`, `dateDeclaration`, `montantDeclaration` et `idDeclarant`.
3. `Paiement` : représente un paiement avec les propriétés `id`, `datePaiement`, `montantPaiement` et `idDeclaration`.

### `sn.isi.dto`

Ce package contient des classes DTO (Data Transfer Object) pour les mêmes entités sans les annotations. Cela permet d'éviter de manipuler directement les objets de la base de données dans les vues.

### `sn.isi.dao`

Ce package contient des interfaces DAO (Data Access Object) pour chaque entité qui étendent `JpaRepository` pour la gestion des opérations CRUD.

### `sn.isi.mapping`

Ce package contient des interfaces pour les mappers qui permettent de transformer chaque entité en sa correspondance DTO et vice versa.

### `sn.isi.exception`

Ce package contient des classes personnalisées pour la gestion des exceptions.

### `sn.isi.service`

Ce package contient des services pour chaque entité qui gèrent les opérations CRUD et d'autres plus personnalisés associées.

### `sn.isi.config`

Ce package contient des configurations pour l'application, y compris la gestion des messages sources.
Toutes les routes sont définis dans la classe abstraite EndPoint. Ce qui rend le code plus élégant dans les controllers

### `sn.isi.controller`

Ce package contient des RestControllers pour chaque entité pour gérer les opérations REST.

### `sn.isi`

Ce package contient la classe de base pour le démarrage de l'application Spring Boot.

## Annotations Utilisées

- Les entités JPA dans le package `sn.isi.entities` sont annotées avec `@Entity` pour indiquer qu'elles sont persistantes.
- Les interfaces DAO dans le package `sn.isi.dao` étendent `JpaRepository` et sont annotées avec `@Repository`.
- Les classes services dans le package `sn.isi.service` sont annotées avec `@Service`.
- Les RestControllers dans le package `sn.isi.controller` sont annotés avec `@RestController`.
- Les classes de configuration dans le package `sn.isi.config` sont annotées avec `@Configuration`.
- Les classes de gestion des exceptions dans le package `sn.isi.exception` peuvent utiliser des annotations telles que `@ControllerAdvice` pour gérer les exceptions globalement.

## Capture d'Écran de l'analyse sonarcloud
### Premiere analyse

![image1jkhkghjkhjkhk](https://github.com/M-N-21/GestionImpotSpringBoot/blob/master/src/main/resources/captures/sonar1.PNG)

![image1jkhkghjkhjkhk](https://github.com/M-N-21/GestionImpotSpringBoot/blob/master/src/main/resources/captures/sonar2.PNG)
### Après modification des suggestions
![image1jkhkghjkhjkhk](https://github.com/M-N-21/GestionImpotSpringBoot/blob/master/src/main/resources/captures/sonar4.PNG)

## Capture d'Écran TEST API sur Postman
### API DECLARANT
Ajout d'un déclarant
![image1jkhkghjkhjkhk](https://github.com/M-N-21/GestionImpotSpringBoot/blob/master/src/main/resources/captures/Capture1.PNG)
Récupération d'un déclarant qui existe
![image1jkhkghjkhjkhk](https://github.com/M-N-21/GestionImpotSpringBoot/blob/master/src/main/resources/captures/Capture2.PNG)
Récupération d'un déclarant qui n'existe pas
![image1jkhkghjkhjkhk](https://github.com/M-N-21/GestionImpotSpringBoot/blob/master/src/main/resources/captures/Capture3.PNG)
Modification d'un déclarant
![image1jkhkghjkhjkhk](https://github.com/M-N-21/GestionImpotSpringBoot/blob/master/src/main/resources/captures/Capture4.PNG)

### API DECLARATION
Ajout d'une déclaration
![image1jkhkghjkhjkhk](https://github.com/M-N-21/GestionImpotSpringBoot/blob/master/src/main/resources/captures/Capture5.PNG)
Récupération d'une déclaration qui existe
![image1jkhkghjkhjkhk](https://github.com/M-N-21/GestionImpotSpringBoot/blob/master/src/main/resources/captures/Capture6.PNG)
Récupération d'une déclaration qui n'existe pas
![image1jkhkghjkhjkhk](https://github.com/M-N-21/GestionImpotSpringBoot/blob/master/src/main/resources/captures/Capture7.PNG)
Suppression d'une déclaration
![image1jkhkghjkhjkhk](https://github.com/M-N-21/GestionImpotSpringBoot/blob/master/src/main/resources/captures/Capture8.PNG)

### API Paiement (Particularité plusieurs paiements possible pour une déclaration)
Code pour gerer cela sans pour autant dépasser le montant de la déclaration. Voir dans les services `sn.isi.service` le service `PaiementService.java`
![image1jkhkghjkhjkhk](https://github.com/M-N-21/GestionImpotSpringBoot/blob/master/src/main/resources/captures/Capture9.PNG)
![image1jkhkghjkhjkhk](https://github.com/M-N-21/GestionImpotSpringBoot/blob/master/src/main/resources/captures/Capture10.PNG)
Ajout d'un paiement sans probleme avec le montant de la declaration
![image1jkhkghjkhjkhk](https://github.com/M-N-21/GestionImpotSpringBoot/blob/master/src/main/resources/captures/Capture11.PNG)
Ajout d'un paiement pour la declaration numero 7 dont le montant est `300 000` avec un premier paiement `200 000` donc il ne reste que `100 000`. On va essayer d'ajouter un paiement de plus de `100 000` qui ne va normalement pas passer.
![image1jkhkghjkhjkhk](https://github.com/M-N-21/GestionImpotSpringBoot/blob/master/src/main/resources/captures/Capture12.PNG)
Ce qui déclenche une erreur personnalisée
![image1jkhkghjkhjkhk](https://github.com/M-N-21/GestionImpotSpringBoot/blob/master/src/main/resources/captures/Capture13.PNG)
![image1jkhkghjkhjkhk](https://github.com/M-N-21/GestionImpotSpringBoot/blob/master/src/main/resources/captures/Capture14.PNG)
Et là si on fait un paiement de 100 000 ou moins ça passe.
![image1jkhkghjkhjkhk](https://github.com/M-N-21/GestionImpotSpringBoot/blob/master/src/main/resources/captures/Capture16.PNG)
Récupération d'un paiement qui n'existe pas
![image1jkhkghjkhjkhk](https://github.com/M-N-21/GestionImpotSpringBoot/blob/master/src/main/resources/captures/Capture15.PNG)
Suppression d'un paiement
![image1jkhkghjkhjkhk](https://github.com/M-N-21/GestionImpotSpringBoot/blob/master/src/main/resources/captures/Capture17.PNG)

### A propos des endpoints tous mettre sur une classe abstraite et les appeller au besoin
```
package sn.isi.config;

public abstract class EndPoint {
	//	DECLARANT
	public static final String DECLARANT = "/declarant";
	public static final String ADD_DECLARANT = "/addDeclarant";
	public static final String GET_DECLARANT_BY_ID = "/getDeclarantById/{id}";
	public static final String GET_DECLARANT_LIST = "/listDeclarant";
	public static final String DELETE_DECLARANT = "/deleteDeclarant/{id}";
	public static final String UPDATE_DECLARANT = "/updateDeclarant/{id}";
	
//	DECLARATION
	public static final String DECLARATION = "/declaration";
	public static final String ADD_DECLARATION = "/addDeclaration";
	public static final String GET_DECLARATION_BY_ID = "/getDeclarationById/{id}";
	public static final String GET_DECLARATION_LIST = "/listDeclaration";
	public static final String DELETE_DECLARATION = "/deleteDeclaration/{id}";
	public static final String UPDATE_DECLARATION = "/updateDeclaration/{id}";
	
//	PAIEMENT
	public static final String PAIEMENT = "/paiement";
	public static final String ADD_PAIEMENT = "/addPaiement";
	public static final String GET_PAIEMENT_BY_ID = "/getPaiementById/{id}";
	public static final String GET_PAIEMENT_LIST = "/listPaiement";
	public static final String DELETE_PAIEMENT = "/deletePaiement/{id}";
	public static final String UPDATE_PAIEMENT = "/updatePaiement/{id}";
}
```
### Integration dans le controller DeclarantController
```
package sn.isi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import sn.isi.config.EndPoint;
import sn.isi.dto.DeclarantDto;
import sn.isi.service.DeclarantService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = EndPoint.DECLARANT)
@AllArgsConstructor
public class DeclarantController {
    private DeclarantService declarantService;

    @GetMapping(value = EndPoint.GET_DECLARANT_LIST)
    public List<DeclarantDto> getDeclarant() {
        return declarantService.getDeclarants();
    }

    @GetMapping(value = EndPoint.GET_DECLARANT_BY_ID)
    public DeclarantDto getDeclarant(@PathVariable("id") Long id) {
        return declarantService.getDeclarant(id);
    }

    @PostMapping(value = EndPoint.ADD_DECLARANT)
    @ResponseStatus(code = HttpStatus.CREATED)
    public DeclarantDto createDeclarant(@Valid @RequestBody DeclarantDto declarantDto) {
        return declarantService.createDeclarant(declarantDto);
    }

    @PutMapping(value = EndPoint.UPDATE_DECLARANT)
    public DeclarantDto updateDeclarant(@PathVariable("id") Long id, @Valid @RequestBody DeclarantDto declarantDto) {
        return declarantService.updateDeclarant(id, declarantDto);
    }

    @DeleteMapping(value = EndPoint.DELETE_DECLARANT)
    public void deleteDeclarant(@PathVariable("id") Long id) {
        declarantService.deleteDeclarant(id);
    }
}

```
Assurez-vous que votre projet est configuré correctement avec Spring Boot pour que ces annotations fonctionnent comme prévu.

N'hésitez pas à explorer chaque package pour plus de détails sur la structure de l'application.
