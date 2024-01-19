package controller;

import entity.*;
import service.Service;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class IHM {
    private final Service service;
    private final Scanner scanner;

    public IHM() {
        service = new Service();
        scanner = new Scanner(System.in);

    }

    public void start() {
        service.begin();
        int choice;
        do {
            menu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("Bye");
                    service.end();
                    break;
                case 1:
                    createDepartement();
                    break;
                case 2:
                    createEnseignant();
                    break;
                case 3:
                    createEtudiant();
                    break;
                case 4:
                    createMatiere();
                    break;
                case 5:
                    createNote();
                    break;
                case 6:
                    createClasse();
                    break;
                /*case 7:
                    createEmploiDuTemps();
                    break;*/
                default:
                    System.out.println("Saisie invalide");
            }
        } while (choice != 0);
    }

    private void createNote() {
        List<Matiere> matieres = service.getAllMatieres();
        if (matieres.isEmpty()) {
            System.out.println("Créez préalablement une matière");
        } else {
            List<Etudiant> etudiants = service.getAllEtudiants();
            if (etudiants.isEmpty()) {
                System.out.println("Créez préalablement un étudiant");
            } else {
                matieres.forEach(System.out::println);
                System.out.print("Saisir l'id de la matière");
                int idMatiere = scanner.nextInt();
                scanner.nextLine();
                Matiere matiere = service.getMatiereById(idMatiere);
                if (matiere == null) {
                    System.out.println("La matière avec l'id " + idMatiere + " n'existe pas");
                } else {
                    etudiants.forEach(System.out::println);
                    System.out.print("Saisir l'id de l'étudiant");
                    int idEtudiant = scanner.nextInt();
                    scanner.nextLine();
                    Etudiant etudiant = service.getEtudiantById(idEtudiant);
                    if (etudiant == null) {
                        System.out.println("L'étudiant avec l'id " + idEtudiant + " n'existe pas");
                    } else {
                        Note note = new Note();
                        note.setMatiere(matiere);
                        note.setEtudiant(etudiant);
                        System.out.print(
                                "Saisir la note de l'étudiant " +
                                        etudiant.getNomEtudiant() + " " + etudiant.getPrenomEtudiant() +
                                        "en " + matiere.getIntituleMatiere()
                        );
                        note.setValeurNote(scanner.nextBigDecimal());
                        scanner.nextLine();
                        System.out.print("Saisir le commentaire de la note : ");
                        note.setCommentaireNote(scanner.nextLine());
                        if (service.createNote(note)) {
                            matiere.getNotes().add(note);
                            etudiant.getNotes().add(note);
                            if (service.updateMatiere(matiere) && service.updateEtudiant(etudiant)) {
                                System.out.println("Note créée avec succès");
                            } else {
                                System.out.println("Problème lors de la création de la note");
                            }
                        } else {
                            System.out.println("Problème lors de la création de la note");
                        }
                    }
                }

            }
        }
    }

    private void createMatiere() {
        List<Enseignant> enseignants = service.getAllEnseignants();
        if (enseignants.isEmpty()) {
            System.out.println("Créez préalablement un enseignant");
        } else {
            enseignants.forEach(System.out::println);
            System.out.print("Saisir l'id de l'enseignant : ");
            int idEnseignant = scanner.nextInt();
            scanner.nextLine();
            Enseignant enseignant = service.getEnseignantById(idEnseignant);
            if (enseignant == null) {
                System.out.println("L'enseignant avec l'id " + idEnseignant + " n'existe pas");
            } else {
                Matiere matiere = new Matiere();
                System.out.print("Saisir l'intitulé de la matière : ");
                matiere.setIntituleMatiere(scanner.nextLine());
                System.out.print("Saisir la description de la matière : ");
                matiere.setDescriptionMatiere(scanner.nextLine());
                System.out.print("Saisir la durée de la matière (en minutes) : ");
                matiere.setDureeMatiere(scanner.nextInt());
                scanner.nextLine();
                System.out.print("Saisir le coefficient de la matière : ");
                matiere.setCoefficientMatiere(scanner.nextLine());
                if (service.createMatiere(matiere)) {
                    enseignant.getMatieres().add(matiere);
                    if (service.updateEnseignant(enseignant)) {
                        System.out.println("Matière créée avec succès");
                    } else {
                        System.out.println("Problème lors de la création de la matière");
                    }
                } else {
                    System.out.println("Problème lors de la création de la matière");
                }
            }
        }
    }

    private void createEtudiant() {
        List<Classe> classes = service.getAllClasses();
        if (classes.isEmpty()) {
            System.out.println("Créez préalablement une classe");
        } else {
            classes.forEach(System.out::println);
            System.out.print("Saisir l'id de la classe : ");
            int idClasse = scanner.nextInt();
            scanner.nextLine();
            Classe classe = service.getClasseById(idClasse);
            if (classe == null) {
                System.out.println("La classe avec l'id " + idClasse + " n'existe pas");
            } else {
                Etudiant etudiant = new Etudiant();
                System.out.print("Saisir le nom de l'étudiant : ");
                etudiant.setNomEtudiant(scanner.nextLine());
                System.out.print("Saisir le prénom de l'étudiant : ");
                etudiant.setPrenomEtudiant(scanner.nextLine());
                System.out.print("Saisir la date de naissance de l'étudiant (yyyy-MM-dd) : ");
                etudiant.setDateNaissanceEtudiant(Date.valueOf(scanner.nextLine()).toLocalDate());
                System.out.print("Saisir l'email de l'étudiant (avec @gmail.com) : ");
                try {
                    etudiant.setEmailEtudiant(scanner.nextLine());
                    etudiant.setClasse(classe);
                    if (service.createEtudiant(etudiant)) {
                        classe.getEtudiants().add(etudiant);
                        if (service.updateClasse(classe)) {
                            System.out.println("Etudiant créé avec succès");
                        } else {
                            System.out.println("Problème lors de la création de l'étudiant");
                        }
                    } else {
                        System.out.println("Problème lors de la création de l'étudiant");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        }

    }

    private void createEnseignant() {
        List<Departement> departements = service.getAllDepartements();
        if (departements.isEmpty()) {
            System.out.println("Créez préalablement un département");
        } else {
            departements.forEach(System.out::println);
            System.out.println("Saisir l'id du département :");
            int id = scanner.nextInt();
            Departement departement = service.getDepartementById(id);
            if (departement == null) {
                System.out.println("Le département avec l'id " + id + " n'existe pas");
            } else {
                Enseignant enseignant = new Enseignant();
                enseignant.setDepartement(departement);
                System.out.print("Saisir le nom de l'enseignant : ");
                enseignant.setNomEnseignant(scanner.nextLine());
                System.out.print("Saisir le prénom de l'enseignant : ");
                enseignant.setPrenomEnseignant(scanner.nextLine());
                System.out.print("Saisir l'âge de l'enseignant : ");
                enseignant.setAgeEnseignant(scanner.nextInt());
                scanner.nextLine();
                System.out.print("Saisir le grade de l'enseignant : ");
                enseignant.setGradeEnseignant(scanner.nextLine());
                System.out.println("L'enseignant est-il un professeur principal (o/n) :");
                enseignant.setProfPrincEnseignant(scanner.nextLine().equals("o"));
                System.out.println("L'enseignant est-il un responsable de département (o/n) :");
                enseignant.setResponsableDepartement(scanner.nextLine().equals("o"));
                if (service.createEnseignant(enseignant)) {
                    System.out.println("Enseignant créé avec succès");
                } else {
                    System.out.println("Problème lors de la création de l'enseignant");
                }
            }
        }
    }

    private void createEmploiDuTemps() {
//        todo : écrire la création d'un emploi du temps
//        EmploiDuTemps emploiDuTemps = new EmploiDuTemps();
//        if (service.createEmploiDuTemps(emploiDuTemps)) {
//            System.out.println("Emploi du temps créé avec succès");
//        } else {
//            System.out.println("Problème lors de la création de l'emplois du temps");
//        }
    }

    private void createDepartement() {
        Departement departement = new Departement();
        System.out.print("Saisir le nom du département : ");
        departement.setNomDepartement(scanner.nextLine());
        if (service.createDepartement(departement)) {
            System.out.println("Département créé avec succès");
        } else {
            System.out.println("Problème lors de la création du département");
        }
    }

    private void createClasse() {
        List<Enseignant> enseignants = service.getAllEnseignants();
        if (enseignants.isEmpty()) {
            System.out.println("Créez préalablement un enseignant");
        } else {
            enseignants.forEach(System.out::println);
            System.out.print("Saisir l'id de l'enseignant : ");
            int idEnseignant = scanner.nextInt();
            scanner.nextLine();
            Enseignant enseignant = service.getEnseignantById(idEnseignant);
            if (enseignant == null) {
                System.out.println("L'enseignant avec l'id " + idEnseignant + " n'existe pas");
            } else {
                Classe classe = new Classe();
                classe.getEnseignants().add(enseignant);
                System.out.print("Saisir le nom de la classe : ");
                classe.setNomClasse(scanner.nextLine());
                System.out.print("Saisir le niveau de la classe (2nd, 1ère, Terminale) : ");
                classe.setNiveauClasse(scanner.nextLine());
                if (service.createClasse(classe)) {
                    enseignant.getClasses().add(classe);
                    if (service.updateEnseignant(enseignant)) {
                        System.out.println("Classe créée avec succès");
                    } else {
                        System.out.println("Problème lors de la création de la classe");
                    }
                } else {
                    System.out.println("Problème lors de la création de la classe");
                }
            }

        }

    }

    private void menu() {
        System.out.println("Menu");
        System.out.println("1 - Créer un département");
        System.out.println("2 - Créer un enseignant");
        System.out.println("3 - Créer un étudiant");
        System.out.println("4 - Créer une matière");
        System.out.println("5 - Créer une note");
        System.out.println("6 - Créer une classe");
//        System.out.println("7 - Créer un emploi du temps");
        System.out.print("Choix : ");
    }
}
