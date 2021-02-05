package java8.policies;

public class Policy {

    private int id;
    private Area area;

    public Policy(int id, Area area) {
        this.id = id;
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }


    @Override
    public String toString() {
        return "Policy{" +
                "id=" + id +
                '}';
    }
}
