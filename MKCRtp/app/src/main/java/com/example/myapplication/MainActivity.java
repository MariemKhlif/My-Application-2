package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private SeekBar sbAge;
    private RadioButton rbtfr,rbteng;

    private EditText edittext;
    private Button btnConsulter;
    private TextView textage,resultat;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        sbAge.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        Log.i("Information", "onProgressChanged" + i);
                        textage.setText("Votre Age:" + i);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }


        );

        btnConsulter.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                Calculer(view);
                                            }
                                        }

        );

    }
        public void Calculer(View view)

        {
           int age;
           String type_de_film;
            boolean verifAge = false ;
            boolean verifValeur =false ;
            if(sbAge.getProgress()!=0)
                verifAge=true;
            else
                Toast.makeText(MainActivity.this,"Veuillez verifier votre age ",Toast.LENGTH_SHORT).show();
            if (!edittext.getText().toString().isEmpty())
                verifValeur= true;
            else
                Toast.makeText(MainActivity.this,"Veuillez verifier la valeur mesurée",Toast.LENGTH_SHORT).show();
                if (verifAge && verifValeur)
               {
                   age = sbAge.getProgress();
                   type_de_film=String.valueOf(edittext.getText().toString());
                   boolean French=rbtfr.isChecked();
                       if (age>=10)
                            { if(French)
                                     {
                                         if(type_de_film=="comic")
                                            resultat.setText("Ratatouille\n");
                                            else if (type_de_film=="action")
                                                resultat.setText("Les Indestructibles\n");
                                              else if (type_de_film=="horror")
                                                   resultat.setText("La Prophétie de l'horloge\n");
                                     }
                            else
                                if(type_de_film=="comic")
                                resultat.setText("Home alone\n");
                                  else if (type_de_film=="action")
                                       resultat.setText("Spy kids\n");
                                         else if (type_de_film=="horror")
                                               resultat.setText("It\n");


                            }
                       else
                           if (age<=10 && age>=25)
                          {
                               if (French)
                                  {
                                     if(type_de_film=="comic")
                                       resultat.setText("Les Vacances de monsieur Hulot\n");
                                    else if (type_de_film=="action")
                                            resultat.setText("Le Transporteur \n");
                                          else if (type_de_film=="horror")
                                                resultat.setText("Le Manoir du diable \n");
                                  }
                          else
                              if(type_de_film=="comic")
                                resultat.setText("The Greatest Showman\n");
                              else if (type_de_film=="action")
                                     resultat.setText("Descendants\n");
                                  else if (type_de_film=="horror")
                                        resultat.setText("The conjuring\n");

                          }
                        else if (age<=25 && age>=100)
                               {
                                  if (French)
                                    {
                                       if(type_de_film=="comic")
                                          resultat.setText("Le Corniaud\n");
                                       else if (type_de_film=="action")
                                              resultat.setText("Taxi\n");
                                            else if (type_de_film=="horror")
                                                 resultat.setText("Haute Tension\n");
                                    }
                               else
                                  if(type_de_film=="comic")
                                    resultat.setText("Home alone\n");
                                 else if (type_de_film=="action")
                                      resultat.setText("The suits \n");
                                     else if (type_de_film=="horror")
                                         resultat.setText("Scream\n");
                               }









               }



        }







    public void init ()
    {
        edittext=(EditText) findViewById(R.id.edittext) ;
        sbAge=(SeekBar)findViewById(R.id.sbAge);
        rbtfr=(RadioButton)findViewById(R.id.rbtfr);
        rbteng=(RadioButton)findViewById(R.id.rbteng);
        btnConsulter=(Button)findViewById(R.id.btnConsulter);
        textage=(TextView)findViewById(R.id.textAge);
        resultat=(TextView)findViewById(R.id.resultat);
    }


}
