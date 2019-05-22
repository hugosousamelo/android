package fr.gsb.rv.technique;

import fr.gsb.rv.entites.Visiteur;

public class Session {
    private static Session session = null;

    private Visiteur leVisiteur;

    private Session (Visiteur leVisiteur){
        this.leVisiteur = leVisiteur;
    }

    public Visiteur getLeVisiteur() {
        return leVisiteur;
    }

    public static Session getSession(){
        return session;
    }

    public void setLeVisiteur(Visiteur leVisiteur) {
        this.leVisiteur= leVisiteur;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public static void ouvrir(Visiteur leVisiteur){
        session = new Session(leVisiteur);

    }

    public void fermer(){
        session = null;
    }

}
