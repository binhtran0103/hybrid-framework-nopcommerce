package carFactory;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = null;
		car = getCar("Honda");
		car.viewCar();
		car.driveCar();
		car.bookCar();
	}

	public static Car getCar(String carName) {
		Car car = null;
		if (carName.equals("Honda")) {
			car = new Honda();
		} else if (carName.equals("Hyundai")) {
			car = new Hyundai();
		} else if (carName.equals("Toyota")) {
			car = new Toyota();
		} else {
			car = new Ford();
		}
		return car;

	}

}
