
public abstract class Vehicles implements Cloneable, Comparable<Vehicles> {

	protected String modelName;
	protected String modelNo;
	protected String brand;
	protected String engineType;
	protected double tunkSize;
	protected double fuelConsumption;
	public Owner owner;

	public Vehicles() {
		super();
	}

	public Vehicles(String modelName, String modelNo, String brand, String ownerName, String engineType,
			double tunkSize, double fuelConsumption) {
		super();
		this.modelName = modelName;
		this.modelNo = modelNo;
		this.brand = brand;
		this.setEngineType(engineType); // Because i already did the exception in that method, no need to rewrite it.
		this.tunkSize = tunkSize;
		this.fuelConsumption = fuelConsumption;
		owner.setName(ownerName); // in the assignment we only want the owner name.

	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getEngineType() {
		return engineType;
	}

	// engine type is supposed to be from petroleum types available.
	public void setEngineType(String engineType) throws IllegalArgumentException {
		try {

			if (this instanceof Car) {
				if ((engineType.equals("Gasoline") || engineType.equals("Hybrid")) == false)
					throw new IllegalArgumentException();

				else
					this.engineType = engineType;
			}

			else if (this instanceof Minivan) {
				if ((engineType.equals("Gasoline") || engineType.equals("Diesel")) == false)
					throw new IllegalArgumentException();
				else
					this.engineType = engineType;
			}

			else if (this instanceof Truck) {
				if (engineType.equals("Diesel") == false)
					throw new IllegalArgumentException();
				else
					this.engineType = engineType;
			}
		}

		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage() + "\n"
					+ "ENGINE TYPE SHOULD BE EITHER GASOLINE OR HYBIRD FOR CARS , DIESEL FOR TRUCK, AND EITHER GASLLONE OR DIESEL FOR MINIVAN");
		}
	}

	public double getTunkSize() {
		return tunkSize;
	}

	public void setTunkSize(double tunkSize) {
		this.tunkSize = tunkSize;
	}

	public double getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public Owner getOwner() {
		return owner;
	}

	// i am going to use it in the main.
	public String getOwnerName() {
		return owner.getName();
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public abstract double costFor100Km(); // it will return a cost(money) which is double.

	public double movableDistance() {
		if (tunkSize != 0)
			return this.fuelConsumption * this.tunkSize;
		else
			return 0;

	}

	public abstract void setAirConditionON();

	public abstract void setAirConditionOff();

	// I noticed that these 2 methods appear twice , in the minivan class and in the
	// truck class so i made them abstract.
	public abstract void setNumberOfSeats(int numberOfSeats);

	public abstract int getNumberOfSeats();

	@Override
	public Object clone() throws CloneNotSupportedException {
		try {
			Vehicles clonedVehicle = (Vehicles) super.clone(); // shallow copy to clone the primitive types
			clonedVehicle.owner = null;// setting the owner of the cloned vehicle to null
			return clonedVehicle;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	@Override
	public int compareTo(Vehicles o) {
		if (costFor100Km() > o.costFor100Km()) // to compare between 2 objects based on cost for 100km.
			return 1;
		else if (costFor100Km() < o.costFor100Km())
			return -1;
		else
			return 0;
	}

	@Override
	public String toString() {

		// we have to check owner to prevent error when cloning object and printing it.
		return "ModelName:" + modelName + ", ModelNo:" + modelNo + ", Brand:" + brand
				+ ((owner != null) ? owner.getName() : "null") + ", EngineType:" + engineType + ", TankSize:" + tunkSize
				+ ", FuelConsumption:" + fuelConsumption + ", Movable distance:" + movableDistance() + ", CostFor100Km:"
				+ costFor100Km() + "\t";
	}

}
