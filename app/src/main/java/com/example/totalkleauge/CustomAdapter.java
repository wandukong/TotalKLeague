package com.example.totalkleauge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<Plan> planList;
    private Context context;

    public CustomAdapter(ArrayList<Plan> planList, Context context) {
        this.planList = planList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_plan, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Glide.with(holder.iv_home).load(planList.get(position).getHomeImage());
        Glide.with(holder.iv_away).load(planList.get(position).getAwayImage());
        holder.tv_home.setText(planList.get(position).getHome());
        holder.tv_homeScore.setText(planList.get(position).getHomeScore());
        holder.tv_away.setText(planList.get(position).getAway());
        holder.tv_awayScore.setText(planList.get(position).getAwayScore());
    }

    @Override
    public int getItemCount() {
        return planList == null ? 0 : planList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_home, iv_away;
        TextView tv_home, tv_homeScore, tv_away, tv_awayScore;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_home = itemView.findViewById(R.id.iv_home);
            this.iv_away = itemView.findViewById(R.id.iv_away);
            this.tv_home = itemView.findViewById(R.id.tv_home);
            this.tv_homeScore = itemView.findViewById(R.id.tv_homeScore);
            this.tv_away = itemView.findViewById(R.id.tv_away);
            this.tv_awayScore = itemView.findViewById(R.id.tv_awayScore);

        }
    }
}
