package ru.netcracker;

import entity.Master;
import java.util.ArrayList;

public class MasterWorker implements Runnable{

	AutoService autoService;

	private ArrayList<Master> masters;

	public MasterWorker(AutoService autoService,int mastersCount) {
		this.autoService = autoService;
		masters = new ArrayList<>(mastersCount);
		for(int i =0; i<mastersCount;i++){
			masters.add(new Master());
		}
	}

	@Override
	public void run() {
		while (true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(Master master: masters){
				if (!master.isWorking() && autoService.getParking().size()>1){
					master.setCarToRepair(autoService.repair());
					master.run();
					break;
				}
			}
		}
	}
}
