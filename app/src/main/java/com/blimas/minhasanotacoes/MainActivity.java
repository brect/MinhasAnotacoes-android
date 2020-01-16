package com.blimas.minhasanotacoes;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AnotacoesPreferencias anotacoesPreferencias;
    private EditText editaAnotacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editaAnotacoes = findViewById(R.id.editAnotacoes);
        anotacoesPreferencias = new AnotacoesPreferencias(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //validar se foi digitado algo em anotacoes
                String textoRecuperado = editaAnotacoes.getText().toString();
                if(textoRecuperado.equals("")){
                    Snackbar.make(view, "Preencha com suas anotações", Snackbar.LENGTH_LONG).show();
                }else {
                    anotacoesPreferencias.salvarAnotacao(textoRecuperado);
                    Snackbar.make(view, "Anotações salvas com sucesso!", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        //recupera anotacoes
        String anotacoesRecuperadas = anotacoesPreferencias.recuperarAnotacao();

        if(!anotacoesRecuperadas.equals("")){
           editaAnotacoes.setText(anotacoesRecuperadas);
        }
    }


}
