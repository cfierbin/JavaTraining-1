/**
 * 
 */
package com.practicaljava.unit7;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class BikeOrder {

	private BikeTruck bikeTruck;

	public BikeOrder() {
		bikeTruck = new BikeTruck(10);
	}

	public void AddBikesToOrder(BikeTypes bikeType, int countBikes)
			throws TooManyBikesException {

		for (int i = 0; i < countBikes; i++) {
			int bykeSize = bikeType == BikeTypes.MadeInChina ? 1 : 3;
			Bike bike = new Bike(bikeType, bykeSize);

			if (!bikeTruck.addBike(bike))
				throw new TooManyBikesException("Dodge Ram is full!");
		}
	}

	public void clearOrder() {
		bikeTruck.clearTruck();
	}
}
