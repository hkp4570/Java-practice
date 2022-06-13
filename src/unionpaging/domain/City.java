package unionpaging.domain;

public class City {
    private int cityid;
    private String cityname;
    private int citysize;
    private Area aid;

    public City(){};

    public City(int cityid, String cityname, int citysize, Area aid) {
        this.cityid = cityid;
        this.cityname = cityname;
        this.citysize = citysize;
        this.aid = aid;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public int getCitysize() {
        return citysize;
    }

    public void setCitysize(int citysize) {
        this.citysize = citysize;
    }

    public Area getAid() {
        return aid;
    }

    public void setAid(Area aid) {
        this.aid = aid;
    }
}
