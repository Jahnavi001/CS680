package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class MileageComparatorTest {

	
    LinkedList<Car> carList = new LinkedList<Car>();

    @Test
	void verifyMileageComparator() {
	    Car car1 = new Car("Audi", "Q3", 2013, 33, 85000);
		Car car2 = new Car("Mercedes", "GLA", 2014, 40, 100000);
		Car car3 = new Car("Mercedes", "Sport", 2012, 30, 95000);
		carList.add(car1);
		carList.add(car2);
		carList.add(car3);
		Collections.sort(carList,new MileageComparator());
		assertEquals(car2, carList.get(0));
		assertEquals(car1, carList.get(1));
		assertEquals(car3, carList.get(2));
		
	}
}