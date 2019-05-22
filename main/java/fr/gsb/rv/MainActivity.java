package fr.gsb.rv;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import fr.gsb.rv.modeles.ModelGsb;
import fr.gsb.rv.technique.Session;


public class MainActivity extends AppCompatActivity {

    final String TAG="GSB_MAIN_ACTIVITY";
    TextView tvErreur;
    EditText etMatricule;
    EditText etMdp;
    Button bValider;
    Button bAnnuler;
    int essaie = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvErreur = (TextView) findViewById( R.id.tvErreur ) ;
        etMatricule = (EditText) findViewById( R.id.etMatricule ) ;
        etMdp = (EditText) findViewById( R.id.etMdp ) ;
        bValider = (Button) findViewById( R.id.bValider ) ;
        bAnnuler = (Button) findViewById( R.id.bAnnuler ) ;
        tvErreur.setText("");
        Log.i(TAG, "Création de l'activité principale");
    }


    public void seConnecter(View vue){

        String matricule = URLEncoder.encode(etMatricule.getText().toString());
        String mdp = URLEncoder.encode(etMdp.getText().toString());

        String lienConnectBdd = String.format("http://192.168.43.184:5000/visiteurs/%s/%s",matricule,mdp);
        Response.Listener<JSONObject> ecouteurReponse = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    Visiteur unVisiteur = new Visiteur();
                    unVisiteur.setMatricule(response.getString("vis_matricule"));
                    unVisiteur.setMdp(response.getString("vis_mdp"));

                    Session.ouvrir(unVisiteur);
                    if(unVisiteur != null){
                        Toast.makeText(MainActivity.this, "Authentification réussie", Toast.LENGTH_LONG).show();

                        Bundle paquet = new Bundle();
                        paquet.putString("matricule", unVisiteur.getMatricule());
                        paquet.putString("mdp", unVisiteur.getMdp());

                        Intent intentionAEnvoie =  new Intent(MainActivity.this, MenuRvActivity.class);
                        intentionAEnvoie.putExtras(paquet);

                        startActivity(intentionAEnvoie);

                    }
                    else {
                        tvErreur.setText("Echec à la connexion. Recommencez...");
                    }
                    Log.i(TAG,String.valueOf(unVisiteur));


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

    public void annuler(View vue){
        etMatricule.setText("");
        etMdp.setText("");
        tvErreur.setText("");
        Log.i(TAG, "Initialisation des champ");
    }
}
// Session.ouvrir(unVisiteur);
//
//         if(unVisiteur != null){
//         Toast.makeText(MainActivity.this, "Authentification réussie", Toast.LENGTH_LONG).show();
//         Log.i(TAG, "Connection Ok ".concat(unVisiteur.getNom()).concat(" ").concat(unVisiteur.getPrenom().concat(".")));
//
//         Intent intentionAEnvoie =  new Intent(MainActivity.this, MenuRvActivity.class);
//        startActivity(intentionAEnvoie);
//        }
//        else {
//        tvErreur.setText("Echec à la connexion. Recommencez...");
//        Log.i(TAG, "Connection Nok");
//        }
//
//        Log.i(TAG,String.valueOf(unVisiteur));