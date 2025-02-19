/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 12                       */
/* Created on:     28/12/2022 12:34:32                          */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_AUTEURS_GENERALIS_PERSONNE') then
    alter table Auteurs
       delete foreign key FK_AUTEURS_GENERALIS_PERSONNE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MATERIEL_AUTMAT_AUTEURS') then
    alter table Materiels
       delete foreign key FK_MATERIEL_AUTMAT_AUTEURS
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MATERIEL_MATCAT_CATEGORI') then
    alter table Materiels
       delete foreign key FK_MATERIEL_MATCAT_CATEGORI
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MATERIEL_TYPEMAT_TYPESMAT') then
    alter table Materiels
       delete foreign key FK_MATERIEL_TYPEMAT_TYPESMAT
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_USERS_GENERALIS_PERSONNE') then
    alter table Users
       delete foreign key FK_USERS_GENERALIS_PERSONNE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_USERS_PROFILEUS_PROFILES') then
    alter table Users
       delete foreign key FK_USERS_PROFILEUS_PROFILES
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ASSOCIAT_USERMATER_MATERIEL') then
    alter table association2
       delete foreign key FK_ASSOCIAT_USERMATER_MATERIEL
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ASSOCIAT_USERMATER_USERS') then
    alter table association2
       delete foreign key FK_ASSOCIAT_USERMATER_USERS
end if;

drop index if exists Auteurs.AUTEURS_PK;

drop table if exists Auteurs;

drop index if exists Categories.CATEGORIES_PK;

drop table if exists Categories;

drop index if exists Materiels.AUTMAT_FK;

drop index if exists Materiels.MATCAT_FK;

drop index if exists Materiels.TYPEMAT_FK;

drop index if exists Materiels.MATERIELS_PK;

drop table if exists Materiels;

drop index if exists Personnes.PERSONNES_PK;

drop table if exists Personnes;

drop index if exists Profiles.PROFILES_PK;

drop table if exists Profiles;

drop index if exists TypesMateriels.TYPESMATERIELS_PK;

drop table if exists TypesMateriels;

drop index if exists Users.GENERALISATION_1_FK;

drop index if exists Users.PROFILEUSER_FK;

drop index if exists Users.USERS_PK;

drop table if exists Users;

drop index if exists association2.USERMATERIEL_FK2;

drop index if exists association2.USERMATERIEL_FK;

drop index if exists association2.ASSOCIATION2_PK;

drop table if exists association2;

/*==============================================================*/
/* Table: Auteurs                                               */
/*==============================================================*/
create table Auteurs 
(
   idPersonne           integer                        not null,
   constraint PK_AUTEURS primary key clustered (idPersonne)
);

/*==============================================================*/
/* Index: AUTEURS_PK                                            */
/*==============================================================*/
create unique clustered index AUTEURS_PK on Auteurs (
idPersonne ASC
);

/*==============================================================*/
/* Table: Categories                                            */
/*==============================================================*/
create table Categories 
(
   idCat                integer                        not null,
   libelleCat           varchar(254)                   null,
   imageCat             varchar(254)                   null,
   constraint PK_CATEGORIES primary key (idCat)
);

/*==============================================================*/
/* Index: CATEGORIES_PK                                         */
/*==============================================================*/
create unique index CATEGORIES_PK on Categories (
idCat ASC
);

/*==============================================================*/
/* Table: Materiels                                             */
/*==============================================================*/
create table Materiels 
(
   idCat                integer                        not null,
   idMat                integer                        not null,
   idType               integer                        not null,
   idPersonne           integer                        not null,
   nomMat               varchar(254)                   null,
   photoMat             varchar(254)                   null,
   descriptionMat       varchar(254)                   null,
   constraint PK_MATERIELS primary key (idCat, idMat)
);

/*==============================================================*/
/* Index: MATERIELS_PK                                          */
/*==============================================================*/
create unique index MATERIELS_PK on Materiels (
idCat ASC,
idMat ASC
);

/*==============================================================*/
/* Index: TYPEMAT_FK                                            */
/*==============================================================*/
create index TYPEMAT_FK on Materiels (
idType ASC
);

/*==============================================================*/
/* Index: MATCAT_FK                                             */
/*==============================================================*/
create index MATCAT_FK on Materiels (
idCat ASC
);

/*==============================================================*/
/* Index: AUTMAT_FK                                             */
/*==============================================================*/
create index AUTMAT_FK on Materiels (
idPersonne ASC
);

/*==============================================================*/
/* Table: Personnes                                             */
/*==============================================================*/
create table Personnes 
(
   idPersonne           integer                        not null,
   nomPersonne          varchar(254)                   null,
   prenomPersonne       varchar(254)                   null,
   dateNaissancePersonne timestamp                      null,
   nationalitePersonne  varchar(254)                   null,
   photoPersonne        varchar(254)                   null,
   constraint PK_PERSONNES primary key (idPersonne)
);

/*==============================================================*/
/* Index: PERSONNES_PK                                          */
/*==============================================================*/
create unique index PERSONNES_PK on Personnes (
idPersonne ASC
);

/*==============================================================*/
/* Table: Profiles                                              */
/*==============================================================*/
create table Profiles 
(
   idProfile            integer                        not null,
   libelleProfile       varchar(254)                   null,
   constraint PK_PROFILES primary key (idProfile)
);

/*==============================================================*/
/* Index: PROFILES_PK                                           */
/*==============================================================*/
create unique index PROFILES_PK on Profiles (
idProfile ASC
);

/*==============================================================*/
/* Table: TypesMateriels                                        */
/*==============================================================*/
create table TypesMateriels 
(
   idType               integer                        not null,
   libelleType          varchar(254)                   null,
   constraint PK_TYPESMATERIELS primary key (idType)
);

/*==============================================================*/
/* Index: TYPESMATERIELS_PK                                     */
/*==============================================================*/
create unique index TYPESMATERIELS_PK on TypesMateriels (
idType ASC
);

/*==============================================================*/
/* Table: Users                                                 */
/*==============================================================*/
create table Users 
(
   idPersonne           integer                        not null,
   idUser               integer                        not null,
   idProfile            integer                        not null,
   "login"              varchar(254)                   null,
   password             varchar(254)                   null,
   email                varchar(254)                   null,
   cin                  varchar(254)                   null,
   constraint PK_USERS primary key (idPersonne, idUser)
);

/*==============================================================*/
/* Index: USERS_PK                                              */
/*==============================================================*/
create unique index USERS_PK on Users (
idPersonne ASC,
idUser ASC
);

/*==============================================================*/
/* Index: PROFILEUSER_FK                                        */
/*==============================================================*/
create index PROFILEUSER_FK on Users (
idProfile ASC
);

/*==============================================================*/
/* Index: GENERALISATION_1_FK                                   */
/*==============================================================*/
create index GENERALISATION_1_FK on Users (
idPersonne ASC
);

/*==============================================================*/
/* Table: Emprunts */
/*==============================================================*/
create table Emprunts
(
   idPersonne           integer                        not null,
   idUser               integer                        not null,
   idCat                integer                        not null,
   idMat                integer                        not null,
   idEmprunt            integer                        not null,
   dateEmprunt          timestamp                      null,
   dureeEmprunt         integer                        null,
   dateRetour           timestamp                      null,
   constraint PK_ASSOCIATION2 primary key (idPersonne, idUser, idCat, idMat, idEmprunt)
);

/*==============================================================*/
/* Index: ASSOCIATION2_PK                                       */
/*==============================================================*/
create unique index ASSOCIATION2_PK on association2 (
idPersonne ASC,
idUser ASC,
idCat ASC,
idMat ASC,
idEmprunt ASC
);

/*==============================================================*/
/* Index: USERMATERIEL_FK                                       */
/*==============================================================*/
create index USERMATERIEL_FK on association2 (
idPersonne ASC,
idUser ASC
);

/*==============================================================*/
/* Index: USERMATERIEL_FK2                                      */
/*==============================================================*/
create index USERMATERIEL_FK2 on association2 (
idCat ASC,
idMat ASC
);

alter table Auteurs
   add constraint FK_AUTEURS_GENERALIS_PERSONNE foreign key (idPersonne)
      references Personnes (idPersonne)
      on update restrict
      on delete restrict;

alter table Materiels
   add constraint FK_MATERIEL_AUTMAT_AUTEURS foreign key (idPersonne)
      references Auteurs (idPersonne)
      on update restrict
      on delete restrict;

alter table Materiels
   add constraint FK_MATERIEL_MATCAT_CATEGORI foreign key (idCat)
      references Categories (idCat)
      on update restrict
      on delete restrict;

alter table Materiels
   add constraint FK_MATERIEL_TYPEMAT_TYPESMAT foreign key (idType)
      references TypesMateriels (idType)
      on update restrict
      on delete restrict;

alter table Users
   add constraint FK_USERS_GENERALIS_PERSONNE foreign key (idPersonne)
      references Personnes (idPersonne)
      on update restrict
      on delete restrict;

alter table Users
   add constraint FK_USERS_PROFILEUS_PROFILES foreign key (idProfile)
      references Profiles (idProfile)
      on update restrict
      on delete restrict;

alter table association2
   add constraint FK_ASSOCIAT_USERMATER_MATERIEL foreign key (idCat, idMat)
      references Materiels (idCat, idMat)
      on update restrict
      on delete restrict;

alter table association2
   add constraint FK_ASSOCIAT_USERMATER_USERS foreign key (idPersonne, idUser)
      references Users (idPersonne, idUser)
      on update restrict
      on delete restrict;

