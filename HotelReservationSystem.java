import java.util.Scanner;

class Room {
    int roomNumber;
    boolean isBooked;

   
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
    }

  
    public void bookRoom() {
        if (!isBooked) {
            isBooked = true;
            System.out.println("Room " + roomNumber + " has been successfully booked.");
        } else {
            System.out.println("Sorry, Room " + roomNumber + " is already booked.");
        }
    }

   
    public void cancelBooking() {
        if (isBooked) {
            isBooked = false;
            System.out.println("Room " + roomNumber + " booking has been successfully canceled.");
        } else {
            System.out.println("Room " + roomNumber + " was not booked.");
        }
    }

    
    public boolean isAvailable() {
        return !isBooked;
    }

    
    public void displayRoomStatus() {
        System.out.println("Room " + roomNumber + " - " + (isBooked ? "Booked" : "Available"));
    }
}

public class HotelReservationSystem {
    static Room[] rooms;
    static Scanner scanner = new Scanner(System.in);

    
    public static void initializeRooms(int totalRooms) {
        rooms = new Room[totalRooms];
        for (int i = 0; i < totalRooms; i++) {
            rooms[i] = new Room(i + 1); 
        }
    }

   
    public static void showAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                room.displayRoomStatus();
            }
        }
    }

   
    public static void bookRoom() {
        showAvailableRooms();
        System.out.print("Enter the room number to book: ");
        int roomNumber = scanner.nextInt();

        if (roomNumber > 0 && roomNumber <= rooms.length) {
            rooms[roomNumber - 1].bookRoom();
        } else {
            System.out.println("Invalid room number. Please try again.");
        }
    }

   
    public static void cancelBooking() {
        System.out.print("Enter the room number to cancel the booking: ");
        int roomNumber = scanner.nextInt();

        if (roomNumber > 0 && roomNumber <= rooms.length) {
            rooms[roomNumber - 1].cancelBooking();
        } else {
            System.out.println("Invalid room number. Please try again.");
        }
    }

    
    public static void main(String[] args) {
        System.out.println("Welcome to the Hotel Reservation System");
        System.out.print("Enter the number of rooms in the hotel: ");
        int totalRooms = scanner.nextInt();
        initializeRooms(totalRooms);

        while (true) {
            System.out.println("\n1. Book a Room");
            System.out.println("2. Cancel a Booking");
            System.out.println("3. Show Available Rooms");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookRoom();
                    break;
                case 2:
                    cancelBooking();
                    break;
                case 3:
                    showAvailableRooms();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
