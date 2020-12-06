package entity;

public class Master extends Thread{

	private Car carToRepair;

	private boolean working = false;

	public Master() {
	}

	@Override
	public void run() {
		working = true;
		try {
			Thread.sleep(carToRepair.getRepairTime()*1000);
			logRepairedCar();
			working = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void logRepairedCar(){
		System.out.println(carToRepair.toString());
	}

	public boolean isWorking() {
		return working;
	}

	public void setCarToRepair(Car carToRepair) {
		this.carToRepair = carToRepair;
	}
}
