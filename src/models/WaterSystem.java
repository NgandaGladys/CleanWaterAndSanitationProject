package models;

import java.util.ArrayList;
import java.util.*;

public class WaterSystem {

    private static ArrayList<WaterResource> waterResources = new ArrayList<WaterResource>(); ;
    private  static ArrayList<SanitationFacility> sanitationFacilities = new ArrayList<SanitationFacility>();

//    public WaterSystem() {
//        waterResources =  // Initialize the list of water resources
//        sanitationFacilities = new ArrayList<>();  // Initialize the list of sanitation facilities
//    }

    // Add a water resource to the system
    public static void addWaterResource(WaterResource resource) {
        waterResources.add(resource);
    }

    // Add a sanitation facility to the system
    public static void addSanitationFacility(SanitationFacility facility) {
        sanitationFacilities.add(facility);
    }

    // Get the total number of water resources in the system
    public int getWaterResourceCount() {

        return waterResources.size();
    }

    // Get the total number of sanitation facilities in the system
    public int getSanitationFacilityCount() {

        return sanitationFacilities.size();
    }

    public static ArrayList<WaterResource> getWaterResources() {
        return waterResources;
    }

    public static ArrayList<SanitationFacility> getSanitationFacilities() {
        return sanitationFacilities;
    }
}



