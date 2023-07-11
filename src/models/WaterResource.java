package models;

// Represents a water resource
public class WaterResource {
    private String name;
    private double capacity;

    public WaterResource(String name, double capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
}

