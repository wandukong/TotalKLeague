package com.example.totalkleauge.club;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.totalkleauge.R;

public class ClubFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_club, container, false);

        RecyclerView rvClub = (RecyclerView) view.findViewById(R.id.rv_club);
        setAdapter(rvClub);

        return view;
    }

    private void setAdapter(RecyclerView rvClub) {
        ClubAdapter clubAdapter = new ClubAdapter();
        clubAdapter.addClubData(new ClubData(R.drawable.logo, "전북 현대\n모터스"));
        clubAdapter.addClubData(new ClubData(R.drawable.logo, "울산 현대\n축구단"));
        clubAdapter.addClubData(new ClubData(R.drawable.logo, "포항\n스틸러스"));
        clubAdapter.addClubData(new ClubData(R.drawable.logo, "상주 상무\n프로축구단"));
        clubAdapter.addClubData(new ClubData(R.drawable.logo, "대구FC"));
        clubAdapter.addClubData(new ClubData(R.drawable.logo, "광주FC"));
        clubAdapter.addClubData(new ClubData(R.drawable.logo, "강원FC"));
        clubAdapter.addClubData(new ClubData(R.drawable.logo, "수원 삼성\n블루윙즈"));
        clubAdapter.addClubData(new ClubData(R.drawable.logo, "FC서울"));
        clubAdapter.addClubData(new ClubData(R.drawable.logo, "성남 FC"));
        clubAdapter.addClubData(new ClubData(R.drawable.logo, "인천\n유나이티드"));
        clubAdapter.addClubData(new ClubData(R.drawable.logo, "부산\n아이파크"));

        rvClub.setAdapter(clubAdapter);
    }
}