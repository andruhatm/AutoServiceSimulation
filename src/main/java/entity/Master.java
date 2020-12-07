package entity;

import db.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			Connection connection = Connect.connect();
			PreparedStatement statement = connection.prepareStatement("INSERT INTO \"repaired_cars\"(\"brand\",\"color\",\"repairtime\",\"delivertime\") VALUES (?,?,?,?);");
			statement.setString(1,this.carToRepair.getBrand().name());
			statement.setString(2,this.carToRepair.getColor().toString());
			statement.setInt(3,this.carToRepair.getRepairTime());
			statement.setInt(4,this.carToRepair.getTransportTime());
			statement.execute();
			working = false;
		} catch (InterruptedException | SQLException e) {
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
