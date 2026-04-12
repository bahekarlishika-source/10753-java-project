interface Service {
    double calculateBill(int days, double  roomRate);
}
class Room {
    int roomNumber;
    boolean isAvailable;
    double pricePerDay;

    // Constructor
    Room(int roomNumber, double pricePerDay) {
        this.roomNumber = roomNumber;
        this.pricePerDay = pricePerDay;
        this.isAvailable = true; // initially available
    }

    // Book room
    void bookRoom() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Room " + roomNumber + " booked successfully.");
        } else {
            System.out.println("Room " + roomNumber + " is already booked.");
        }
    }

    // Vacate room
    void vacateRoom() {
        isAvailable = true;
        System.out.println("Room " + roomNumber + " is now available.");
    }

    // Display room status
    void displayRoom() {
        System.out.println("Room No: " + roomNumber +
                ", Price: " + pricePerDay +
                ", Available: " + isAvailable);
    }
}
class Hotel implements Service {
    Room[][] rooms;

    // Constructor to create 2D layout
    Hotel(int floors, int roomsPerFloor) {
        rooms = new Room[floors][roomsPerFloor];
        int roomNo = 101;

        for (int i = 0; i < floors; i++) {
            for (int j = 0; j < roomsPerFloor; j++) {
                rooms[i][j] = new Room(roomNo++, 2000); // fixed price
            }
        }
    }

    // Display all rooms
    void displayAllRooms() {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                rooms[i][j].displayRoom();
            }
        }
    }

    // Book a specific room
    void bookRoom(int roomNumber) {
        for (Room[] floor : rooms) {
            for (Room r : floor) {
                if (r.roomNumber == roomNumber) {
                    r.bookRoom();
                    return;
                }
            }
        }
        System.out.println("Room not found!");
    }

    // Calculate total bill (Interface Method)
    public double calculateBill(int days, double roomRate) {
        return days * roomRate;
    }
}
    

