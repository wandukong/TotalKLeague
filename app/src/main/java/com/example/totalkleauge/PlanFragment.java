package com.example.totalkleauge;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PlanFragment extends Fragment {

    private ViewPager viewPager;
    private PlanPagerAdapter planPagerAdapter;
    private TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plan, container, false);

//        recyclerView = view.findViewById(R.id.recyclerView_plan);
//        recyclerView.setHasFixedSize(true); // 리사이클러뷰 기존 성능 강화
//        layoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(layoutManager);
//        planList = new ArrayList<>();   // 객체를 담을 arrayList
//
//
//        database = FirebaseDatabase.getInstance();  // 파이어베이스 데이터베이스 연동
//        databaseReference = database.getReference("Plan_05"); // DB 테이블 연결
//        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                planList.clear(); // 기존 arrayList가 존재하지 않게 초기화
//                for (DataSnapshot plans : dataSnapshot.getChildren()) { // 반복문으로 데이터 List 추출
//                    for(DataSnapshot rounds : plans.getChildren()){
//                        Plan plan = rounds.getValue(Plan.class); // 만들어놨던 Plan 객체에 데이터를 담는다
//                        planList.add(plan);
//                    }
//                }
//                adapter.notifyDataSetChanged(); // 리스트 저장 및 새로고침
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Log.e("PlagFragment", String.valueOf(databaseError.toException())); // 에러 발성시 로그 출력
//            }
//        });
//
//        adapter = new CustomAdapter(planList, getContext());
//        recyclerView.setAdapter(adapter); // 리사이클러뷰에 어댑터 연결
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = view.findViewById(R.id.vp_plan);
        planPagerAdapter = new PlanPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(planPagerAdapter);
        tabLayout = view.findViewById(R.id.tl_plan);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("5월");
        tabLayout.getTabAt(1).setText("6월");
        tabLayout.getTabAt(2).setText("7월");
        tabLayout.getTabAt(3).setText("8월");
        tabLayout.getTabAt(4).setText("9월");
        tabLayout.getTabAt(5).setText("10월");
        tabLayout.getTabAt(6).setText("11월");
    }
}