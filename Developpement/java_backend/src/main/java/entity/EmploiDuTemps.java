package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "emploi_du_temps")
@IdClass(EmploiDuTempsPk.class)
public class EmploiDuTemps implements Serializable {
    private int id;
    private Matiere matiere;
    private Etudiant etudiant;

    @Column(name = "date_emploi_du_temps")
    private LocalDate dateEmploiDuTemps;

    @Column(name = "heure_emploi_du_temps")
    private LocalTime heureEmploiDuTemps;

    public EmploiDuTemps() {
        super();
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateEmploiDuTemps() {
        return dateEmploiDuTemps;
    }

    public void setDateEmploiDuTemps(LocalDate dateEmploiDuTemps) {
        this.dateEmploiDuTemps = dateEmploiDuTemps;
    }

    public LocalTime getHeureEmploiDuTemps() {
        return heureEmploiDuTemps;
    }

    public void setHeureEmploiDuTemps(LocalTime heureEmploiDuTemps) {
        this.heureEmploiDuTemps = heureEmploiDuTemps;
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
}