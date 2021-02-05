package java8.policies;

import java.util.Objects;

public class Area {

    private String city;
    private String distric;

    public Area(String dity, String distric) {
        this.city = dity;
        this.distric = distric;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistric() {
        return distric;
    }

    public void setDistric(String distric) {
        this.distric = distric;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Area)) return false;
        Area area = (Area) o;
        return Objects.equals(city, area.city) &&
                Objects.equals(distric, area.distric);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, distric);
    }

    @Override
    public String toString() {
        return "Area{" +
                "city='" + city + '\'' +
                ", distric='" + distric + '\'' +
                '}';
    }
}
