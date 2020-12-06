package com.example.totalkleauge.planfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.totalkleauge.Plan;
import com.example.totalkleauge.PlanAdapter;
import com.example.totalkleauge.PlanDataBase;
import com.example.totalkleauge.R;

import java.util.ArrayList;
import java.util.List;

public class Plan05Fragment extends Fragment {

    private List<Plan> planList;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plan05, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final PlanDataBase db = Room.databaseBuilder(view.getContext(), PlanDataBase.class, "plan_table")
                .allowMainThreadQueries()
                .build();

        planList = db.planDao().getPlan("5");

        recyclerView = view.findViewById(R.id.recyclerView_plan05);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new PlanAdapter(planList, view.getContext());
        recyclerView.setAdapter(adapter);

    }
}