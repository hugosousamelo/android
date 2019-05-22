package fr.gsb.rv;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import fr.gsb.rv.entites.Rapport;
import fr.gsb.rv.modeles.ModelGsb;

public class ListeRvActivity extends AppCompatActivity {

    TextView tvMoisListeRv;
    TextView tvAnneeListeRv;
   // TextView tvListRapport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_rv);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        tvMoisListeRv = (TextView) findViewById(R.id.tvMoisListeRv);
        tvMoisListeRv.setText(getIntent().getExtras().getString("dateMois"));

        tvAnneeListeRv = (TextView) findViewById(R.id.tvAnneeListeRv);
        tvAnneeListeRv.setText(getIntent().getExtras().getString("dateAnnee"));

       // tvListRapport = (TextView) findViewById(R.id.tvAnneeListeRv);
       // tvListRapport.setText((Rapport) ModelGsb.getInstance().afficherRapport("a131"));

    }

}
