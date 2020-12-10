package ru.netcracker;

import java.util.List;

public class Main {
	public static void main(String[] args) {

//		У автосервиса есть гараж для машин, ограниченной вместимости,
//		куда эвакуатор доставляет автомобили различных марок для ремонта.
//		У каждого автомобиля определенное время, в течение которого его починит мастер.
//		После починки автомобиля, результат может быть записан в консоль, в xml файл или базу данных.
//		Написать приложение(консольное), эмулирующее работу такого автосервиса.
//		Входные данные: количество эвакуаторов, вместимость парковки, количество мастеров



		AppInitializer initializer = new AppInitializer();
		List<Integer> values = initializer.getValues();
		AutoService autoService = new AutoService(values.get(0));
		CarsGenerator truckWorker = new CarsGenerator(autoService,values.get(1));
		MasterWorker masterWorker = new MasterWorker(autoService,values.get(2));
		new Thread(truckWorker).start();
		new Thread(masterWorker).start();

	}
}
