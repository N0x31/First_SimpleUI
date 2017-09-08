package fr.wcs.appsimple;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class AppSimple extends AppCompatActivity implements View.OnClickListener {


    //Declare variables

    CheckBox Check;
    EditText nom;
    EditText prenom;
    Button valider;
    TextView felic;
    String edit1;
    String edit2;
    String text;
    TextView nomBravo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_simple);

        Check = (CheckBox)findViewById(R.id.Check);//get ID of checkbox
        Check.setOnClickListener(this);

        nom = (EditText)findViewById(R.id.nom);//get ID of surname
        nom.setEnabled(false);

        prenom = (EditText)findViewById(R.id.prenom);//get ID of name
        prenom.setEnabled(false);

        valider = (Button)findViewById(R.id.valider);//get ID of validate button
        valider.setEnabled(false);
        valider.setOnClickListener(this);

        nomBravo = (TextView)findViewById(R.id.nomBravo);
        nomBravo.setText(" ");


    }

    public void onClick(View view) {

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        // Check if checkbox is clicked
        switch(view.getId()) {
            case R.id.Check:
                if (Check.isChecked()) {
                    nom.setEnabled(true);
                    prenom.setEnabled(true);
                    valider.setEnabled(true);
                }//affiche les curseurs texte et active le bouton valider
                else {
                    nom.setEnabled(false);
                    prenom.setEnabled(false);
                    valider.setEnabled(false);
                }
                break;
        }
        switch(view.getId()) {
            case R.id.valider:
                if (prenom.getText().toString().trim().length() == 0 || nom.getText().toString().trim().length() == 0) {
                    Toast.makeText(this, "Veuillez remplir les champs Nom et Prénom", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    edit1 = prenom.getText().toString();
                    edit2 = nom.getText().toString();
                    text = "Félicitations " + edit2 + " " + edit1 + " !";
                    nomBravo.setText(String.valueOf(text));
                }
                break;
        }

    }

}

