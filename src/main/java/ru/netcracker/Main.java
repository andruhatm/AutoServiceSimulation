package ru.netcracker;

public class Main {
	public static void main(String[] args) {

		AutoService autoService = new AutoService(20);
		TowTruckWorker truckWorker = new TowTruckWorker(autoService,3);
		MasterWorker masterWorker = new MasterWorker(autoService,3);
		new Thread(truckWorker).start();
		new Thread(masterWorker).start();

//		У автосервиса есть гараж для машин, ограниченной вместимости,
//		куда эвакуатор доставляет автомобили различных марок для ремонта.
//		У каждого автомобиля определенное время, в течение которого его починит мастер.
//		После починки автомобиля, результат может быть записан в консоль, в xml файл или базу данных.
//		Написать приложение(консольное), эмулирующее работу такого автосервиса.
//		Входные данные: количество эвакуаторов, вместимость парковки, количество мастеров
	}
}
