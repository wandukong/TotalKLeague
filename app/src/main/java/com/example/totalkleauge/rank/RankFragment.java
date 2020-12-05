package com.example.totalkleauge.rank;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.totalkleauge.R;
import com.example.totalkleauge.club.ClubAdapter;
import com.example.totalkleauge.club.ClubData;

public class RankFragment extends Fragment {

    public RankFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view =  inflater.inflate(R.layout.fragment_club, container, false);

        RecyclerView rcv_rank = (RecyclerView) view.findViewById(R.id.rcv_rank);
        setAdapter(rcv_rank);

        return view;
    }

    private void setAdapter(RecyclerView rcv_rank) {
        RankAdapter rankAdapter = new RankAdapter();
        rankAdapter.addRankData(new RankData("1",R.drawable.jeonbuk,"전북 현대 모터스","27","19","3","5","46-21","25","60"));
        rankAdapter.addRankData(new RankData("2",R.drawable.ulsan,"울산 현대 축구단","27","17","6","4","54-23","31","57"));
        rankAdapter.addRankData(new RankData("3",R.drawable.pohang,"포항 스틸러스","27","15","5","7","56-35","21","50"));
        rankAdapter.addRankData(new RankData("4",R.drawable.sangju,"상주 상무 프로축구단","27","13","5","9","34-36","-2","44"));
        rankAdapter.addRankData(new RankData("5",R.drawable.daegu,"대구FC","27","10","8","9","43-39","4","38"));
        rankAdapter.addRankData(new RankData("6",R.drawable.gwangju,"광주FC","27","6","7","14","32-46","-14","25"));
        rankAdapter.addRankData(new RankData("7",R.drawable.gangwon,"강원FC","27","9","7","11","36-41","-5","34"));
        rankAdapter.addRankData(new RankData("8",R.drawable.suwon,"수원 루윙즈","27","8","7","12","27-30","-3","31"));
        rankAdapter.addRankData(new RankData("9",R.drawable.seoul,"FC서울","27","8","5","14","23-44","-21","29"));
        rankAdapter.addRankData(new RankData("10",R.drawable.seongnam,"성남FC","27","7","7","13","24-37","-13","28"));
        rankAdapter.addRankData(new RankData("11",R.drawable.incheon,"인천 유나이티드","27","7","6","14","25-35","-10","27"));
        rankAdapter.addRankData(new RankData("12",R.drawable.busan,"부산 아이파크","27","5","10","12","25-38","-13","25"));
    }

}