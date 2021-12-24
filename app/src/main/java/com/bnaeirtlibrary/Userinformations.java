package com.bnaeirtlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class Userinformations extends AppCompatActivity{
    StorageReference storageReference;
    DatabaseReference databaseReference;
    ListView listViewUser;

    List<Users> uploadePDF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinformations);


    }
    public void displayAcountEditePage(View view){

        Toast.makeText(getApplicationContext(), "You Can not edit your account, for more information contact Admin", Toast.LENGTH_LONG).show();


        //startActivity(new Intent(getApplicationContext(),UserEditAccount.class));

    }

    public void aboutUs(View view){

        String value = "AKWABA à Bibliothèque numérique de l’AEIRT\n"+" (BN- AEIRT)\n" +
                "\n" +
                "BN- AEIRT est une Bibliothèque numérique créée par le bureau de l'association des etudiants Ivoiriens residents en Turquie ( AEIRT) dans l’objectif  d’offrir de nouveaux supports pédagogiques, de favoriser les recherches des etudiants, de donner accès à des sources peu communicables, de parfaire et partager les connaissances, de compléter l’offre d’éducation artistique et culturelle pour le jeune public ou encore de proposer des expositions numériques !";
        Intent intent = new Intent(getApplicationContext(),InformationsAndSetting.class);
        intent.putExtra("key", value);
        startActivity(intent);

    }

    public void helpCenter(View view){

        //String value = "Let's contact Admin";
        Intent intent = new Intent(getApplicationContext(),HelpCenterActivity.class);
       // intent.putExtra("key", value);
        startActivity(intent);
    }
/*
    public void termOfUse(View view){

        String value = "Peuvent adhérer à l’association tout étudiant ou élève ivoirien vivant en Turquie.";
        Intent intent = new Intent(getApplicationContext(),InformationsAndSetting.class);
        intent.putExtra("key", value);
        startActivity(intent);
    }

 */
/*
    public void privacyPolicy(View view){

        String value = "Le présent règlement intérieur a pour objet de définir les modalités\n" +
                "d’application des statuts de l’association. La qualité de membre se perd par :\n" +
                "- démission ;\n" +
                "- radiation ;\n" +
                "- décès ;\n" +
                "- dissolution de l’association.\n" +
                "-départ définitif de la Turquie. L’inobservation des devoirs déterminés à l’article 7 du présent règlement\n" +
                "intérieur donne lieu aux sanctions suivantes :\n" +
                "- avertissement ;\n" +
                "- blâme ;\n" +
                "- radiation.";
        Intent intent = new Intent(getApplicationContext(),InformationsAndSetting.class);
        intent.putExtra("key", value);
        startActivity(intent);
    }

 */

    public void deleteAccount(View view){

        Toast.makeText(getApplicationContext(), "You Can not delete your account actually, for more information contact Admin", Toast.LENGTH_LONG).show();

        /*

        String value = "You Can't delete your account actually, contact Admin";
        Intent intent = new Intent(getApplicationContext(),InformationsAndSetting.class);
        intent.putExtra("key", value);
        startActivity(intent);

         */
    }

    public void profile(View view){

        Toast.makeText(getApplicationContext(), "Your Profile informations are not avaible actually", Toast.LENGTH_LONG).show();

/*
        String value = "information not avaible,Please Try Later";
        Intent intent = new Intent(getApplicationContext(),InformationsAndSetting.class);
        intent.putExtra("key", value);
        startActivity(intent);

 */
    }

}