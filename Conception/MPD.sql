CREATE DATABASE IF NOT EXISTS ecf_back;

USE ecf_back;

CREATE TABLE IF NOT EXISTS departement
(
    id_departement  INT AUTO_INCREMENT,
    nom_departement VARCHAR(50),
    PRIMARY KEY (id_departement)
);

CREATE TABLE IF NOT EXISTS enseignant
(
    matricule_enseignant  INT AUTO_INCREMENT,
    nom_enseignant        VARCHAR(50) NOT NULL,
    prenom_enseignant     VARCHAR(50),
    age_enseignant        INT,
    grade_enseignant      VARCHAR(50),
    prof_princ_enseignant BOOLEAN,
    responsable_departement BOOLEAN,
    id_departement        INT         NOT NULL,
    PRIMARY KEY (matricule_enseignant),
    FOREIGN KEY (id_departement) REFERENCES departement (id_departement)
);

CREATE TABLE IF NOT EXISTS matiere
(
    id_matiere          INT AUTO_INCREMENT,
    intitule_matiere    VARCHAR(50),
    description_matiere VARCHAR(50),
    duree_matiere       INT,
    coefficient_matiere VARCHAR(50),
    PRIMARY KEY (id_matiere)
);

CREATE TABLE IF NOT EXISTS classe
(
    id_classe     INT AUTO_INCREMENT,
    nom_classe    VARCHAR(50),
    niveau_classe VARCHAR(50),
    PRIMARY KEY (id_classe)
);

CREATE TABLE IF NOT EXISTS etudiant
(
    id_etudiant             INT AUTO_INCREMENT,
    nom_etudiant            VARCHAR(50) NOT NULL,
    prenom_etudiant         VARCHAR(50),
    date_naissance_etudiant DATE,
    email_etudiant          VARCHAR(50),
    id_classe               INT,
    PRIMARY KEY (id_etudiant),
    FOREIGN KEY (id_classe) REFERENCES classe (id_classe)
);

CREATE TABLE IF NOT EXISTS note
(
    id_note          INT AUTO_INCREMENT,
    valeur_note      DECIMAL(4, 2),
    commentaire_note VARCHAR(50),
    id_matiere       INT NOT NULL,
    id_etudiant      INT NOT NULL,
    PRIMARY KEY (id_note),
    FOREIGN KEY (id_matiere) REFERENCES matiere (id_matiere),
    FOREIGN KEY (id_etudiant) REFERENCES etudiant (id_etudiant)
);

CREATE TABLE IF NOT EXISTS enseignant_matiere
(
    matricule_enseignant INT,
    id_matiere           INT,
    PRIMARY KEY (matricule_enseignant, id_matiere),
    FOREIGN KEY (matricule_enseignant) REFERENCES enseignant (matricule_enseignant),
    FOREIGN KEY (id_matiere) REFERENCES matiere (id_matiere)
);

CREATE TABLE IF NOT EXISTS enseignant_classe
(
    matricule_enseignant INT,
    id_classe            INT,
    PRIMARY KEY (matricule_enseignant, id_classe),
    FOREIGN KEY (matricule_enseignant) REFERENCES enseignant (matricule_enseignant),
    FOREIGN KEY (id_classe) REFERENCES classe (id_classe)
);

CREATE TABLE IF NOT EXISTS emploi_du_temps
(
    id_matiere            INT,
    id_etudiant           INT,
    date_emploi_du_temps  DATE,
    heure_emploi_du_temps TIME,
    PRIMARY KEY (id_matiere, id_etudiant),
    FOREIGN KEY (id_matiere) REFERENCES matiere (id_matiere),
    FOREIGN KEY (id_etudiant) REFERENCES etudiant (id_etudiant)
);