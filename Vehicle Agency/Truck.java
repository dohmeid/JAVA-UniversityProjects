public class Truck extends Vehicles {

	private boolean airConditionON = false;
	private int power;
	private int numberOfSeats;

	public Truck() {
		super();
	}

	public Truck(String modelName, String modelNo, String brand, String ownerName, String engineType, double tunkSize,
			double fuelConsumption, boolean airConditionON, int power, int numberOfSeats) {
		super(modelName, modelNo, brand, ownerName, engineType, tunkSize, fuelConsumption);
		this.airConditionON = airConditionON;
		this.power = power;
		this.numberOfSeats = numberOfSeats;
	}

	public boolean isAirConditionON() { // the getter method for air condition
		return airConditionON;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	@Override
	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	@Override
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	@Override
	public double costFor100Km() {
		double cost = 0.0;
		if (airConditionON == false)
			cost = PetroleumType.getDieselPrice() * (100 / fuelConsumption);

		else {
			fuelConsumption += fuelConsumption * 0.2;
			cost = PetroleumType.getDieselPrice() * (100 / fuelConsumption);
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
		return super.toString() + "airConditionOn=" + airConditionON + ", power=" + power + ", numberOfSeats="
				+ numberOfSeats;
	}

}
