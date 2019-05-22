package fr.gsb.rv.modeles;

import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.gsb.rv.R;
import fr.gsb.rv.entites.Rapport;
import fr.gsb.rv.entites.Visiteur;

public class ModelGsb {

    private static ModelGsb modele = null;

    private List<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
    private List<Rapport> lesRapport = new ArrayList<Rapport>();

    private ModelGsb(){

        super();
        this.peupler();
        this.consulterRapport();

    }

    public static ModelGsb getInstance(){
        if(ModelGsb.modele == null){
            modele = new ModelGsb();
        }
        return ModelGsb.modele;
    }

    private void peupler(){
        this.lesVisiteurs.add(new Visiteur("a131","azerty","Villechalane","Louis"));
        this.lesVisiteurs.add(new Visiteur("b13","azerty","Bentot","Pascal"));
        this.lesVisiteurs.add(new Visiteur("b16","azerty","Bioret","Luc"));
        this.lesVisiteurs.add(new Visiteur("b17","azerty","Andre","David"));
    }

    private void consulterRapport(){
        this.lesRapport.add(new Rapport(1,"a131",new Date(2018-11-20),"Aucun","RAS",2));
        this.lesRapport.add(new Rapport(1,"b13",new Date(2018-11-20),"Aucun","RAS",1));
        this.lesRapport.add(new Rapport(1,"a131",new Date(2018-11-19),"ABC","Bien",2));
    }

    public Visiteur seConnecter(String matricule, String mdp){
        for (Visiteur unVisiteur : this.lesVisiteurs){
            if (unVisiteur.getMatricule().equals(matricule) && unVisiteur.getMdp().equals(mdp)){
                return unVisiteur;
            }
        }
        return null;
    }

    public List<Rapport> afficherRapport(String matricule){
        List<Rapport> rapports = new ArrayList<Rapport>();
        for (Rapport unRapport : this.lesRapport){
            if (unRapport.getMatricule().equals(matricule)) {
                rapports.add(unRapport);
            }
        }
        return rapports;
    }
}
