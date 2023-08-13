package carWithoutFactory;

public class User {

	public static void main(String[] args) {
		Honda hon = new Honda();
		hon.viewCar();
		hon.driveCar();

		Hyundai hyun = new Hyundai();
		hyun.viewCar();
		hyun.driveCar();

		Toyota toy = new Toyota();
		toy.viewCar();
		toy.driveCar();

		Ford ford = new Ford();
		ford.viewCar();
		ford.driveCar();

	}

}
