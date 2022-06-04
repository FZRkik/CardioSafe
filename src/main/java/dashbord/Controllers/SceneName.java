package dashbord.Controllers;

/**
 * Code created by Andrius on 2020-09-28
 */
public enum SceneName {
    Acceuil("Acceuil"),
    Consultations("Consultations"),
    LOGIN("LOGIN"),
    Dashbord("Dashbord"),
    Patients("Patients"),
    Paiements ("Paiements"),
    Ajouter ("Ajouter")
    ;

    private final String name;

    private SceneName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
