package com.example.my_application;


import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {



    private EditText surfaceInput, piecesInput;
    private CheckBox piscineCheckbox;
    private TextView resultView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        surfaceInput = findViewById(R.id.la_surface);
        piecesInput = findViewById(R.id.les_pieces);
        piscineCheckbox = findViewById(R.id.piscine_existe);
        resultView = findViewById(R.id.resultat);


        findViewById(R.id.button_de_calcul).setOnClickListener(v -> calculerImpot());
    }


    private void calculerImpot() {

        double surface = Double.parseDouble(surfaceInput.getText().toString());
        int nbPieces = Integer.parseInt(piecesInput.getText().toString());
        boolean avecPiscine = piscineCheckbox.isChecked();



        double impotBase = surface * 2;
        double supplement = nbPieces * 50 + (avecPiscine ? 100 : 0);
        double montantTotal = impotBase + supplement;



        resultView.setText("Montant de l'impôt : " + montantTotal + " DH");
    }
}