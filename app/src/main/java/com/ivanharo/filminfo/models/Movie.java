package com.ivanharo.filminfo.models;

import java.util.Date;

public class Movie {

    private String title;
    private Date date;
    private String language;
    private String description;


    public Movie() {

    }

    public Movie(String title) {
        this.title = title;
    }

    public Movie(String title, Date date, String language, String description) {
        this.title = title;
        this.date = date;
        this.language = language;
        this.description = description;
    }
}
