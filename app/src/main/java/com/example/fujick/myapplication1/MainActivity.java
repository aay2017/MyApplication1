package com.example.fujick.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText urlInputField;  // old - urlInputField
    Button goButton; // для читаемости кода стоит определить все используемые объекты

    String url; // old name - url - давай объектам осмысленные имена

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // инициализируй объекты один раз - findViewById дорогая операция
        goButton = findViewById(R.id.button);
        urlInputField = findViewById(R.id.link);

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // urlInputField = findViewById(R.id.link);
                url = urlInputField.getText().toString();

                // обрезал пустые символы (пробелы) с начала и конца строки, проверил, что остаток не пустая строка
                if (!url.trim().isEmpty()) {

                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                }
            }
        });
    }

}