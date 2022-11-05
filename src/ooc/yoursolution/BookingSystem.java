package ooc.yoursolution;

import ooc.enums.Make;
import ooc.enums.Month;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookingSystem implements BookingSystemInterface {
    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {
        RentACar rentACar = new RentACar();

        // Create a list of cars for the rent-a-car
        List<CarInterface> carList = new ArrayList<>();
        rentACar.setCars(carList);

        // Keep a unique value for the car added to the rent-a-car
        int currentCarId = 0;

        String line;

        // Set the rent-a-car business name
        String rentACarName = in.readLine();
        rentACar.setName(rentACarName);

        // For each line in the file
        while ((line = in.readLine()) != null) {
            // Get the parameters and number of cars to add
            String[] tokens = line.trim().split(":");

            Make make = Make.valueOf(tokens[0]);
            int rate = Integer.parseInt(tokens[1]);
            int numOfCars = Integer.parseInt(tokens[2]);

            // Add the new cars to the rent-a-car
            for (int i = 0; i < numOfCars; i++) {
                Car car = createCar(currentCarId++, make, rate);
                carList.add(car);
            }
        }

        return rentACar;
    }

    private Car createCar(int id, Make make, int rate) {
        Car car = new Car();
        car.setId(id);
        car.setMake(make);
        car.setRate(rate);

        // Create the default availability for the car
        Map<Month, boolean[]> carAvailability = car.createAvailability();
        car.setAvailability(carAvailability);

        return car;
    }
}
