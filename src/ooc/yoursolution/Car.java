package ooc.yoursolution;

import ooc.enums.Make;
import ooc.enums.Month;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Car implements CarInterface {
    private int id;
    private Make make;
    private double rate;
    private Map<Month, boolean[]> availability;

    @Override
    public Map<Month, boolean[]> createAvailability() {
        HashMap<Month, boolean[]> availability = new HashMap<>();

        for (Month month: Month.values()) {
            // We set the default availability to true for each month, considering that all the cars are initially
            // available until it is booked and then puts the month and the boolean value to the availability HashMap
            boolean[] monthAvailability = new boolean[month.getNumberOfDays()];
            Arrays.fill(monthAvailability, true);

            availability.put(month, monthAvailability);
        }

        return availability;
    }

    @Override
    public Make getMake() {
        return make;
    }

    @Override
    public void setMake(Make make) {
        this.make = make;
    }

    @Override
    public double getRate() {
        return this.rate;
    }

    @Override
    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public Map<Month, boolean[]> getAvailability() {
        return availability;
    }

    @Override
    public void setAvailability(Map<Month, boolean[]> availability) {
        this.availability = availability;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean isAvailable(Month month, int day) {
        boolean[] monthAvailability = availability.get(month);
        return monthAvailability[day];
    }

    @Override
    public boolean book(Month month, int day) {
        if (!isAvailable(month, day)) {
            return false;
        }

        boolean[] monthAvailability = availability.get(month);
        monthAvailability[day] = false;

        return true;
    }
}
