package com.example.jokempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    ImageButton imagemPedra, imagemPapel,imagemTesoura;
    ImageView jogador1, jogador2;
    Animation visivel, invisivel;

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

        //Tornar a imagem interrogação piscando
        visivel = new AlphaAnimation(1,0);
        invisivel = new AlphaAnimation(0,1);

        // tempo de duração da animação
        invisivel.setDuration(1500);
        visivel.setDuration(200);

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
                jogador2.setVisibility(View.INVISIBLE);
            }

            // Animação para ser encerrada
            @Override
            public void onAnimationEnd(Animation animation) {
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
                break;

            case(R.id.botaoPapel):
                jogador1.setImageResource(R.drawable.papel);
                break;

            case(R.id.botaoTesoura):
                jogador1.setImageResource(R.drawable.tesoura);
                break;
        }

        jogador2.setImageResource(R.drawable.interrogacao);
        jogador2.startAnimation(invisivel);
    }
}
