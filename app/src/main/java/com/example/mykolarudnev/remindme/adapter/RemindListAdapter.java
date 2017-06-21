package com.example.mykolarudnev.remindme.adapter;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mykolarudnev.remindme.R;
import com.example.mykolarudnev.remindme.dto.RemindDto;

import java.util.List;

public class RemindListAdapter extends  RecyclerView.Adapter<RemindListAdapter.ReminfViewHolder> {

    private List<RemindDto> data;

    public RemindListAdapter(List<RemindDto> data) {
        this.data = data;
    }

    @Override
    public ReminfViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.remind_item,parent,false);


        return  new ReminfViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReminfViewHolder holder, int position) {

        RemindDto item= data.get(position);
        holder.title.setText(item.getTitle());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ReminfViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView title;


        public ReminfViewHolder(View itemView ) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            title= (TextView) itemView.findViewById(R.id.title);

        }
    }

}
