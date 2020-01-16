package com.blimas.minhasanotacoes;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacoesPreferencias {

    private Context contexto;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editarPreferencias;


    private final String NOME_ARQUIVO = "anotacao.preferencias";
    private final String CHAVE_NOME = "nome";

    public AnotacoesPreferencias(Context context) {
        this.contexto = context;
        sharedPreferences = context.getSharedPreferences(NOME_ARQUIVO, 0);
        editarPreferencias = sharedPreferences.edit();
    }

    public void salvarAnotacao(String anotacao){
        editarPreferencias.putString(CHAVE_NOME, anotacao);
        editarPreferencias.commit();
    }

    public String recuperarAnotacao(){
        return sharedPreferences.getString(CHAVE_NOME, "");
    }

}
