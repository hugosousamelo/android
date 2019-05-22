package fr.gsb.rv;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLEncoder;

import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.technique.Session;

public class MenuRvActivity extends AppCompatActivity {

    final String TAG="GSB_MAIN_ACTIVITY";
    TextView tvNomVisiteur;
    Button bConsulter;
    Button bSaisir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_rv);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvNomVisiteur = (TextView) findViewById( R.id.tvNomVisiteur ) ;
        bConsulter = (Button) findViewById( R.id.bConsulter ) ;
        bSaisir = (Button) findViewById( R.id.bSaisir ) ;
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Bundle paquet = this.getIntent().getExtras();
        String matricule = paquet.getString("matricule");
        String mdp = paquet.getString("mdp");

        String lienConnectBdd = String.format("http://192.168.43.184:5000/visiteurs/%s/%s",matricule,mdp);
        Response.Listener<JSONObject> ecouteurReponse = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    Visiteur unVisiteur = new Visiteur();
                    unVisiteur.setNom(response.getString("vis_nom"));
                    unVisiteur.setPrenom(response.getString("vis_prenom"));

                    if(unVisiteur != null){
                        tvNomVisiteur.setText(unVisiteur.getNom().concat(" ").concat(unVisiteur.getPrenom()));
                    }
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        Response.ErrorListener ecouteurErreur = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG,"Erreur HTTP : " + error.getMessage());
            }
        };


        JsonObjectRequest requete = new JsonObjectRequest(
                Request.Method.GET,
                lienConnectBdd,
                null,
                ecouteurReponse,
                ecouteurErreur

        );
        RequestQueue fileRequetes = Volley.newRequestQueue(this);
        fileRequetes.add(requete);

    }







    public void consulterRapport(View vue){

        Intent intentionAEnvoie =  new Intent(this, RechercheRvActivity.class);

        startActivity(intentionAEnvoie);
    }
    public void saisirRapport(View vue){

        Bundle paquet = new Bundle();
        paquet.putString("matricule", Session.getSession().getLeVisiteur().getMatricule());

        Intent intentionAEnvoie =  new Intent(this, SaisirRvActivity.class);
        intentionAEnvoie.putExtras( paquet );

        startActivity(intentionAEnvoie);
    }

}
