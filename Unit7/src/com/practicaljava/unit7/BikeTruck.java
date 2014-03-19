/**
 * 
 */
package com.practicaljava.unit7;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class BikeTruck {

	private int maxCapacity;
	private int currentCapacity;

	public BikeTruck(int capacity) {
		maxCapacity = capacity;
		currentCapacity = maxCapacity;

	}

	public boolean addBike(Bike bike) {
		currentCapacity = currentCapacity - bike.bikeSize;
		return currentCapacity >= 0;
	}

	public void clearTruck() {
		currentCapacity = maxCapacity;
	}

}
