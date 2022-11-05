package ooc.yoursolution;

import ooc.enums.Make;
import ooc.enums.Month;

import java.util.List;

public class RentACar implements RentACarInterface {

    private String name;
    private List<CarInterface> cars;

    @Override
    public List<CarInterface> getCars() {
        return cars;
    }

    @Override
    public void setCars(List<CarInterface> cars) {
        this.cars = cars;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent) {
        return getCarAvailable(month, day, make, lengthOfRent) != -1;
    }

    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {

        // For each car in the rent-a-car with the make specified
        //   Checks if the car is available in the month and in the day specified,
        //     and if it's available from the date for the number of days specified in order to return the car id
        //      returns -1 in case there is no car to book considering the specifications

        if (day + lengthOfRent > month.getNumberOfDays()) {
            throw new IllegalArgumentException("The length of the rent is invalid");
        }

        for (CarInterface car : cars) {
            if (car.getMake() == make) {
                boolean isAvailable = true;

                for (int i = 0; i < lengthOfRent; i++) {
                    if (!car.isAvailable(month, day + i)) {
                        isAvailable = false;
                        break;
                    }
                }

                if (isAvailable) {
                    return car.getId();
                }
            }
        }

        return -1;
    }

    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
        if (!checkAvailability(month, day, make, lengthOfRent)) {
            return false;
        }

        int availableCarId = getCarAvailable(month, day, make, lengthOfRent);

        // get the car object with the car ID
        //  call the method book() of the Car object for each day specified

        Car availableCar = null;

        for (CarInterface car : cars) {
            if (car.getId() == availableCarId) {
                availableCar = (Car) car;
                break;
            }
        }

        for (int i = 0; i < lengthOfRent; i++) {
            availableCar.book(month, day + i);
        }

        return true;
    }

    @Override
    public int getNumberOfCars() {
        return cars.size();
    }
}
