package com.example.class236sharepreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edit_text_id;
    AppCompatButton btn, btn2;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //======================================
        edit_text_id = findViewById(R.id.edit_text_id);
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);

        sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);
        editor = sharedPreferences.edit();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = edit_text_id.getText().toString();
                editor.putString("text", text);
                editor.apply();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                startActivity(intent);

            }
        });







    }
}