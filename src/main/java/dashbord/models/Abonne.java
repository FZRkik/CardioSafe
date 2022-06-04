package dashbord.models;

public class Abonne {
    private int id;
    private String nom;
    private String prenom;
    private String date;
    private String type;

    public Abonne() {}

    public Abonne(int id, String nom, String prenom, String date, String type) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

