package com.example.totalkleauge.club;

public class ClubData {
    private int logo;
    private String clubName;

    public ClubData(int logo, String clubName) {
        this.logo = logo;
        this.clubName = clubName;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
}
