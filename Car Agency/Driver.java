
public class Driver {

	public static void main(String[] args) {

		Car[] cars = new Car[5];

		cars[0] = new Car("3461-f", 2014, 12, "white", 55000.0, "jeep", 2018, 12);
		cars[1] = new Car("3462-t", 2019, 1, "red", 100000.0, "rangrover", 2025, 7);
		cars[2] = new Car("3262-a", 2000, 5, "green", 48000.0, "tyota", 2006, 11);
		cars[3] = new Car("33462-v", 2020, 1, "black", 120000.0, "rangrover", 2029, 7);
		cars[4] = new Car("35672-z", 2012, 6, "pink", 50000.0, "ford", 2016, 12);

		System.out.println("here are the cars informations:" + "\n");
		printCarsInfo(cars);

		Car maxcar = maxPrice(cars);
		System.out.println("here are the car with the highest price informations :" + "\n" + maxcar.printCarInfo());
		System.out.println("car age = " + maxcar.getCarAge());
		System.out.println("remaning time for guarantee = " + maxcar.getCalculateGuarantee() + ".");
	}

	public static void printCarsInfo(Car[] cars) {
		String s = "";
		for (int i = 0; i < cars.length; i++) {
			s += "Car " + (i + 1) + " informations:" + "\n";
			s += cars[i].printCarInfo();
			s += "\n";
			s += " car age = " + cars[i].getCarAge() + ", ";
			s += "remaning time for guarantee = " + cars[i].getCalculateGuarantee() + ".";
			s += "\n" + "\n";
		} // \n is just to arrange the form
		System.out.println(s);

	}

	public static Car maxPrice(Car[] cars) {
		Car maxcar = new Car(cars[0]); // here i used the new constructor that i created to copy one object to another
		for (int i = 0; i < cars.length - 1; i++) {
			if (cars[i].getPrice() < cars[i + 1].getPrice())
				maxcar = new Car(cars[i + 1]); // here i used the new constructor that i created to copy one object to
												// another // another
		}
		return maxcar;
	}

}
