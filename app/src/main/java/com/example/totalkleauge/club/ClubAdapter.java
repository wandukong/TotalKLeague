package com.example.totalkleauge.club;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.totalkleauge.R;
import com.example.totalkleauge.VideoActivity;

import java.util.ArrayList;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ClubViewHolder> {
    ArrayList<ClubData> clubData = new ArrayList<>();



    @NonNull
    @Override
    public ClubAdapter.ClubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_club, parent, false);
        return new ClubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubAdapter.ClubViewHolder holder, int position) {
        ClubData club = clubData.get(position);
        holder.bind(club);
    }

    @Override
    public int getItemCount() {
        return clubData.size();
    }

    public void addClubData(ClubData clubData) { this.clubData.add(clubData); }

    public ClubData getClubData(int position) { return clubData.get(position); }

    public static class ClubViewHolder extends RecyclerView.ViewHolder {

        ImageView imgLogo;
        TextView tvName;

        public ClubViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.img_club_logo);
            tvName = itemView.findViewById(R.id.tv_club_name);
        }

        void bind(final ClubData club) {
            imgLogo.setImageResource(club.getLogo());
            tvName.setText(club.getClubName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), VideoActivity.class);
                    intent.putExtra("club", club.getClubName());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
