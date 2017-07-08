package com.example.gonzalo.tp_mercadolibre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gonzalo.tp_mercadolibre.API.API;
import com.example.gonzalo.tp_mercadolibre.Models.Articulo;
import com.example.gonzalo.tp_mercadolibre.Models.Imagen;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {

    private static final String TAG = "ProductActivity";


    @BindView(R.id.mainTitle)TextView mainTitle;
    @BindView(R.id.price)TextView price;
    @BindView(R.id.imgsContainer)LinearLayout imgsContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String id = intent.getStringExtra("ID");

        Log.i(TAG, "LLEGO . " + id );

        API.getArticle(id, new Callback<Articulo>() {
            @Override
            public void onResponse(Call<Articulo> call, Response<Articulo> response) {
                if(response.isSuccessful()) {
                    Articulo received = response.body();
                    Log.i(TAG, "Artículo descargado: " + received.getTitle());

                    mainTitle.setText( received.getTitle() );
                    price.setText( "$" + received.getPrice() );

                    ArrayList<Imagen> pictures = received.getPictures();


                    for (int i = 0 ; i < pictures.size() ; i++)
                    {
                        ImageView image = new ImageView(ProductActivity.this);
                        Picasso.with(ProductActivity.this).load(pictures.get(i).getUrl()).into(image);

                        imgsContainer.addView(image);
                    }
                }
            }
            @Override
            public void onFailure(Call<Articulo> call, Throwable t) {

            }
        });


    }
}
