package com.example.totalkleauge;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "plan")
public class Plan {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name="round")
    private int round;
    @ColumnInfo(name="date")
    private String date;
    @ColumnInfo(name="time")
    private String time;
    @ColumnInfo(name="home")
    private String home;
    @ColumnInfo(name="home_score")
    private String homeScore;
    @ColumnInfo(name="away")
    private String away;
    @ColumnInfo(name="away_score")
    private String awayScore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(String homeScore) {
        this.homeScore = homeScore;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public String getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(String awayScore) {
        this.awayScore = awayScore;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", round=" + round +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", home='" + home + '\'' +
                ", homeScore='" + homeScore + '\'' +
                ", away='" + away + '\'' +
                ", awayScore='" + awayScore + '\'' +
                '}';
    }
}
