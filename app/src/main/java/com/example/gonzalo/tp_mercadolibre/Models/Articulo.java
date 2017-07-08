package com.example.gonzalo.tp_mercadolibre.Models;

import java.util.ArrayList;

/**
 * Created by Gonzalo on 4/7/2017.
 */

public class Articulo {

    private String title;
    private String price;
    private ArrayList<Imagen> pictures;

    public ArrayList<Imagen> getPictures() {
        return pictures;
    }

    public void setPictures(ArrayList<Imagen> pictures) {
        this.pictures = pictures;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() { return title; }

    public String getPrice() {
        return price;
    }
}
