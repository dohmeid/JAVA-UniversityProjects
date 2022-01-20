import java.util.Date;

public class Car {

	private String PlateNo;
	private int yearmanufacture;
	private int monthmanufacture;
	private String color;
	private double price;
	private String manufactureby;
	private int guaranteedueyear;
	private int guaranteeduemonth;

	public static Date date = new Date();

	public Car() {
		PlateNo = "0123-A";
		yearmanufacture = date.getYear() + 1900;
		monthmanufacture = date.getMonth() + 1;
		color = "red";
		price = 50000.00;
		manufactureby = "Mercedes";
		guaranteedueyear = yearmanufacture;
		guaranteeduemonth = monthmanufacture + 6;

	}

	public Car(String PlateNo, int yearmanufacture, int monthmanufacture, String color, double price,
			String manufactureby, int guaranteedueyear, int guaranteeduemonth) {

		this.PlateNo = PlateNo;
		this.yearmanufacture = yearmanufacture;
		this.monthmanufacture = monthmanufacture;
		this.color = color;
		this.price = price;
		this.manufactureby = manufactureby;
		this.guaranteedueyear = guaranteedueyear;
		this.guaranteeduemonth = guaranteeduemonth;
	}

	public Car(Car car) {
		this.PlateNo = car.PlateNo;
		this.yearmanufacture = car.yearmanufacture;
		this.monthmanufacture = car.monthmanufacture;
		this.color = car.color;
		this.price = car.price;
		this.manufactureby = car.manufactureby;
		this.guaranteedueyear = car.guaranteedueyear;
		this.guaranteeduemonth = car.guaranteeduemonth;
		/*
		 * since in java we can't copy object to object cause they are called by
		 * reference not by value i created this constructor in order to copy one object
		 * to another (i am going to use it in maxPrice method in the Driver class)
		 */
	}

	public int getYearManufacture() {
		return yearmanufacture;
	}

	public int getMonthManufacture() {
		return monthmanufacture;
	}

	public String getColor() {
		return color.toUpperCase(); // from the assignment notes All Output string should be printed in UPPER case.
	}

	public double getPrice() {
		return price;
	}

	public void setYearmanufacture(int year) {
		yearmanufacture = year;
	}

	public void setMonthmanufacture(int month) {
		monthmanufacture = month;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setGuarantee(int month, int year) {
		guaranteeduemonth = month;
		guaranteedueyear = year;
	}

	public String getCarAge() {

		int s1 = (date.getYear() + 1900) - yearmanufacture;
		int s2 = Math.abs((date.getMonth() + 1) - monthmanufacture); // Math.abs() to make sure that age in months is
																		// positive
		String s = String.valueOf(s1) + " year/s and " + String.valueOf(s2) + " month/s";
		/*
		 * i used here valueOf() method to convert from int(primitive type) to String
		 * data type.
		 */
		s = s.toUpperCase();
		// from the assignment notes All Output string should be printed in UPPER case.
		return s;
	}

	public String printCarInfo() {

		String s = "PlateNo=" + PlateNo + ", yearmanufacture=" + yearmanufacture + ", monthmanufacture="
				+ monthmanufacture + ", color=" + color + ", price=" + price + ", manufactureby=" + manufactureby
				+ ", guaranteedueyear=" + guaranteedueyear + ", guaranteeduemonth=" + guaranteeduemonth + ".";
		s = s.toUpperCase(); // from the assignment notes All Output string should be printed in UPPER case.
		return s;
		/*
		 * note: i am going to print other informations like car age and car guarantee
		 * inside printCarsInfo method in driver class because the assignment said
		 * "print all information about cars with ages and guarantee due to inside class driver."
		 */
	}

	public String getManufactureby() {
		return manufactureby;
	}

	public String getCalculateGuarantee() {
		if (guaranteedueyear < date.getYear() + 1900) {
			String s = "0 year/s and 0 month/s";
			s = s.toUpperCase(); // from the assignment notes All Output string should be printed in UPPER case.
			return s;
		} else {
			int s1 = guaranteedueyear - (date.getYear() + 1900);
			int s2 = guaranteeduemonth - (date.getMonth() + 1);
			String s = String.valueOf(s1) + " year/s " + String.valueOf(Math.abs(s2)) + " month/s";
			s = s.toUpperCase(); // from the assignment notes All Output string should be printed in UPPER case.
			return s;
		}

	}

}
