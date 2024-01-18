package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "enseignant")
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matricule_enseignant", nullable = false)
    private Integer id;

    @Column(name = "nom_enseignant", nullable = false, length = 50)
    private String nomEnseignant;

    @Column(name = "prenom_enseignant", length = 50)
    private String prenomEnseignant;

    @Column(name = "age_enseignant")
    private Integer ageEnseignant;

    @Column(name = "grade_enseignant", length = 50)
    private String gradeEnseignant;

    @Column(name = "prof_princ_enseignant")
    private Boolean profPrincEnseignant;

    @Column(name = "responsable_departement")
    private Boolean responsableDepartement;

    @ManyToOne
    @JoinColumn(name = "id_departement", nullable = false)
    private Departement departement;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "enseignant_classe",
            joinColumns = @JoinColumn(name = "matricule_enseignant"),
            inverseJoinColumns = @JoinColumn(name = "id_classe"))
    private List<Classe> classes = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "enseignant_matiere",
            joinColumns = @JoinColumn(name = "matricule_enseignant"),
            inverseJoinColumns = @JoinColumn(name = "id_matiere"))
    private List<Matiere> matieres = new ArrayList<>();

    public Enseignant() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomEnseignant() {
        return nomEnseignant;
    }

    public void setNomEnseignant(String nomEnseignant) {
        this.nomEnseignant = nomEnseignant;
    }

    public String getPrenomEnseignant() {
        return prenomEnseignant;
    }

    public void setPrenomEnseignant(String prenomEnseignant) {
        this.prenomEnseignant = prenomEnseignant;
    }

    public Integer getAgeEnseignant() {
        return ageEnseignant;
    }

    public void setAgeEnseignant(Integer ageEnseignant) {
        this.ageEnseignant = ageEnseignant;
    }

    public String getGradeEnseignant() {
        return gradeEnseignant;
    }

    public void setGradeEnseignant(String gradeEnseignant) {
        this.gradeEnseignant = gradeEnseignant;
    }

    public Boolean getProfPrincEnseignant() {
        return profPrincEnseignant;
    }

    public void setProfPrincEnseignant(Boolean profPrincEnseignant) {
        this.profPrincEnseignant = profPrincEnseignant;
    }

    public Boolean getResponsableDepartement() {
        return responsableDepartement;
    }

    public void setResponsableDepartement(Boolean responsableDepartement) {
        this.responsableDepartement = responsableDepartement;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

    public List<Matiere> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
    }

    @Override
    public String toString() {
        return "Enseignant{" +
                "id=" + id +
                ", nomEnseignant='" + nomEnseignant + '\'' +
                ", prenomEnseignant='" + prenomEnseignant + '\'' +
                ", ageEnseignant=" + ageEnseignant +
                ", gradeEnseignant='" + gradeEnseignant + '\'' +
                ", profPrincEnseignant=" + profPrincEnseignant +
                ", responsableDepartement=" + responsableDepartement +
                ", departement=" + departement +
                '}';
    }
}