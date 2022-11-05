/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar;
import ooc.yoursolution.*;
import ooc.enums.Make;
import ooc.enums.Month;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

        /*Car car1 = new Car();
        car1.setId(1);
        car1.setMake(Make.BMW);
        car1.setRate(100);
        Map<Month, boolean[]> car1Availability = car1.createAvailability();
        car1.setAvailability(car1Availability);

        Car car2 = new Car();
        car2.setId(2);
        car2.setMake(Make.TOYOTA);
        car2.setRate(50);
        Map<Month, boolean[]> car2Availability = car2.createAvailability();
        car2.setAvailability(car2Availability);
        car2.book(Month.AUGUST, 15);

        Car car3 = new Car();
        car3.setId(3);
        car3.setMake(Make.TOYOTA);
        car3.setRate(70);
        Map<Month, boolean[]> car3Availability = car3.createAvailability();
        car3.setAvailability(car3Availability);


        List<CarInterface> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        RentACar rentACar = new RentACar();
        rentACar.setName("PowerPuff Girls");
        rentACar.setCars(carList);

        int carId = rentACar.getCarAvailable(Month.AUGUST, 14, Make.TOYOTA, 3);
        System.out.println("Car ID:" + carId);

        System.out.println("Number of cars: " + rentACar.getCars().size());

        System.out.println("====== END ======");
*/


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
