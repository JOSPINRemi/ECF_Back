package entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_note", nullable = false)
    private Integer id;

    @Column(name = "valeur_note", precision = 4, scale = 2)
    private BigDecimal valeurNote;

    @Column(name = "commentaire_note", length = 50)
    private String commentaireNote;

    @ManyToOne
    @JoinColumn(name = "id_matiere", nullable = false)
    private Matiere matiere;

    @ManyToOne
    @JoinColumn(name = "id_etudiant", nullable = false)
    private Etudiant etudiant;

    public Note() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValeurNote() {
        return valeurNote;
    }

    public void setValeurNote(BigDecimal valeurNote) {
        this.valeurNote = valeurNote;
    }

    public String getCommentaireNote() {
        return commentaireNote;
    }

    public void setCommentaireNote(String commentaireNote) {
        this.commentaireNote = commentaireNote;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", valeurNote=" + valeurNote +
                ", commentaireNote='" + commentaireNote + '\'' +
                ", matiere=" + matiere +
                ", idEtudiant=" + etudiant +
                '}';
    }
}