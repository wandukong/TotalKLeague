package com.example.totalkleauge.rank;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.totalkleauge.R;

import java.util.ArrayList;

public class RankAdapter extends RecyclerView.Adapter<RankAdapter.RankViewHodler> {

    ArrayList<RankData> rankData = new ArrayList<>();

    @NonNull
    @Override
    public RankAdapter.RankViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_rank,parent,false);
        return new RankViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RankAdapter.RankViewHodler holder, int position) {
        RankData rank = rankData.get(position);
        holder.bind(rank);
    }

    @Override
    public int getItemCount() { return rankData.size(); }

    public void addRankData(RankData rankData) { this.rankData.add(rankData); }

    public RankData getRankData(int position) { return rankData.get(position);}

    public static class RankViewHodler extends RecyclerView.ViewHolder {

        TextView tvNumber;
        ImageView teamImage;
        TextView tvName;
        TextView tvMatch;
        TextView tvWin;
        TextView tvDraw;
        TextView tvLose;
        TextView tvPlus;
        TextView tvEqual;
        TextView tvPoint;

        public RankViewHodler(@NonNull View itemView) {
            super(itemView);
             tvNumber= itemView.findViewById(R.id.tv_number);
             teamImage = itemView.findViewById(R.id.iv_team);
             tvName = itemView.findViewById(R.id.tv_name);
             tvMatch = itemView.findViewById(R.id.tv_match);
             tvWin = itemView.findViewById(R.id.tv_win);
             tvDraw = itemView.findViewById(R.id.tv_draw);
             tvLose = itemView.findViewById(R.id.tv_lose);
             tvPlus = itemView.findViewById(R.id.tv_plus);
             tvEqual = itemView.findViewById(R.id.tv_equal);
             tvPoint = itemView.findViewById(R.id.tv_point);

        }

        void bind(RankData rank) {
            tvNumber.setText(rank.getNumber());
            teamImage.setImageResource(rank.getTeam_image());
            tvName.setText(rank.getTeam_name());
            tvMatch.setText(rank.getMatch());
            tvWin.setText(rank.getWin());
            tvDraw.setText(rank.getDraw());
            tvLose.setText(rank.getLose());
            tvPlus.setText(rank.getPlus());
            tvEqual.setText(rank.getEqual());
            tvPoint.setText(rank.getPoint());

        }
    }

}
