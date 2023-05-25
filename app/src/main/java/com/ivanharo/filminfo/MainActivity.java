package com.ivanharo.filminfo;

import androidx.appcompat.app.AppCompatActivity;

import com.ivanharo.filminfo.services.MovieService;
import com.ivanharo.filminfo.services.MovieServiceImpl;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button searchButton;
    private EditText titleText;
    private ListView filmListView;
    private MovieService movieService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieService = new MovieServiceImpl();

        searchButton = findViewById(R.id.searchButton);
        titleText = findViewById(R.id.titleEditText);
        filmListView = findViewById(R.id.filmListView);
    }

    public void searchMovieTitles(View view) throws JSONException, IOException {
        Toast.makeText(this, "Películas...", Toast.LENGTH_SHORT).show();
        List<String> movieTitles = movieService.getFilteredMovieTitles(titleText.getText().toString());

        //for(String s : movieTitles)
        //{
        //    System.out.println((s));
        //}

        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, movieTitles);
        //filmListView.setAdapter(adapter);
    }
}