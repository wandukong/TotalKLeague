package com.example.totalkleauge.rank;

public class RankData {
    String number;
    int team_image;
    String team_name;
    String match;
    String win;
    String draw;
    String lose;
    String plus;
    String equal;
    String point;

    public RankData(String number, int team_image, String team_name, String match, String win, String draw, String lose, String plus,
            String equal, String point)
    {
        this.number = number;
        this.team_image = team_image;
        this.team_name = team_name;
        this.match = match;
        this.win = win;
        this.draw = draw;
        this.lose = lose;
        this.plus = plus;
        this.equal = equal;
        this.point = point;
    }

    public String getNumber() {return number;}
    public void setNumber(String number){this.number = number;}

    public int getTeam_image() { return team_image;}
    public void setTeam_image(int team_image) {this.team_image=team_image;}

    public String getTeam_name(){return team_name;}
    public void setTeam_name(String team_name){this.team_name = team_name;}

    public String getMatch(){return match;}
    public void setMatch(String match) {this.match = match;}

    public String getWin(){return win;}
    public void setWin(String win) {this.win = win;}

    public String getDraw(){return draw;}
    public void setDraw(String draw) {this.draw= draw;}

    public String getLose() {return lose;}
    public void setLose(String lose) {this.lose = lose;}

    public String getPlus() {return plus;}
    public void setPlus(String plus) {this.plus = plus;}

    public String getEqual() {return equal;}
    public void setEqual(String equal) {this.equal = equal;}

    public String getPoint(){return point;}
    public void setPoint(String point) {this.point = point;}



}
