package ru.netcracker;

import entity.Car;
import entity.TowTruck;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TowTruckWorker implements Runnable{

	private AutoService autoService;

	private ArrayDeque<Car> carsToDeliver;

	private ArrayList<TowTruck> towTrucks;

	public TowTruckWorker(AutoService autoService,int towTrucksCount) {
		this.autoService = autoService;
		towTrucks = new ArrayList<>(towTrucksCount);
		carsToDeliver = new ArrayDeque<>();
		for(int i =0; i<towTrucksCount;i++){
			towTrucks.add(new TowTruck(this.autoService));
		}
	}

	@Override
	public void run() {
		while (true){
			try {
				Thread.sleep(ThreadLocalRandom.current().nextInt(1,3)*1000);
				Car car = new Car();
				carsToDeliver.add(car);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int i=0;i<towTrucks.size();i++){
				if (!towTrucks.get(i).isWorking()){
					towTrucks.set(i, new TowTruck(autoService));
					towTrucks.get(i).setCar(carsToDeliver.pollFirst());
					towTrucks.get(i).start();
					break;
				}
			}

		}
	}

}
