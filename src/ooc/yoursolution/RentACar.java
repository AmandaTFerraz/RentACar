package ooc.yoursolution;

import ooc.enums.Make;
import ooc.enums.Month;

import java.util.List;

public class RentACar implements RentACarInterface {
    @Override
    public List<CarInterface> getCars() {
        return null;
    }

    @Override
    public void setCars(List<CarInterface> cars) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent) {
        return false;
    }

    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {
        return 0;
    }

    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
        return false;
    }

    @Override
    public int getNumberOfCars() {
        return 0;
    }
}
