package com.example.evaluacinmodulo3appcurriculum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.evaluacinmodulo3appcurriculum.databinding.ActivityContactBinding;

public class ContactActivity extends AppCompatActivity {
private ActivityContactBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.imageViewLinkedin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent linkedingIntent = new Intent(Intent.ACTION_VIEW);
            linkedingIntent.setData(Uri.parse("https://www.linkedin.com/in/sergio-iv%C3%A1n-lillo-melo/"));
            startActivity(linkedingIntent);
            Toast.makeText(ContactActivity.this, "esto es una ventana emergente", Toast.LENGTH_SHORT)
                    .show();
    }
});
        binding.imageViewPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        shareWithWsp("esto es un mensaje para enviar por whassapp");
            }
        });
        }
    public void shareWithWsp(String message){
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, message);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}