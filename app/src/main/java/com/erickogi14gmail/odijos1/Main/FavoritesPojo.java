package com.erickogi14gmail.odijos1.Main;

import java.io.Serializable;

/**
 * Created by Eric on 9/12/2017.
 */

public class FavoritesPojo implements Serializable {
    private int favourite_id;
    private String fav_name;
    private String fav_rating;
    private String fav_time;
    private String fav_rate;

    private int odijo_id;
    private String odijo_name;
    private String odijo_rating;
    private String odijo_time;
    private String odijo_rate;
    private String odijo_availability;
    private String odijo_qualifications;
    private String odijo_img_url;
    private int isFavorite;

    public FavoritesPojo(int odijo_id, String odijo_name, String odijo_rating, String odijo_time, String odijo_rate, String odijo_availability, String odijo_qualifications, String odijo_img_url, int isFavorite) {
        this.odijo_id = odijo_id;
        this.odijo_name = odijo_name;
        this.odijo_rating = odijo_rating;
        this.odijo_time = odijo_time;
        this.odijo_rate = odijo_rate;
        this.odijo_availability = odijo_availability;
        this.odijo_qualifications = odijo_qualifications;
        this.odijo_img_url = odijo_img_url;
        this.isFavorite = isFavorite;
    }


    public int getOdijo_id() {
        return odijo_id;
    }

    public void setOdijo_id(int odijo_id) {
        this.odijo_id = odijo_id;
    }

    public String getOdijo_name() {
        return odijo_name;
    }

    public void setOdijo_name(String odijo_name) {
        this.odijo_name = odijo_name;
    }

    public String getOdijo_rating() {
        return odijo_rating;
    }

    public void setOdijo_rating(String odijo_rating) {
        this.odijo_rating = odijo_rating;
    }

    public String getOdijo_time() {
        return odijo_time;
    }

    public void setOdijo_time(String odijo_time) {
        this.odijo_time = odijo_time;
    }

    public String getOdijo_rate() {
        return odijo_rate;
    }

    public void setOdijo_rate(String odijo_rate) {
        this.odijo_rate = odijo_rate;
    }

    public String getOdijo_availability() {
        return odijo_availability;
    }

    public void setOdijo_availability(String odijo_availability) {
        this.odijo_availability = odijo_availability;
    }

    public String getOdijo_qualifications() {
        return odijo_qualifications;
    }

    public void setOdijo_qualifications(String odijo_qualifications) {
        this.odijo_qualifications = odijo_qualifications;
    }

    public String getOdijo_img_url() {
        return odijo_img_url;
    }

    public void setOdijo_img_url(String odijo_img_url) {
        this.odijo_img_url = odijo_img_url;
    }

    public int getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(int isFavorite) {
        this.isFavorite = isFavorite;
    }

    public FavoritesPojo(int favourite_id, String fav_name, String fav_rating, String fav_time, String fav_rate) {
        this.favourite_id = favourite_id;
        this.fav_name = fav_name;
        this.fav_rating = fav_rating;
        this.fav_time = fav_time;
        this.fav_rate = fav_rate;
    }

    public int getFavourite_id() {
        return favourite_id;
    }

    public void setFavourite_id(int favourite_id) {
        this.favourite_id = favourite_id;
    }

    public String getFav_name() {
        return fav_name;
    }

    public void setFav_name(String fav_name) {
        this.fav_name = fav_name;
    }

    public String getFav_rating() {
        return fav_rating;
    }

    public void setFav_rating(String fav_rating) {
        this.fav_rating = fav_rating;
    }

    public String getFav_time() {
        return fav_time;
    }

    public void setFav_time(String fav_time) {
        this.fav_time = fav_time;
    }

    public String getFav_rate() {
        return fav_rate;
    }

    public void setFav_rate(String fav_rate) {
        this.fav_rate = fav_rate;
    }
}
