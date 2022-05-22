package com.projek.rajaongkir.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.projek.rajaongkir.R;
import com.projek.rajaongkir.network.DataOngkir;

import java.util.List;

public class MainAdapterProfile extends RecyclerView.Adapter<MainAdapterProfile.viewHolder> {
    Context context;
    List<DataOngkir> list;
    MainContactProfile.view mView;

    public MainAdapterProfile(Context context, List<DataOngkir> list, MainContactProfile.view mView){
        this.context = context;
        this.list = list;
        this.mView = mView;
    }

    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_profile,parent,false);
        return new viewHolder(view);
    }

    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final DataOngkir item = list.get(position);
        holder.tvNama.setText(item.getNama());
        holder.tvAlamat.setText(item.getAlamat());
        holder.tvTelpon.setText(item.getTelpon());
        holder.tvOngkir.setText(item.getOngkir());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mView.editData(item);
            }
        });
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mView.deleteData(item);
                return true;
            }
        });
    }

    public int getItemCount() {
        return  list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvAlamat, tvTelpon, tvOngkir, id;
        CardView cardView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvTelpon = itemView.findViewById(R.id.tvTelpon);
            tvOngkir = itemView.findViewById(R.id.tvOngkir);
            id = itemView.findViewById(R.id.id);
            cardView = itemView.findViewById(R.id.cv_item);
        }

    }
}
