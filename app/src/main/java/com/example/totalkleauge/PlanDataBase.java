package com.example.totalkleauge;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Plan.class}, version = 1)
public abstract class PlanDataBase extends RoomDatabase {
    public abstract PlanDao planDao();
}
