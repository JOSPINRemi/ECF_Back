package entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmploiDuTempId implements Serializable {
    private static final long serialVersionUID = -3161144951553177304L;
    @Column(name = "id_matiere", nullable = false)
    private Integer idMatiere;

    @Column(name = "id_etudiant", nullable = false)
    private Integer idEtudiant;

    public Integer getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Integer idMatiere) {
        this.idMatiere = idMatiere;
    }

    public Integer getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(Integer idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EmploiDuTempId entity = (EmploiDuTempId) o;
        return Objects.equals(this.idMatiere, entity.idMatiere) &&
                Objects.equals(this.idEtudiant, entity.idEtudiant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMatiere, idEtudiant);
    }

}