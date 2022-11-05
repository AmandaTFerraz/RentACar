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
            boolean[] monthAvailability = new boolean[month.getNumberOfDays()]; // creates a new boolean array and its length is from the Enum month
            Arrays.fill(monthAvailability, true);
            // puts the month and the boolean value to the availability HashMap
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
