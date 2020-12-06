package entity;

import ru.netcracker.AutoService;

public class TowTruck extends Thread{

	private Car car;

	private final AutoService autoService;

	private boolean working = false;

	public TowTruck(AutoService autoService) {
		this.autoService = autoService;
	}

	@Override
	public void run() {
		working = true;
		try {
			Thread.sleep(car.getTransportTime()*1000);
			while (!autoService.deliver(this.car)){
				autoService.deliver(this.car);
			}
			Thread.currentThread().interrupt();
			working = false;
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}

	public boolean isWorking() {
		return working;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
