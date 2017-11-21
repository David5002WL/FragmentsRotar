package com.example.david.rotar;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText datos;
    private Button botonFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datos = (EditText) findViewById(R.id.datos);
        botonFragment = (Button)findViewById(R.id.button2);



    }


    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        String texto = datos.getText().toString();

        outState.putString("datos", texto);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        String texto = savedInstanceState.getString("datos");
        datos.setText(texto);
    }

    @Override
    public void onClick(View v) {

            FragmentManager fragmentManager = getFragmentManager();

            FragmentTransaction transaction = fragmentManager.beginTransaction();

            FragmentoPrueba fragment = new FragmentoPrueba();
            transaction.add(R.id.Layoutprincipal, fragment);

            transaction.commit();

    }
}