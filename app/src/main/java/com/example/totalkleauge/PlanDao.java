package com.example.totalkleauge;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PlanDao {

    @Query("SELECT * FROM `plan` WHERE date LIKE :month ||'.%%'")
    List<Plan> getPlan(String month);
}
