package dashbord.models;

public class Reservasion {

    int id ;
    String nom ;
    String prenom ;
    String heure ;
    String type ;

    public Reservasion(){}

    public Reservasion(int id, String nom, String prenom, String heure, String type) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.heure = heure;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
