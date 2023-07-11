package models;

// Represents a sanitation facility
public  class SanitationFacility {
    private String type;
    private String location;

    public SanitationFacility(String type, String location) {
        this.type = type;
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
