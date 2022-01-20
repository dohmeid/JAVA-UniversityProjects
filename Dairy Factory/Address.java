
public class Address {

	private String street;
	private String state;
	private String city;
	private String zip_code;

	public Address() {
		super();
	}

	public Address(String street, String state, String city, String zip_code) {
		super();
		this.street = street;
		this.state = state;
		this.city = city;
		this.zip_code = zip_code;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zip_code;
	}

	public void setZipCode(String zip_code) {
		this.zip_code = zip_code;
	}

	@Override
	public String toString() {
		return "street=" + street + " , state=" + state + " , city=" + city + " , zip_code=" + zip_code + "\n";
	}

}