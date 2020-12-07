package ru.netcracker;

import entity.Master;
import entity.TowTruck;

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
			for(int i =0; i<masters.size();i++){
				if (!masters.get(i).isWorking() && autoService.getParking().size()>1){
					masters.set(i,new Master());
					masters.get(i).setCarToRepair(autoService.repair());
					masters.get(i).start();
					break;
				}
			}
		}
	}
}
