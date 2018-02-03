package BookingSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {

    Scanner s = new Scanner(System.in);
    private final int totalRooms = 15;//total number of rooms in hotel. It can be get from user at runtime but i preferred it that way
    String[] RoomCurrentStatus; //String array for storing state of every room, if someone check in then his room status will be updated to "occupied". if checked out then it will be updated to "vacant"
    private ArrayList<Ticket> bookingList; // //Arraylist for storing all instances of Tickets, or simply all occupied rooms
    public int roomIndex;

    public Hotel() {
        bookingList = new ArrayList<>(); 
        RoomCurrentStatus = new String[totalRooms]; //Status of every room. It may be "vacant" or "occupied" but not both at the same time
        for (int i = 0; i <= RoomCurrentStatus.length - 1; i++) {
            RoomCurrentStatus[i] = "vacant"; //initially all rooms will be vacnat
        }
    }

    public void checkIn(Person p) {

        Ticket ticket = new Ticket(p, getVacantRoom());
        bookingList.add(ticket);
        RoomCurrentStatus[roomIndex] = "occupied";

    }

    public void checkOut(String id) {
        for (Ticket i : bookingList) {
            if (i.getUniqueId().equals(id)) {
                int index = bookingList.indexOf(i); //used for storing index of that person in bookingList
                int roomNo = i.getRoomNr();
                RoomCurrentStatus[roomNo] = "vacant";
                bookingList.remove(index);
                System.out.println("Checked out successfully\nRoom No "+roomNo+" is emptied");
                return;
            }
        }
        System.out.println(id+" doesn't match any existing unique id's");
    }

    public void printCheckedinPersons() {
        if (bookingList.isEmpty()) {
            System.out.println("No one checked in yet");
            return;
        }
        for (Ticket i : bookingList) {
            System.out.println(i.toString());
        }
    }

    @Override
    public String toString() {
        return "Hotel{" + "bookingList=" + bookingList + '}';
    }

    public void printVacantRooms() {
        System.out.print("Vacant Rooms: ");
        for (int i = 0; i <= RoomCurrentStatus.length - 1; i++) {
            if (RoomCurrentStatus[i].equalsIgnoreCase("vacant")) {
                if (i == RoomCurrentStatus.length - 1) {
                    System.out.print(i+"\n");//there wont be comma after last entry
                } else {
                    System.out.print(i + ", ");//comma between every room number
                }
            }
        }
    }

    public int getVacantRoom() {
        for (int i = 0; i <= RoomCurrentStatus.length - 1; i++) {
            if (RoomCurrentStatus[i].equalsIgnoreCase("vacant")) {
                return i;
            }
        }
        return -1;
    }
}