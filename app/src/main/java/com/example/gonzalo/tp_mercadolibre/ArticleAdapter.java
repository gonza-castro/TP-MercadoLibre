package com.example.gonzalo.tp_mercadolibre;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gonzalo.tp_mercadolibre.Models.Articulo;
import com.example.gonzalo.tp_mercadolibre.Models.searchResultItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private List<searchResultItem> articulos = new ArrayList<searchResultItem>();
    private Context adapterContext;

    private static ClickListener clickListener;


    ArticleAdapter(Context context, List<searchResultItem> articulos){
        this.articulos = articulos;
        this.adapterContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.title) TextView title;
        @BindView(R.id.price) TextView price;
        @BindView(R.id.image) ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }
    }



    @Override
    public int getItemCount() {
        return articulos.size();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_articulo, null);

        return new ArticleAdapter.ViewHolder(itemLayoutView);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        searchResultItem articulo = this.articulos.get(position);

        holder.title.setText( articulo.getTitle() );

        holder.price.setText( "$" + articulo.getPrice() );

        Picasso.with(adapterContext).load( articulo.getThumbnail() ).into(holder.image);

    }


    public void setOnItemClickListener(ClickListener clickListener) {
        ArticleAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }
}