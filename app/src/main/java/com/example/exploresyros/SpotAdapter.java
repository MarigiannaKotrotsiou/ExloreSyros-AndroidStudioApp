package com.example.exploresyros;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SpotAdapter extends RecyclerView.Adapter<SpotAdapter.SpotViewHolder> {

    private Context mContext;
    final private ItemClickListener mItemClickListener;
    private List<Spot> spotList;

    public List<Spot> getSpots(){
        return spotList;
    }
    public SpotAdapter(Context context, ItemClickListener listener) {
        mContext = context;
        mItemClickListener = listener;
    }

    @NonNull
    @Override
    public SpotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.spots_card, parent, false);
        return new SpotViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SpotViewHolder holder, int position) {
        Spot spot = spotList.get(position);
        holder.title.setText(spot.getName());


        Log.d("thumbnail id", String.valueOf(spot.getThumbnailResourceID()));
        holder.thumbnail.setImageResource(spot.getThumbnailResourceID());

        holder.thumbnail.setContentDescription(spot.getImageContentDescription());
    }

    @Override
    public int getItemCount() {
        if (spotList == null)
            return 0;
        return spotList.size();
    }

    public void setSpots(List<Spot> spots) {
        spotList = spots;
        notifyDataSetChanged();
        for (com.example.exploresyros.Spot spot : spots)
            Log.d("Adapter: ", spot.getName());
    }
    public String getSpotName(int index) {
        com.example.exploresyros.Spot spot = spotList.get(index);
        return spot.getName();
    }

    public interface ItemClickListener {
        void onItemClickListener(int itemId);
    }

    public class SpotViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title, count;
        private ImageView thumbnail;

        public SpotViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            count = view.findViewById(R.id.imgtts);
            thumbnail = view.findViewById(R.id.thumbnailimg);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mItemClickListener.onItemClickListener(getAdapterPosition());
        }
    }
}
