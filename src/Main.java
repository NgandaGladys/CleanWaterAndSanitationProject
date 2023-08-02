import models.SanitationFacility;
import models.User;
import models.WaterResource;
import models.WaterSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    private static ArrayList<User> users = new ArrayList<>();
    private static User currentUser = null;
    public static void main(String[] args) {
        //User Authentication

        WaterSystem system = new WaterSystem();  // Create an instance of the water and sanitation system

        // Create a Scanner object for user input
        Scanner scanners = new Scanner(System.in);

        // Add some sample users (this is just for demonstration purposes; in a real application,we will use a database)
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));
        users.add(new User("user3", "password3"));
        users.add(new User("user4", "password4"));



        boolean isLoggedIn = false;

        // Login loop
        while (!isLoggedIn) {
            System.out.println("Choose an option:");
            System.out.println("1. Log in");
            System.out.println("2. Sign up");
            System.out.print("Your choice: ");
            int choice = scanners.nextInt();
            scanners.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Please log in:");
                    System.out.print("Username: ");
                    String username = scanners.nextLine();
                    System.out.print("Password: ");
                    String password = scanners.nextLine();

                    isLoggedIn = login(username, password);
                    if (!isLoggedIn) {
                        System.out.println("Invalid credentials. Please try again.");
                    }
                    break;

                case 2:
                    signUp();
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        // Rest of your existing code goes here...

        // Implement logout functionality
        if (currentUser != null) {
            System.out.println("Choose an option:");
            System.out.println("1. Log out");
            System.out.println("2. Exit");
            System.out.print("Your choice: ");
            int logoutChoice = scanners.nextInt();
            scanners.nextLine(); // Consume the newline character

            if (logoutChoice == 1) {
                logout();
            } else {
                System.out.println("Exiting the program.");
            }
        } else {
            System.out.println("You are not logged in. Exiting the program.");
        }

        // Close the Scanner object
        scanners.close();
    }

    // Login function
    private static boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Login successful. Welcome, " + currentUser.getUsername() + "!");
                return true;
            }
        }
        return false;
    }

    // Logout function
    private static void logout() {
        if (currentUser != null) {
            System.out.println("Logging out. Goodbye, " + currentUser.getUsername() + "!");
            currentUser = null;
        } else {
            System.out.println("You are not logged in.");
        }
    }

    // Sign-up function
    private static void signUp() {
        Scanner scanne_r = new Scanner(System.in);
        System.out.print("Enter a new username: ");
        String newUsername = scanne_r.nextLine();
        System.out.print("Enter a new password: ");
        String newPassword = scanne_r.nextLine();

        // Check if the username already exists
        for (User user : users) {
            if (user.getUsername().equals(newUsername)) {
                System.out.println("Username already exists. Please choose a different username.");
                return;
            }
        }

        users.add(new User(newUsername, newPassword));
        System.out.println("Sign-up successful. You can now log in with your new account.");


        // Create an instance of the water and sanitation system
        WaterSystem system = new WaterSystem();

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the details of water resources
        System.out.println("Enter the details of water resources:");
        System.out.print("Number of water resources: ");
        int waterResourceCount = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        for (int i = 1; i <= waterResourceCount; i++) {
            System.out.println("Water resource #" + i);
            System.out.println("Location: ");
            String resource_location = scanner.nextLine();
            System.out.print("Capacity: ");
            double capacity = scanner.nextDouble();
            scanner.nextLine();  // Consume the newline character
            System.out.println("Write true if the water is clean and false if not: ");
            boolean Is_clean = scanner.nextBoolean();
            WaterResource.addSourceRatings();




            WaterResource waterResource = new WaterResource(resource_location, capacity,Is_clean);
            system.addWaterResource(waterResource);
        }

        // Prompt the user to enter the details of sanitation facilities
        System.out.println("Enter the details of sanitation facilities:");
        System.out.print("Number of sanitation facilities: ");
        int sanitationFacilityCount = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        for (int i = 1; i <= sanitationFacilityCount; i++) {
            System.out.println("Sanitation facility #" + i);
            System.out.print("Type(flush toilet, piped sewer system, septic tank, flush/pour flush to pit latrine, ventilated improved pit latrine (VIP), pit latrine with slab, composting toilet.): ");
            String type = scanner.nextLine();
            System.out.print("Location: ");
            String location = scanner.nextLine();
            System.out.println("Enter true if clean and false if not");
            boolean is_clean = scanner.nextBoolean();

            SanitationFacility.addFacilityRatings();

            System.out.println();


            SanitationFacility facility = new SanitationFacility(type, location,is_clean);
            system.addSanitationFacility(facility);
        }

        // Print the total count of water resources and sanitation facilities in the system
        System.out.println("Total water resources: " + system.getWaterResourceCount());
        System.out.println("Total sanitation facilities: " + system.getSanitationFacilityCount());

        // Close the Scanner object
        scanner.close();
        ArrayList<WaterResource>waterResources=WaterSystem.getWaterResources();
        for (WaterResource resource:waterResources
             ) {
            System.out.println("Water Resources");
            System.out.println("Location: " + resource.getResource_location() +"\n Capacity: "+ resource.getCapacity());
        }
        HashMap<String, Double> waterSourceRatings = WaterResource.getWaterSourceRatings();
        System.out.println(waterSourceRatings);
        ArrayList<SanitationFacility>sanitationFacilities=WaterSystem.getSanitationFacilities();
        for (SanitationFacility facility:sanitationFacilities
        ) {
            System.out.println("Sanitation Facilities");
            System.out.println("Facility Type: "+ facility.getType() + "\n Location: " + facility.getLocation() +"\nIs_Clean: "+facility.isIs_clean());
        }

        HashMap<String, Double>facility_ratings =SanitationFacility.getFacility_ratings();
//        System.out.println(facility_ratings);
    }
}