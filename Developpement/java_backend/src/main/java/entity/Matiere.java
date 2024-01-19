package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "matiere")
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matiere", nullable = false)
    private Integer id;

    @Column(name = "intitule_matiere", length = 50)
    private String intituleMatiere;

    @Column(name = "description_matiere", length = 50)
    private String descriptionMatiere;

    @Column(name = "duree_matiere")
    private Integer dureeMatiere;

    @Column(name = "coefficient_matiere", length = 50)
    private String coefficientMatiere;

    @ManyToMany(mappedBy = "matieres")
    private List<Enseignant> enseignants = new ArrayList<>();

    @OneToMany(mappedBy = "matiere", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Note> notes;

    @OneToMany(mappedBy = "etudiant")
    private List<EmploiDuTemps> emploisDuTemps;

    public Matiere() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntituleMatiere() {
        return intituleMatiere;
    }

    public void setIntituleMatiere(String intituleMatiere) {
        this.intituleMatiere = intituleMatiere;
    }

    public String getDescriptionMatiere() {
        return descriptionMatiere;
    }

    public void setDescriptionMatiere(String descriptionMatiere) {
        this.descriptionMatiere = descriptionMatiere;
    }

    public Integer getDureeMatiere() {
        return dureeMatiere;
    }

    public void setDureeMatiere(Integer dureeMatiere) {
        this.dureeMatiere = dureeMatiere;
    }

    public String getCoefficientMatiere() {
        return coefficientMatiere;
    }

    public void setCoefficientMatiere(String coefficientMatiere) {
        this.coefficientMatiere = coefficientMatiere;
    }

    public List<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(List<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Matiere{" +
                "id=" + id +
                ", intituleMatiere='" + intituleMatiere + '\'' +
                ", descriptionMatiere='" + descriptionMatiere + '\'' +
                ", dureeMatiere=" + dureeMatiere +
                ", coefficientMatiere='" + coefficientMatiere + '\'' +
                '}';
    }
}