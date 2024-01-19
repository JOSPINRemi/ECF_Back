package service;

import dao.impl.*;
import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Service {
    private final StandardServiceRegistry registry;
    private final SessionFactory sessionFactory;
    private Session session;
    private final ClasseDaoImpl classeDao;
    private final DepartementDaoImpl departementDao;
    private final EmploiDuTempsDaoImpl emploiDuTempsDao;
    private final EnseignantDaoImpl enseignantDao;
    private final EtudiantDaoImpl etudiantDao;
    private final MatiereDaoImpl matiereDao;
    private final NoteDaoImpl noteDao;

    public Service() {
        registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        classeDao = new ClasseDaoImpl(session);
        departementDao = new DepartementDaoImpl(session);
        emploiDuTempsDao = new EmploiDuTempsDaoImpl(session);
        enseignantDao = new EnseignantDaoImpl(session);
        etudiantDao = new EtudiantDaoImpl(session);
        matiereDao = new MatiereDaoImpl(session);
        noteDao = new NoteDaoImpl(session);
    }

    public boolean createClasse(Classe classe) {
        return classeDao.create(classe);
    }

    public boolean createNote(Note note) {
        return noteDao.create(note);
    }

    public boolean createMatiere(Matiere matiere) {
        return matiereDao.create(matiere);
    }

    public boolean createEtudiant(Etudiant etudiant) {
        return etudiantDao.create(etudiant);
    }

    public boolean createEnseignant(Enseignant enseignant) {
        return enseignantDao.create(enseignant);
    }

    public boolean createEmploiDuTemps(EmploiDuTemps emploiDuTemps) {
        return emploiDuTempsDao.create(emploiDuTemps);
    }

    public boolean createDepartement(Departement departement) {
        return departementDao.create(departement);
    }

    public List<Departement> getAllDepartements() {
        return departementDao.findAll();
    }

    public Departement getDepartementById(int idDepartement) {
        return departementDao.findById(idDepartement);
    }

    public List<Etudiant> getAllEtudiants() {
        return etudiantDao.findAll();
    }

    public void begin() {
        session = sessionFactory.openSession();
    }

    public void end() {
        session.close();
    }


    public List<Enseignant> getAllEnseignants() {
        return enseignantDao.findAll();
    }

    public Enseignant getEnseignantById(int idEnseignant) {
        return enseignantDao.findById(idEnseignant);
    }

    public boolean updateEnseignant(Enseignant enseignant) {
        return enseignantDao.update(enseignant);
    }

    public List<Matiere> getAllMatieres() {
        return matiereDao.findAll();
    }

    public Etudiant getEtudiantById(int idEtudiant) {
        return etudiantDao.findById(idEtudiant);
    }

    public Matiere getMatiereById(int idMatiere) {
        return matiereDao.findById(idMatiere);
    }

    public boolean updateMatiere(Matiere matiere) {
        return matiereDao.update(matiere);
    }

    public boolean updateEtudiant(Etudiant etudiant) {
        etudiantDao.update(etudiant);
    }

    public List<Classe> getAllClasses() {
        return classeDao.findAll();
    }

    public Classe getClasseById(int idClasse) {
        return classeDao.findById(idClasse);
    }

    public boolean updateClasse(Classe classe) {
        return classeDao.update(classe);
    }
}
