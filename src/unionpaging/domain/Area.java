package unionpaging.domain;

public class Area {
    private int aid;
    private String aname;
    private Country country;

    public Area(){}

    public Area(int aid, String aname, Country country) {
        this.aid = aid;
        this.aname = aname;
        this.country = country;
    }

    public int getAid() {
        return aid;
    }

    public String getAname() {
        return aname;
    }

    public Country getCountry() {
        return country;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
