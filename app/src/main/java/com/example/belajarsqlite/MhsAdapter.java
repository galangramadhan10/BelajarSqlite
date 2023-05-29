package com.example.belajarsqlite;

import android.location.GnssAntennaInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.recyclerview.R;

import java.util.ArrayList;

public class MhsAdapter extends RecyclerView.Adapter<MhsAdapter.MhasVH>{

    private ArrayList<MhsModel> mhslist;
    private final OnItemClickListener listener;


    public MhsAdapter(ArrayList<MhsModel> mhslist,  OnItemClickListener listener) {
        this.mhslist = mhslist;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MhasVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.item_listmhs, parent, false);

        return new MhasVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MhasVH holder, int position) {
        holder.tvNamaVal.setText(mhslist.get(position).getNama());
        holder.tvNimVal.setText(mhslist.get(position).getNim());
        holder.tvNoHpVal.setText(mhslist.get(position).getnoHp());

        holder.bind(mhslist, position, listener);
    }

    public interface  OnItemClickListener{
        void  OnItemClick(ArrayList<MhsModel> mhslist, int position);
    }

    public void removeItem(int position){
        this.mhslist.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mhslist.size();
    }

    public class MhasVH extends RecyclerView.ViewHolder {

        private TextView tvNamaVal, tvNimVal, tvNoHpVal;
        private CardView cvItem;

        public MhasVH(@NonNull View itemView) {
            super(itemView);

            tvNamaVal = itemView.findViewById(R.id.tvNamaVal);
            tvNimVal = itemView.findViewById(R.id.tvNimVal);
            tvNoHpVal = itemView.findViewById(R.id.tvNoHpVal);
            cvItem = itemView.findViewById(R.id.cvItem);

        }

        public void bind(final ArrayList<MhsModel> mhslist, int position, OnItemClickListener listener){
            cvItem.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    listener.OnItemClick(mhslist, position);
                    notifyDataSetChanged();
                }
            });
        }

    }
}