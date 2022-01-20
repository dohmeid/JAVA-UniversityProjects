
public class PetroleumType {

	public static final int DIESEL = 1;
	public static final int GASOLINE = 2;
	private static double gasolinePrice = 5.23;
	private static double dieselPrice = 4.02;

	// note: in the uml all of these data fields were underlined which means they
	// are static

	public PetroleumType() {
		super();
	}

	public PetroleumType(double gasolinePrice, double dieselPrice) {
		super();
		PetroleumType.gasolinePrice = gasolinePrice; // we call static data members by the name of the class ^_^
		PetroleumType.dieselPrice = dieselPrice;
	}

	// note: all setters/getters were underlined in the uml which means they are
	// static
	public static double getGasolinePrice() {
		return gasolinePrice;
	}

	public static void setGasolinePrice(double gasolinePrice) {
		PetroleumType.gasolinePrice = gasolinePrice;
	}

	public static double getDieselPrice() {
		return dieselPrice;
	}

	public static void setDieselPrice(double dieselPrice) {
		PetroleumType.dieselPrice = dieselPrice;
	}

	@Override
	public String toString() {
		return "gasolinePrice=" + gasolinePrice + ", dieselPrice=" + dieselPrice;
	}

}
