package fr.gsb.rv;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class RechercheRvActivity extends AppCompatActivity {

    private static final String [] lesMois = { "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};


    Spinner spMois;
    Spinner spAnnee;
    Button bAfficherListe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_rv);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        ArrayAdapter<String> adapteur = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lesMois);

        spMois = (Spinner) findViewById(R.id.spMois);
        spMois.setAdapter(adapteur);


        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);

        for (int i = 2015; i <= thisYear; i++) {
            years.add(Integer.toString(i));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, years);

        spAnnee = (Spinner) findViewById(R.id.spAnnee);
        spAnnee.setAdapter(adapter);

        bAfficherListe = (Button) findViewById(R.id.bAfficherListe);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void afficherListe(View vue){
        Bundle paquet = new Bundle();
        paquet.putString("dateMois",spMois.getSelectedItem().toString());
        paquet.putString("dateAnnee",spAnnee.getSelectedItem().toString());

        Intent intentionList = new Intent(this,ListeRvActivity.class);
        intentionList.putExtras(paquet);

        startActivity(intentionList);

    }

}
