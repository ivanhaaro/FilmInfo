package com.ivanharo.filminfo.services;

import org.json.JSONException;

import java.util.List;

public interface MovieService {
    List<String> getFilteredMovieTitles(String query) throws java.io.IOException, JSONException;
}
