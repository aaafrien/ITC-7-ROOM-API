package com.itc.weatherapi;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.itc.weatherapi.database.Entity;
import com.itc.weatherapi.model.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    List<Entity> entities;

    public Adapter(Context context, List<Entity> entities) {
        this.context = context;
        this.entities = entities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_cardview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(entities.get(position));
    }

    @Override
    public int getItemCount() {
        return entities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void onBind(Entity entity) {
            CardView cardView = itemView.findViewById(R.id.cv_city);
            ArrayList<TextView> textViews = new ArrayList<>(
                    Arrays.asList(
                            itemView.findViewById(R.id.tv_city)
                    )
            );

            textViews.get(0).setText(entity.getNama());

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent pindah = new Intent(context, WeatherDetail.class);
                    pindah.putExtra("id", entity.getId());
                    pindah.putExtra("temp", entity.getMain());
                    pindah.putExtra("cuaca", entity.getWeather());
                    pindah.putExtra("tempat", entity.getNama());
                    pindah.putExtra("country", entity.getSys());
                    context.startActivity(pindah);
                }
            });
        }
    }
}
