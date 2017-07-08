package com.example.gonzalo.tp_mercadolibre.API;

import com.example.gonzalo.tp_mercadolibre.Interfaces.MercadoLibreAPI;
import com.example.gonzalo.tp_mercadolibre.Models.Articulo;
import com.example.gonzalo.tp_mercadolibre.Models.searchResultList;
import com.google.gson.Gson;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Gonzalo on 4/7/2017.
 */

public class API {

    private static MercadoLibreAPI getAPI() {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create( new Gson() ))
                .baseUrl("https://api.mercadolibre.com/")
                .build();
        MercadoLibreAPI service = retrofit.create(MercadoLibreAPI.class);

        return service;

    }

    public static void getArticle(String id, Callback<Articulo> callback) {
        getAPI().getArticle(id).enqueue(callback);
    }

    public static void search(String query, Callback<searchResultList> callback) {
        getAPI().search(query).enqueue(callback);
    }

}
