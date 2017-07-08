package com.example.gonzalo.tp_mercadolibre.Models;

/**
 * Created by Gonzalo on 4/7/2017.
 */

public class searchResultItem {

    private String id;
    private String title;
    private String price;
    private String available_quantity;
    private String sold_quantity;
    private String thumbnail;

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setAvailable_quantity(String available_quantity) {
        this.available_quantity = available_quantity;
    }

    public void setSold_quantity(String sold_quantity) {
        this.sold_quantity = sold_quantity;
    }

    public String getId() {

        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getAvailable_quantity() {
        return available_quantity;
    }

    public String getSold_quantity() {
        return sold_quantity;
    }
}
