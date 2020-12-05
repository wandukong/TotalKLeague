package com.example.totalkleauge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.PlanViewHolder> {

    private List<Plan> planList;
    private Context context;

    public PlanAdapter(List<Plan> planList, Context context) {
        this.planList = planList;
        this.context = context;
    }

    @NonNull
    @Override
    public PlanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_plan, parent, false);
        PlanViewHolder holder = new PlanViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlanViewHolder holder, int position) {

        holder.tvRound.setText(planList.get(position).getRound());
        holder.tvDate.setText(planList.get(position).getDate());
        holder.tvTime.setText(planList.get(position).getTime());
        holder.tvHome.setText(planList.get(position).getHome());
        holder.tvHomeScore.setText(planList.get(position).getHomeScore());
        holder.tvAway.setText(planList.get(position).getAway());
        holder.tvAwayScore.setText(planList.get(position).getAwayScore());

        setHomeLogo(holder.ivHome, position);
        setAwayLogo(holder.ivAway, position);
    }

    @Override
    public int getItemCount() {
        return planList == null ? 0 : planList.size();
    }

    public class PlanViewHolder extends RecyclerView.ViewHolder {

        ImageView ivHome, ivAway;
        TextView tvRound, tvDate, tvTime, tvHome, tvHomeScore, tvAway, tvAwayScore;

        public PlanViewHolder(@NonNull View itemView) {
            super(itemView);

            this.tvRound = itemView.findViewById(R.id.tv_round);
            this.tvDate = itemView.findViewById(R.id.tv_date);
            this.tvTime = itemView.findViewById(R.id.tv_time);
            this.ivHome = itemView.findViewById(R.id.iv_home);
            this.ivAway = itemView.findViewById(R.id.iv_away);
            this.tvHome = itemView.findViewById(R.id.tv_home);
            this.tvHomeScore = itemView.findViewById(R.id.tv_homeScore);
            this.tvAway = itemView.findViewById(R.id.tv_away);
            this.tvAwayScore = itemView.findViewById(R.id.tv_awayScore);
        }
    }

    private void setHomeLogo(ImageView imageView, int pos){
        if(planList.get(pos).getHome() == "전북"){
            imageView.setImageResource(R.id.jeonbuk);
        }else if(planList.get(pos).getHome() == "울산"){
            imageView.setImageResource(R.id.ulsan);
        }else if(planList.get(pos).getHome() == "포항"){
            imageView.setImageResource(R.id.pohang);
        }
        else if(planList.get(pos).getHome() == "상주"){
            imageView.setImageResource(R.id.sangju);
        }
        else if(planList.get(pos).getHome() == "대구"){
            imageView.setImageResource(R.id.daegu);
        }
        else if(planList.get(pos).getHome() == "광주"){
            imageView.setImageResource(R.id.gwangju);
        }
        else if(planList.get(pos).getHome() == "강원"){
            imageView.setImageResource(R.id.gangwon);
        }
        else if(planList.get(pos).getHome() == "수원"){
            imageView.setImageResource(R.id.suwon);
        }
        else if(planList.get(pos).getHome() == "서울"){
            imageView.setImageResource(R.id.seoul);
        }
        else if(planList.get(pos).getHome() == "성남"){
            imageView.setImageResource(R.id.seongnam);
        }
        else if(planList.get(pos).getHome() == "인천"){
            imageView.setImageResource(R.id.incheon);
        }
        else if(planList.get(pos).getHome() == "부산"){
            imageView.setImageResource(R.id.busan);
        }
    }

    private void setAwayLogo(ImageView imageView, int pos) {
        if(planList.get(pos).getAway() == "전북"){
            imageView.setImageResource(R.id.jeonbuk);
        }else if(planList.get(pos).getAway() == "울산"){
            imageView.setImageResource(R.id.ulsan);
        }else if(planList.get(pos).getAway() == "포항"){
            imageView.setImageResource(R.id.pohang);
        }
        else if(planList.get(pos).getAway() == "상주"){
            imageView.setImageResource(R.id.sangju);
        }
        else if(planList.get(pos).getAway() == "대구"){
            imageView.setImageResource(R.id.daegu);
        }
        else if(planList.get(pos).getAway() == "광주"){
            imageView.setImageResource(R.id.gwangju);
        }
        else if(planList.get(pos).getAway() == "강원"){
            imageView.setImageResource(R.id.gangwon);
        }
        else if(planList.get(pos).getAway() == "수원"){
            imageView.setImageResource(R.id.suwon);
        }
        else if(planList.get(pos).getAway() == "서울"){
            imageView.setImageResource(R.id.seoul);
        }
        else if(planList.get(pos).getAway() == "성남"){
            imageView.setImageResource(R.id.seongnam);
        }
        else if(planList.get(pos).getAway() == "인천"){
            imageView.setImageResource(R.id.incheon);
        }
        else if(planList.get(pos).getAway() == "부산"){
            imageView.setImageResource(R.id.busan);
        }
    }

}
