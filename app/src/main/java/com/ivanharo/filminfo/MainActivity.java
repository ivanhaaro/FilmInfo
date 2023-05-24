package com.ivanharo.filminfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button searchButton;
    private EditText titleText;
    private ListView filmListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchButton = findViewById(R.id.searchButton);
        titleText = findViewById(R.id.titleEditText);
        filmListView = findViewById(R.id.filmListView);
    }

    public void searchFilm(View view) {
        Toast.makeText(this, "Películas...", Toast.LENGTH_SHORT).show();
    }
}