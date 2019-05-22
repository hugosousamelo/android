package fr.gsb.rv;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import fr.gsb.rv.R;

public class SaisirRvActivity extends AppCompatActivity {

    TextView tv_date_commande;
    TextView tv_date_selectionnee;

    EditText etBilan;

    Button bAnnuler;
    Button bValider;
    Button b_selectionner_date;

    Spinner spPraticien;
    Spinner spMotif;
    Spinner spCoeff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisir_rv);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv_date_commande = (TextView) findViewById( R.id.tv_date_commande ) ;
        tv_date_selectionnee = (TextView) findViewById( R.id.tv_date_selectionnee ) ;
        etBilan = (EditText) findViewById( R.id.etBilan ) ;
        bAnnuler = (Button) findViewById( R.id.bAnnuler ) ;
        bValider = (Button) findViewById( R.id.bValider ) ;
        b_selectionner_date = (Button) findViewById( R.id.b_selectionner_date ) ;
        spPraticien = (Spinner) findViewById( R.id.spPraticien ) ;
        spMotif = (Spinner) findViewById( R.id.spMotif ) ;
        spCoeff = (Spinner) findViewById( R.id.spCoeff ) ;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
