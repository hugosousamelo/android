package fr.gsb.rv.entites;

import java.util.Date;

public class Rapport {
    private int id;
    private String matricule;
    private Date dateVisite;
    private String motif;
    private String bilan;
    private int coefficiance_Confiance;

    public Rapport (int id, String matricule, Date dateVisite,String motif, String bilan, int coefficiance_Confiance){
        this.id = id;
        this.matricule = matricule;
        this.dateVisite = dateVisite;
        this.motif = motif;
        this.bilan = bilan;
        this.coefficiance_Confiance = coefficiance_Confiance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule (String matricule) {
        this.matricule = matricule;
    }

    public Date getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(Date dateVisite) {
        this.dateVisite = dateVisite;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif (String motif) {
        this.motif = motif;
    }

    public String getBilan(){
        return bilan;
    }

    public void setBilan(String bilan){
        this.bilan= bilan;
    }

    public int getCoefficiance_Confiance(){
        return coefficiance_Confiance;
    }

    public void setCoefficiance_Confiance(int coefficiance_Confiance){
        this.coefficiance_Confiance = coefficiance_Confiance;
    }

}
