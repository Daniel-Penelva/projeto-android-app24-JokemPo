package com.example.jokempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    ImageButton imagemPedra, imagemPapel,imagemTesoura;
    ImageView jogador1, jogador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagemPedra = findViewById(R.id.botaoPedra);
        imagemPapel = findViewById(R.id.botaoPapel);
        imagemTesoura = findViewById(R.id.botaoTesoura);

        jogador1 = findViewById(R.id.jogador1);
        jogador2 = findViewById(R.id.jogador2);
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
    }
}
