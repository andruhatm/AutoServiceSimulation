package ru.netcracker;

import entity.Car;
import java.util.ArrayDeque;
import java.util.Queue;

public class AutoService {

	private ArrayDeque<Car> parking;

	private final int parkingSize;

	public AutoService(int park) {
		this.parkingSize = park;
		parking = new ArrayDeque<>(parkingSize);
	}

	public synchronized Car repair() {
		if (parking.size()<1) {
			return null;
		}
		Car car = parking.pollFirst();
		System.out.println("Мастер взял на починку машину");
		System.out.println("Машин на парковке: " + parking.size());
		return car;
	}

	public synchronized boolean deliver(Car car) {
		if (parking.size()==parkingSize) {
			return false;
		}
		parking.addLast(car);
		System.out.println("Эвакуатор добавил машину"+ car.toString());
		System.out.println("Машин на парковке: " + parking.size());
		return true;
	}

	public int getParkingSize() {
		return parkingSize;
	}

	public Queue<Car> getParking() {
		return parking;
	}
}
