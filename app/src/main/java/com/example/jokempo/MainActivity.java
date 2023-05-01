package com.example.jokempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageButton imagemPedra, imagemPapel,imagemTesoura;
    ImageView jogador1, jogador2;
    TextView resultado;
    Animation visivel, invisivel;

    int jogada1 = 0, jogada2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Capturando o id do componente
        imagemPedra = findViewById(R.id.botaoPedra);
        imagemPapel = findViewById(R.id.botaoPapel);
        imagemTesoura = findViewById(R.id.botaoTesoura);
        jogador1 = findViewById(R.id.jogador1);
        jogador2 = findViewById(R.id.jogador2);
        resultado = findViewById(R.id.resultado);

        //Tornar a imagem interrogação piscando
        visivel = new AlphaAnimation(1,0);
        invisivel = new AlphaAnimation(0,1);

        // tempo de duração da animação
        invisivel.setDuration(1500);
        visivel.setDuration(100);

        // Criando o evento da animação invisivel
        invisivel.setAnimationListener(new Animation.AnimationListener() {

            // Animação para ser iniciada
            @Override
            public void onAnimationStart(Animation animation) {
                jogador2.setVisibility(View.VISIBLE);
            }

            // Animação para ser encerrada
            @Override
            public void onAnimationEnd(Animation animation) {
                jogador2.setVisibility(View.INVISIBLE);
                jogador2.startAnimation(visivel);
            }

            // Animação para ser repetida
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        // Criando o evento da animação visivel
        visivel.setAnimationListener(new Animation.AnimationListener() {

            // Animação para ser iniciada
            @Override
            public void onAnimationStart(Animation animation) {
                sorteiaJogada();
                jogador2.setVisibility(View.INVISIBLE);
            }

            // Animação para ser encerrada
            @Override
            public void onAnimationEnd(Animation animation) {
                verificaJogada();
                jogador2.setVisibility(View.VISIBLE);
            }

            // Animação para ser repetida
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void jogar(View view){

        // Inverter a imagem do jogador 1
        jogador1.setScaleX(-1);

        switch(view.getId()){
            case(R.id.botaoPedra):
                jogador1.setImageResource(R.drawable.pedra);
                jogada1 = 1;
                break;

            case(R.id.botaoPapel):
                jogador1.setImageResource(R.drawable.papel);
                jogada1 = 2;
                break;

            case(R.id.botaoTesoura):
                jogador1.setImageResource(R.drawable.tesoura);
                jogada1 = 3;
                break;
        }

        jogador2.startAnimation(invisivel);
        jogador2.setImageResource(R.drawable.interrogacao);
    }

    public void sorteiaJogada(){

        Random sorteia = new Random();
        int numRandom = sorteia.nextInt(3);  // 0, 1, 2

        switch (numRandom){
            case 0:
                jogador2.setImageResource(R.drawable.pedra);
                jogada2 = 1;
                break;
            case 1:
                jogador2.setImageResource(R.drawable.papel);
                jogada2 = 2;
                break;
            case 2:
                jogador2.setImageResource(R.drawable.tesoura);
                jogada2 = 3;
                break;
        }
    }

    public void  verificaJogada(){

        /*Regra:
        * 1 - Pedra; 2 - Papel; 3 - Tesoura*/

        if(jogada1 == jogada2){
            //Toast.makeText(this, "Empate!", Toast.LENGTH_LONG).show();
            resultado.setText("Empatou!");

        }if((jogada1 == 1 && jogada2 == 3) || (jogada1 == 2 && jogada2 == 1) || (jogada1 == 3 && jogada2 == 2)){
            //Toast.makeText(this, "Ganhou!", Toast.LENGTH_LONG).show();
            resultado.setText("Ganhou!");

        }if((jogada1 == 1 && jogada2 == 2) || (jogada1 == 2 && jogada2 == 3) || (jogada1 == 3 && jogada2 == 1)){
            //Toast.makeText(this, "Perdeu!", Toast.LENGTH_LONG).show();
            resultado.setText("Perdeu!");
        }
    }
}
