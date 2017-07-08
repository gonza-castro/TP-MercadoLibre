package com.example.gonzalo.tp_mercadolibre.Interfaces;

import com.example.gonzalo.tp_mercadolibre.Models.Articulo;
import com.example.gonzalo.tp_mercadolibre.Models.searchResultList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Gonzalo on 4/7/2017.
 */

public interface MercadoLibreAPI {

    @GET("items/{itemId}")
    Call<Articulo> getArticle(@Path("itemId") String id);

    @GET("sites/MLA/search")
    Call<searchResultList> search(@Query("q") String query);

}
