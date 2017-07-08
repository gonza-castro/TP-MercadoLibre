package com.example.gonzalo.tp_mercadolibre;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.gonzalo.tp_mercadolibre.API.API;
import com.example.gonzalo.tp_mercadolibre.Models.searchResultItem;
import com.example.gonzalo.tp_mercadolibre.Models.searchResultList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.textBoxSearch)EditText textBoxSearch;
    @BindView(R.id.reciclador)RecyclerView recicler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recicler.setLayoutManager(llm);


    }

    @OnClick(R.id.buttonSearch)
    public void buttonSearchTap() {

        String query = textBoxSearch.getText().toString();

        if( query != "" ) {

            API.search(query, new Callback<searchResultList>() {
                @Override
                public void onResponse(Call<searchResultList> call, Response<searchResultList> response) {
                    if(response.isSuccessful()) {

                        searchResultList received = response.body();

                        final List<searchResultItem> searchResults = received.getResults();

                        ArticleAdapter adapter = new ArticleAdapter(MainActivity.this, searchResults);
                        recicler.setAdapter(adapter);

                        adapter.setOnItemClickListener(new ArticleAdapter.ClickListener() {
                            @Override
                            public void onItemClick(int position, View v) {
                                Log.d(TAG, "onItemClick position: " + searchResults.get(position).getId() );

                                Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                                intent.putExtra("ID", searchResults.get(position).getId() );
                                startActivity(intent);
                            }
                        });

                    }
                }
                @Override
                public void onFailure(Call<searchResultList> call, Throwable t) {
                    Log.i(TAG, "Error en la búsqueda.");
                }
            });
        }

    }


}
