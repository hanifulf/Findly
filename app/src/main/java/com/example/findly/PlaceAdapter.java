package com.example.findly;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.VH> {

    private List<PlaceModel> list;
    private Context ctx;
    private SharedPreferences prefs;

    public PlaceAdapter(List<PlaceModel> list, Context ctx, SharedPreferences prefs) {
        this.list = list;
        this.ctx = ctx;
        this.prefs = prefs;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_place, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        PlaceModel p = list.get(position);
        holder.txtName.setText(p.getName());

        String info = "⭐ " + p.getRating() + " • Mulai Rp " + p.getPrice();
        if (p.getDistanceKm() > 0) {
            info += " • Jarak: " + String.format("%.2f km", p.getDistanceKm());
        }
        holder.txtInfo.setText(info);

        holder.itemView.setOnClickListener(v -> {
            Intent i = new Intent(ctx, PlaceDetailActivity.class);
            i.putExtra("place_id", p.getId());
            ctx.startActivity(i);
        });

        boolean fav = prefs.getBoolean("fav_" + p.getId(), false);
        holder.btnFav.setImageResource(fav ?
                android.R.drawable.btn_star_big_on :
                android.R.drawable.btn_star_big_off
        );

        // FAVORIT BUTTON HANDLER
        holder.btnFav.setOnClickListener(v -> {
            boolean current = prefs.getBoolean("fav_" + p.getId(), false);
            boolean newState = !current;

            // Update SharedPreferences
            prefs.edit().putBoolean("fav_" + p.getId(), newState).apply();

            // Update icon
            holder.btnFav.setImageResource(newState ?
                    android.R.drawable.btn_star_big_on :
                    android.R.drawable.btn_star_big_off
            );

            // Jika UNFAVORIT saat berada di FavoriteActivity → langsung hapus item
            if (!newState && ctx instanceof FavoriteActivity) {
                int pos = holder.getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION) {
                    list.remove(pos);
                    notifyItemRemoved(pos);
                    notifyItemRangeChanged(pos, list.size());
                }
            }
        });

        // CALL BUTTON
        holder.btnCall.setOnClickListener(v -> {
            String tel = p.getAddress();
            Intent dial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tel));
            ctx.startActivity(dial);
        });

        // MAP BUTTON
        holder.btnMap.setOnClickListener(v -> {
            Intent mi = new Intent(ctx, MapActivity.class);
            mi.putExtra("lat", p.getLat());
            mi.putExtra("lng", p.getLng());
            mi.putExtra("name", p.getName());
            ctx.startActivity(mi);
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        TextView txtName, txtInfo;
        ImageButton btnFav, btnCall, btnMap;

        VH(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtInfo = itemView.findViewById(R.id.txtInfo);
            btnFav = itemView.findViewById(R.id.btnFav);
            btnCall = itemView.findViewById(R.id.btnCall);
            btnMap = itemView.findViewById(R.id.btnMap);
        }
    }
}
