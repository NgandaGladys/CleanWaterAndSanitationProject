package models;

import java.util.ArrayList;
import java.util.List;

public class WaterSystem {

    private List<WaterResource> waterResources;
    private List<SanitationFacility> sanitationFacilities;

    public WaterSystem() {
        waterResources = new ArrayList<>();  // Initialize the list of water resources
        sanitationFacilities = new ArrayList<>();  // Initialize the list of sanitation facilities
    }

    // Add a water resource to the system
    public void addWaterResource(WaterResource resource) {
        waterResources.add(resource);
    }

    // Add a sanitation facility to the system
    public void addSanitationFacility(SanitationFacility facility) {
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
}



