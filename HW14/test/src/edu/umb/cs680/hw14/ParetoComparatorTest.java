package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ParetoComparatorTest {
	
	static LinkedList<Car> usedCars = new LinkedList<Car>();
    static Car car1;
    static Car car2;
    static Car car3;
    
    @BeforeAll
    public static void setUp() {
    	Car car1 = new Car("Mercedes", "GLA", 2018, 33, 85000);
		Car car2 = new Car("Audi", "Q3", 2016, 35, 100000);
		Car car3 = new Car("BMW", "X5", 2016, 35, 90000);
		usedCars.add(car1);
		usedCars.add(car2);
		usedCars.add(car3);
    }
    
	@Test
	public void PareToCompareSortingUsingComparator() {
		Comparator<Car> compare = Comparator.comparing(Car::getDominationCount);
		
		for (Car car : usedCars) {
			car.setDominationCount(usedCars);
		}
		Collections.sort(usedCars, compare);
		assertEquals(100000, usedCars.get(0).getPrice());	
		assertEquals(90000, usedCars.get(1).getPrice());
		assertEquals(85000, usedCars.get(2).getPrice());
	}
	
	@Test
	public void ParetoCompare() {

		for (Car car : usedCars) {
			car.setDominationCount(usedCars);
		}
		Collections.sort(usedCars, (Car obj1, Car obj2) -> obj2.getDominationCount() - obj1.getDominationCount());
		assertEquals(85000, usedCars.get(0).getPrice());
		assertEquals(90000, usedCars.get(1).getPrice());
		assertEquals(100000, usedCars.get(2).getPrice());	
	}
}
