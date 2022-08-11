package ultramodern.activity.myroom;

public class DataModelClass {
    private String name;
    private String location;
    private String price;
    private String vacancy;

    public DataModelClass() {
    }

    public DataModelClass(String name, String location, String price, String vacancy) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.vacancy = vacancy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }
}
