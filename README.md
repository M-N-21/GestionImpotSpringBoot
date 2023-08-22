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

Ce package contient des services pour chaque entité qui gèrent les opérations CRUD associées.

### `sn.isi.config`

Ce package contient des configurations pour l'application, y compris la gestion des messages sources.

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

Assurez-vous que votre projet est configuré correctement avec Spring Boot pour que ces annotations fonctionnent comme prévu.

N'hésitez pas à explorer chaque package pour plus de détails sur la structure de l'application.
