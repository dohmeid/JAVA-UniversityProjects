public class Car extends Vehicles {

	private int numberOfSeats;
	private boolean airConditionON = false;// the assignment mentioned that the default value rot the air condition must
											// be off(false).

	public Car() {
		super();
	}

	// here no need to check that the engine Type for the car is gasoline
	// because this constructor will call the constructor in vehicles which i
	// checked there the engine type.
	public Car(String modelName, String modelNo, String brand, String ownerName, String engineType, double tunkSize,
			double fuelConsumption, int numberOfSeats, boolean airConditionON) {
		super(modelName, modelNo, brand, ownerName, engineType, tunkSize, fuelConsumption);
		this.numberOfSeats = numberOfSeats;
		this.airConditionON = airConditionON;
	}

	@Override
	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	@Override
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	// this the getter method for the air condition but it's name is
	// isAirConditionON() instead of getAirConditionON() because it returns a
	// boolean value which it's should start with is due to naming conventions
	public boolean isAirConditionON() {
		return airConditionON;
	}

	@Override
	public double costFor100Km() {
		double cost = 0.0;

		if (airConditionON == false)
			cost = PetroleumType.getGasolinePrice() * (100 / fuelConsumption);
		else {
			fuelConsumption += fuelConsumption * 0.1;// Fuel consumption of the Car increased by 10% when air-condition
														// of the Car is ON.
			cost = PetroleumType.getGasolinePrice() * (100 / fuelConsumption);
		}
		return cost;
	}

	@Override
	public void setAirConditionON() {
		this.airConditionON = true;
	}

	@Override
	public void setAirConditionOff() {
		this.airConditionON = false;
	}

	@Override
	public String toString() {
		return super.toString() + "numberOfSeats=" + numberOfSeats + ", airConditionON=" + airConditionON;
	}

}
