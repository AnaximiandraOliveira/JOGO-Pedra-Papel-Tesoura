package com.teste.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {

        this.opcaoSelecionada("Pedra");
    }

    public void selecionadoPapel(View view) {

        this.opcaoSelecionada("Papel");
    }

    public void selecionadoTesoura(View view) {

        this.opcaoSelecionada("Tesoura");
    }


    public void opcaoSelecionada(String escolhaUsuario) {

        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String escolhaApp = opcoes[numero];


        switch (escolhaApp) {
            case "Pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;

            case "Papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;

            case "Tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

      //App Vencedor
        if ((escolhaApp =="Tesoura" && escolhaUsuario=="Papel") ||
        (escolhaApp =="Papel"&& escolhaUsuario=="Pedra") ||
        (escolhaApp =="Pedra"&& escolhaUsuario=="Tesoura") )

        {

            textoResultado.setText("Você Perdeu!");

        }

        //Usuário vencedor

        else  if ( (escolhaUsuario =="Tesoura"&& escolhaApp=="Papel") ||
        (escolhaUsuario =="Papel"&& escolhaApp=="Pedra") ||
                (escolhaUsuario =="Pedra"&& escolhaApp=="Tesoura") )

        {

            textoResultado.setText("Você ganhou!");

        }

        else
       {

                textoResultado.setText("Empatamos!");

        }

        System.out.println("Item Clicado:" + escolhaApp);

    }
}