package com.ivanharo.filminfo.services;

import com.ivanharo.filminfo.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieServiceImpl implements MovieService {

    public MovieServiceImpl() {

    }

    private JSONArray getFilteredMoviesResponse(String query) throws java.io.IOException, JSONException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/search/movie?query=" + query + "&include_adult=false&language=en-US&page=1")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmZDM4MmQ0NjIwMTcwZGEyMDE0MGUwNzJlNzkyNzk3ZSIsInN1YiI6IjY0NmNmZDM3YTUwNDZlMDE2ODM4OTVjMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.OnJ5GdXp0zK9Y0EM4nxPOkkwtVNk-b__9BiYfuqtEcY")
                .build();

        Response response = client.newCall(request).execute();
        String responseData = response.body().string();

        // Parse the JSON response
        JSONObject jsonObject = new JSONObject(responseData);
        JSONArray results = jsonObject.getJSONArray("results");

        return results;
    }

    public List<String> getFilteredMovieTitles(String query) throws java.io.IOException, JSONException {
        List<String> movieTitles = new ArrayList<>();

        JSONArray results = getFilteredMoviesResponse(query);

        // Extract the movie titles from the results
        for (int i = 0; i < results.length(); i++) {
            JSONObject movieObject = results.getJSONObject(i);
            String title = movieObject.getString("title");
            movieTitles.add(title);
        }

        return movieTitles;
    }

}
