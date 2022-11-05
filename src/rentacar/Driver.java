/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar;

// This line will give you an error until you create the needed class.
import ooc.yoursolution.BookingSystem;

import ooc.yoursolution.BookingSystemInterface;
import ooc.yoursolution.Car;
import ooc.yoursolution.RentACarInterface;
import ooc.enums.Make;
import ooc.enums.Month;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

// https://github.com/AmandaTFerraz/RentACar


// Amanda de Toledo Ferraz 2021256
// Laysa Karolliny Dias de Souza 2021295
public class Driver {

    /**
     * Do not change the signature of the main method!
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO: REMOVE
        System.out.println("TEST");

        Car car = new Car();
        Map<Month, boolean[]> availability = car.createAvailability();
        car.setAvailability(availability);

        boolean result;
        result = car.book(Month.JANUARY, 22);
        System.out.println(result);
        result = car.book(Month.JANUARY, 22);
        System.out.println(result);


        BookingSystemInterface bookingSystem = new BookingSystem();

        String file = "car_rentals.txt";
        BufferedReader in = new BufferedReader(new FileReader(file));

        RentACarInterface rentACar = bookingSystem.setupRentACar(in);

        // Get the name of the car rental
        System.out.println(rentACar.getName());
        
        // Print the number of cars in the rent-a-car
        System.out.println(rentACar.getNumberOfCars());  
        
        // Check if there is a BMW car available for 5 days from the 1st
        // of January
        System.out.println(rentACar.checkAvailability(Month.JANUARY, 1, Make.BMW, 5)); 
        
        // Get the id of the car available
        System.out.println(rentACar.getCarAvailable(Month.JANUARY, 1, Make.BMW, 5));
        
        // Try some bookings
        System.out.println(rentACar.bookCar(Month.JANUARY, 1, Make.BMW, 5));
        System.out.println(rentACar.bookCar(Month.JANUARY, 1, Make.BMW, 5));
        System.out.println(rentACar.bookCar(Month.JANUARY, 1, Make.BMW, 5));
        System.out.println(rentACar.bookCar(Month.JANUARY, 1, Make.BMW, 5));
        System.out.println(rentACar.bookCar(Month.FEBRUARY, 3, Make.FIAT, 10));
        System.out.println(rentACar.bookCar(Month.MARCH, 10, Make.FORD, 12));
        
    }

}
