package entity;

import enums.BrandEnum;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Car {

//	private String number;
	private final BrandEnum brand;
//	private String ownerPhone;
	private final Color color;
	private final int repairTime;
	private final int transportTime;

	public Car() {
		this.repairTime = ThreadLocalRandom.current().nextInt(2,5);
		this.transportTime = ThreadLocalRandom.current().nextInt(2,4);
		this.brand = BrandEnum.values()[ThreadLocalRandom.current().nextInt(1,4)];
		this.color = new Color(
						ThreadLocalRandom.current().nextInt(255),
						ThreadLocalRandom.current().nextInt(255),
						ThreadLocalRandom.current().nextInt(255)
		);
	}

	public BrandEnum getBrand() {
		return brand;
	}

	public Color getColor() {
		return color;
	}

	public int getRepairTime() {
		return repairTime;
	}

	public int getTransportTime() {
		return transportTime;
	}

	@Override
	public String toString() {
		return "Car{" +
						"brand=" + brand +
						", color=" + color +
						", repairTime=" + repairTime +
						", transportTime=" + transportTime +
						'}';
	}
}
