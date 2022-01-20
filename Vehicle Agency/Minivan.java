public class Minivan extends Vehicles {

	private int numberOfSeats;
	private boolean airConditionON = false;// the assignment mentioned that the default value rot the air condition must
											// be off(false).
	private boolean hasAutoDoors;

	public Minivan() {
		super();
	}

	public Minivan(String modelName, String modelNo, String brand, String ownerName, String engineType, double tunkSize,
			double fuelConsumption, int numberOfSeats, boolean airConditionON, boolean hasAutoDoors) {
		super(modelName, modelNo, brand, ownerName, engineType, tunkSize, fuelConsumption);
		this.numberOfSeats = numberOfSeats;
		this.airConditionON = airConditionON;
		this.hasAutoDoors = hasAutoDoors;
	}

	@Override
	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	@Override
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public boolean isAirConditionOn() { // the getter for air condition but it's name is isAirCondition because it will
										// return a boolean value
		return airConditionON;
	}

	public boolean isHasAutoDoors() {// the getter for has auto doors but it's name is isHasAutoDoors because it
										// will return a boolean value.
		return hasAutoDoors;
	}

	public void setHasAutoDoors(boolean hasAutoDoors) {
		this.hasAutoDoors = hasAutoDoors;
	}

	@Override
	public double costFor100Km() {
		double cost = 0.0;
		if (engineType.equals("Gasoline")) {
			if (airConditionON == false)
				cost = PetroleumType.getGasolinePrice() * (100 / fuelConsumption);
			else {
				fuelConsumption += fuelConsumption * 0.2;
				cost = PetroleumType.getGasolinePrice() * (100 / fuelConsumption);
			}
		}

		else if (engineType.equals("Diesel")) {

			if (airConditionON == false)
				cost = PetroleumType.getDieselPrice() * (100 / fuelConsumption);
			else {
				fuelConsumption += fuelConsumption * 0.2;
				cost = PetroleumType.getDieselPrice() * (100 / fuelConsumption);
			}
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
		return super.toString() + "numberOfSeats=" + numberOfSeats + ", airConditionOn=" + airConditionON
				+ ", hasAutoDoors=" + hasAutoDoors;
	}

}
