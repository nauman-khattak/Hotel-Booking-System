package BookingSystem;

import java.util.Date;
import java.util.Random;

public class Ticket {

    private Person person;
    private int roomNr;
    private String id;
    private String date;

    public Ticket(Person p, int roomNr) {
        if(roomNr == -1){
            System.out.println("No room available");
        }
        this.person = p;
        this.roomNr = roomNr;
        date = new Date().toString();
        Random ran = new Random();
        id = person.getName().concat(String.valueOf(ran.nextInt(1000)));
        
    }

    @Override
    public String toString() {
        return "{ person = " + person.getName() + ","
                + " age = " +person.getAge() + ","
                + " roomNr = " + roomNr + ","
                + " id = " + id + ","
                + " check in date = " + date + '}';
    }
    

    public String getUniqueId() {
        return id;
    }

    public int getRoomNr() {
        return roomNr;
    }
    
    
    
}
