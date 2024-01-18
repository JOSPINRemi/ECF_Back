package entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "emploi_du_temps")
public class EmploiDuTemp {
    @EmbeddedId
    private EmploiDuTempId id;

    @Column(name = "date_emploi_du_temps")
    private LocalDate dateEmploiDuTemps;

    @Column(name = "heure_emploi_du_temps")
    private LocalTime heureEmploiDuTemps;

    public EmploiDuTempId getId() {
        return id;
    }

    public void setId(EmploiDuTempId id) {
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

}