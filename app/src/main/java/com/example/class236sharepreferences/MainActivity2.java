package com.example.class236sharepreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {


    TextView text_id;

    SharedPreferences sharedPreferences;

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //===============================

        text_id = findViewById(R.id.text_id);
        btnBack = findViewById(R.id.btnBack);

        sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);

        String text = sharedPreferences.getString("text", "");
        text_id.setText(text);

        btnBack.setOnClickListener(v -> {
            finish();
        });


    }
}