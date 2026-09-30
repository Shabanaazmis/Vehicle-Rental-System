import java.util.ArrayList;
import java.util.Scanner;

// Vehicle class
class Vehicle {
    private int vehicleId;
    private String vehicleName;
    private String vehicleType;
    private double pricePerDay;
    private boolean available;

    // Constructor
    public Vehicle(int vehicleId, String vehicleName,
                   String vehicleType, double pricePerDay) {

        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.vehicleType = vehicleType;
        this.pricePerDay = pricePerDay;
        this.available = true;
    }

    // Getter methods
    public int getVehicleId() {
        return vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    // Rent vehicle
    public void rentVehicle() {
        available = false;
    }

    // Return vehicle
    public void returnVehicle() {
        available = true;
    }

    // Display vehicle details
    public void displayVehicle() {
        System.out.println(
            vehicleId + "\t" +
            vehicleName + "\t" +
            vehicleType + "\t" +
            pricePerDay + "\t\t" +
            (available ? "Available" : "Rented")
        );
    }
}


// Main class
public class VehicleRentalSystem {

    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add vehicles
    public static void addVehicles() {

        vehicles.add(new Vehicle(101, "Swift", "Car", 1500));
        vehicles.add(new Vehicle(102, "Honda City", "Car", 2000));
        vehicles.add(new Vehicle(103, "Royal Enfield", "Bike", 800));
        vehicles.add(new Vehicle(104, "Activa", "Scooter", 500));
        vehicles.add(new Vehicle(105, "KTM Duke", "Bike", 1000));
    }


    // Display all vehicles
    public static void displayVehicles() {

        System.out.println("\n--------------- VEHICLE LIST ---------------");

        System.out.println(
            "ID\tName\t\tType\tPrice/Day\tStatus"
        );

        System.out.println("---------------------------------------------");

        for (Vehicle v : vehicles) {
            v.displayVehicle();
        }
    }


    // Rent vehicle
    public static void rentVehicle() {

        System.out.print("\nEnter Vehicle ID to rent: ");
        int id = sc.nextInt();

        Vehicle selectedVehicle = null;

        for (Vehicle v : vehicles) {

            if (v.getVehicleId() == id) {
                selectedVehicle = v;
                break;
            }
        }

        if (selectedVehicle == null) {

            System.out.println("Vehicle not found.");

        } else if (!selectedVehicle.isAvailable()) {

            System.out.println("Sorry! Vehicle is already rented.");

        } else {

            System.out.print("Enter number of rental days: ");
            int days = sc.nextInt();

            double totalAmount =
                    selectedVehicle.getPricePerDay() * days;

            selectedVehicle.rentVehicle();

            System.out.println("\nVehicle rented successfully!");
            System.out.println("Vehicle Name : "
                    + selectedVehicle.getVehicleName());
            System.out.println("Rental Days  : " + days);
            System.out.println("Price/Day    : ₹"
                    + selectedVehicle.getPricePerDay());
            System.out.println("Total Amount : ₹"
                    + totalAmount);
        }
    }


    // Return vehicle
    public static void returnVehicle() {

        System.out.print("\nEnter Vehicle ID to return: ");
        int id = sc.nextInt();

        Vehicle selectedVehicle = null;

        for (Vehicle v : vehicles) {

            if (v.getVehicleId() == id) {
                selectedVehicle = v;
                break;
            }
        }

        if (selectedVehicle == null) {

            System.out.println("Vehicle not found.");

        } else if (selectedVehicle.isAvailable()) {

            System.out.println("This vehicle is not currently rented.");

        } else {

            selectedVehicle.returnVehicle();

            System.out.println(
                "Vehicle returned successfully!"
            );
        }
    }


    // Main method
    public static void main(String[] args) {

        addVehicles();

        int choice;

        do {

            System.out.println("\n====================================");
            System.out.println("       VEHICLE RENTAL SYSTEM");
            System.out.println("====================================");

            System.out.println("1. Display All Vehicles");
            System.out.println("2. Rent Vehicle");
            System.out.println("3. Return Vehicle");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    displayVehicles();
                    break;

                case 2:
                    rentVehicle();
                    break;

                case 3:
                    returnVehicle();
                    break;

                case 4:
                    System.out.println(
                        "Thank you for using Vehicle Rental System!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice. Please try again."
                    );
            }

        } while (choice != 4);

        sc.close();
    }
}