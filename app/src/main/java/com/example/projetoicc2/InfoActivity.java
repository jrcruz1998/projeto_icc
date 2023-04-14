package com.example.projetoicc2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class InfoActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Activity activity = this;
        activity.getWindow().setBackgroundDrawableResource(R.color.darkGray);


        getSupportActionBar().hide();

        // Criando e configurando o novo Element para o WhatsApp
        Element wppElement = new Element();
        wppElement.setTitle("WhatsApp");
        wppElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=41992093531"));
                startActivity(intent);
            }
        });
        wppElement.setIconDrawable(R.drawable.wpp_icon);

        Element versionElement = new Element();
        versionElement.setTitle("Versão 1.0");

        View aboutPage = new AboutPage(this)
                .setDescription("A igreja de Cristo no Cajuru é uma congregação fiel e firme na palavra.\n" +
                        "A igreja foi edificada por Cristo no ano de 33 d.C. Seguindo os ensinamentos do " +
                        "Novo Testamento a congregação da igreja de Cristo começou em 1967.")

                .addGroup("Entre em contato")
                .addEmail("igrejadocajuru@gmail.com", "Envie um e-mail")
                .addWebsite("https://igrejadecristo.net/", "Acesse nosso site")
                .addItem(wppElement)

                .addGroup("Redes Sociais")
                .addFacebook("Igrejacajuru", "Facebook")
                .addYoutube("igrejadeCristo33ad/", "Youtube")

                .addItem(versionElement)
                .create();
        setContentView(aboutPage);



    }

}