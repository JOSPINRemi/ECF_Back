package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "classe")
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classe", nullable = false)
    private Integer id;

    @Column(name = "nom_classe", length = 50)
    private String nomClasse;

    @Column(name = "niveau_classe", length = 50)
    private String niveauClasse;

    @ManyToMany(mappedBy = "classes")
    private List<Enseignant> enseignants = new ArrayList<>();

    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Etudiant> etudiants = new ArrayList<>();

    public Classe() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public String getNiveauClasse() {
        return niveauClasse;
    }

    public void setNiveauClasse(String niveauClasse) {
        this.niveauClasse = niveauClasse;
    }

    public List<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(List<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "id=" + id +
                ", nomClasse='" + nomClasse + '\'' +
                ", niveauClasse='" + niveauClasse + '\'' +
                '}';
    }
}