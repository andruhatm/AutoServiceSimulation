package ru.netcracker;

import org.flywaydb.core.Flyway;

public class Main {
	public static void main(String[] args) {

//		У автосервиса есть гараж для машин, ограниченной вместимости,
//		куда эвакуатор доставляет автомобили различных марок для ремонта.
//		У каждого автомобиля определенное время, в течение которого его починит мастер.
//		После починки автомобиля, результат может быть записан в консоль, в xml файл или базу данных.
//		Написать приложение(консольное), эмулирующее работу такого автосервиса.
//		Входные данные: количество эвакуаторов, вместимость парковки, количество мастеров

		Flyway flyway = Flyway.configure()
						.dataSource("jdbc:postgresql://localhost:5432/autoService","postgres","кщще")
						.locations("/db.migration")
						.load();
		flyway.clean();
		flyway.migrate();

		AutoService autoService = new AutoService(Integer.parseInt(args[0]));
		TowTruckWorker truckWorker = new TowTruckWorker(autoService,Integer.parseInt(args[1]));
		MasterWorker masterWorker = new MasterWorker(autoService,Integer.parseInt(args[2]));
		new Thread(truckWorker).start();
		new Thread(masterWorker).start();


	}
}
