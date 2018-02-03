package ui;

import BookingSystem.Hotel;
import BookingSystem.Person;
import java.util.Scanner;

public class UI {

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner s = new Scanner(System.in);
        String choice;
        System.out.println("*************************************\n"
                + "*  Welcome to Hotel Booking System  *\n"
                + "*************************************");

        while (true) {

            System.out.print("\n**********Choose an Option***********\n"
                    + "* 1) View vacant rooms\t\t    *\n"
                    + "* 2) View checked in people\t    *\n"
                    + "* 3) Add new person (check in)\t    *\n"
                    + "* 4) Remove people (check out)\t    *\n"
                    + "* 5) Exit\t\t\t    *\n"
                    + "*************************************\n\n>> ");
            choice = s.nextLine();
//            s.nextLine(); //nextInt() command only reads the int value. So when compiler continue reading with input.nextInt() it receives the "\n" newline, when we press enter. So to consume that newline we have to add input.nextLine()
            if (choice.matches("[1-5]$")) {

                switch (Integer.valueOf(choice)) {

                    case 1: {
                        hotel.printVacantRooms();
                        break;
                    }

                    case 2: {
                        hotel.printCheckedinPersons();
                        break;
                    }

                    case 3: {
                        int temp = hotel.getVacantRoom(); //temporary variable to store the vary first availabe room
                        if (temp == -1) {
                            System.out.println("Sorry! No available rooms");
                            return;
                        }
                        System.out.print("Enter person name : ");
                        String name = s.nextLine();
                        System.out.print("Enter " + name + "'s age : ");
                        String ageTemp = s.nextLine();
                        int age;
                        try {
                            age = Integer.parseInt(ageTemp);
                            hotel.roomIndex = temp;
                            Person p = new Person(name, age);
                            hotel.checkIn(p);
                        } catch (NumberFormatException e) {
                            System.out.println("Plz enter valid age");
                        }

                        break;
                    }

                    case 4: {
                        System.out.println("Enter Unique id of particular person : ");
                        String temp = s.nextLine();
                        hotel.checkOut(temp);
                        break;
                    }

                    case 5: {
                        System.exit(0);
                        break;
                    }
                }
            } else {
                System.out.println("Plz Enter choice between 1-5");

            }
        }
    }
}
