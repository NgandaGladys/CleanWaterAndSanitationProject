import models.SanitationFacility;
import models.WaterResource;
import models.WaterSystem;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        WaterSystem system = new WaterSystem();  // Create an instance of the water and sanitation system

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the details of water resources
        System.out.println("Enter the details of water resources:");
        System.out.print("Number of water resources: ");
        int waterResourceCount = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        for (int i = 1; i <= waterResourceCount; i++) {
            System.out.println("Water resource #" + i);
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Capacity: ");
            double capacity = scanner.nextDouble();
            scanner.nextLine();  // Consume the newline character

            WaterResource waterResource = new WaterResource(name, capacity);
            system.addWaterResource(waterResource);
        }

        // Prompt the user to enter the details of sanitation facilities
        System.out.println("Enter the details of sanitation facilities:");
        System.out.print("Number of sanitation facilities: ");
        int sanitationFacilityCount = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        for (int i = 1; i <= sanitationFacilityCount; i++) {
            System.out.println("Sanitation facility #" + i);
            System.out.print("Type: ");
            String type = scanner.nextLine();
            System.out.print("Location: ");
            String location = scanner.nextLine();

            SanitationFacility facility = new SanitationFacility(type, location);
            system.addSanitationFacility(facility);
        }

        // Print the total count of water resources and sanitation facilities in the system
        System.out.println("Total water resources: " + system.getWaterResourceCount());
        System.out.println("Total sanitation facilities: " + system.getSanitationFacilityCount());

        // Close the Scanner object
        scanner.close();
    }
}