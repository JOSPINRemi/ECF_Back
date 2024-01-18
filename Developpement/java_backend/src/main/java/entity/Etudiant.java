package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etudiant", nullable = false)
    private Integer id;

    @Column(name = "nom_etudiant", nullable = false, length = 50)
    private String nomEtudiant;

    @Column(name = "prenom_etudiant", length = 50)
    private String prenomEtudiant;

    @Column(name = "date_naissance_etudiant")
    private LocalDate dateNaissanceEtudiant;

    @Column(name = "email_etudiant", length = 50)
    private String emailEtudiant;

    @ManyToOne
    @JoinColumn(name = "id_classe")
    private Classe classe;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Note> notes;

    @OneToMany(mappedBy = "matiere")
    private List<EmploiDuTemp> emploiDuTemps;

    public Etudiant() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    public void setPrenomEtudiant(String prenomEtudiant) {
        this.prenomEtudiant = prenomEtudiant;
    }

    public LocalDate getDateNaissanceEtudiant() {
        return dateNaissanceEtudiant;
    }

    public void setDateNaissanceEtudiant(LocalDate dateNaissanceEtudiant) {
        this.dateNaissanceEtudiant = dateNaissanceEtudiant;
    }

    public String getEmailEtudiant() {
        return emailEtudiant;
    }

    public void setEmailEtudiant(String emailEtudiant) {
        this.emailEtudiant = emailEtudiant;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nomEtudiant='" + nomEtudiant + '\'' +
                ", prenomEtudiant='" + prenomEtudiant + '\'' +
                ", dateNaissanceEtudiant=" + dateNaissanceEtudiant +
                ", emailEtudiant='" + emailEtudiant + '\'' +
                ", classe=" + classe +
                '}';
    }
}