package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Represents a water resource
public class WaterResource {
    private String name;
    private double capacity;
    private  String resource_location;

    private boolean Is_clean;



    private static HashMap<String, Double> waterSourceRatings =new HashMap<String, Double>();

    //class constructor
    public WaterResource(String resource_location, double capacity, boolean Is_clean) {
        this.capacity = capacity;
        this.resource_location=resource_location;
        this.Is_clean=Is_clean;

    }
    //getters and setters for the attributes

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

    public String getResource_location() {
        return resource_location;
    }
    public boolean isIs_clean() {
        return Is_clean;
    }

    public static HashMap<String, Double> getWaterSourceRatings() {
        return waterSourceRatings;
    }
    //function to add the facility ratings to a collection
    public  static void addSourceRatings(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your Water Source(Tap,well,lake,river,pond,borehole,hardwater): ");
        String source_name = in.nextLine();
        System.out.println("On a scale of 1-10,10 being the best rate the above WaterSource: ");
        double ratings =in.nextDouble();
        waterSourceRatings.put(source_name,ratings);

    }
}

