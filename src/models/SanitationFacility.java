package models;

import java.util.HashMap;
import java.util.Scanner;

// Represents a sanitation facility
public  class SanitationFacility {
    //facility attributes
    private String type;
    private String location;

    private boolean is_clean;
    private static HashMap<String, Double>facility_ratings =new HashMap<String, Double>();

//class constructor
    public SanitationFacility(String type, String location,boolean is_clean) {
        this.type = type;
        this.location = location;
        this.is_clean = is_clean;
    }
//getters and setters
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

    public boolean isIs_clean() {
        return is_clean;
    }

    public static HashMap<String, Double> getFacility_ratings() {
        return facility_ratings;
    }
    //function to add the facility ratings to a collection
    public  static void addFacilityRatings(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of the facility(Toilet,Drainage,WaterSystem,Other: ");
        String facility_name = in.nextLine();
        System.out.println("On a scale of 1-10,10 being the best rate the above facility: ");
        double ratings =in.nextDouble();
        facility_ratings.put(facility_name,ratings);
//        for (String name:facility_ratings.keySet()
//        ) {
//            System.out.println("Water Source: "+ name +" "+  "Rating(1-10): " + facility_ratings.get(name));
//        }

    }
}
