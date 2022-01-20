import java.util.Calendar;
import java.util.GregorianCalendar;

public class Owner {

	private String name;
	private String tel;
	private String address;
	private String registrationNo;
	private GregorianCalendar dateOfRegistration;

	public Owner() {
		super();
	}

	// because we only want the owner name in the assignment.
	public Owner(String name) {
		this.name = name;
	}

	public Owner(String name, String tel, String address, String registrationNo, GregorianCalendar dateOfRegistration) {
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.registrationNo = registrationNo;
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public GregorianCalendar getDateOfBirth() {
		return dateOfRegistration;
	}

	public void setDateOfBirth(GregorianCalendar dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public double getAge() {

		Calendar nowDate = new GregorianCalendar();
		double age = 0.0;

		if (nowDate.get(Calendar.YEAR) > dateOfRegistration.get(Calendar.YEAR)) {
			double years = nowDate.get(Calendar.YEAR) - dateOfRegistration.get(Calendar.YEAR);
			double months = Math.abs(nowDate.get(Calendar.MONTH) - dateOfRegistration.get(Calendar.MONTH));
			age = years + (months / 12); // because the year has 12 months and so the month equals 1/12 years and i want
											// to calculate age in years
			return age;
		} else
			System.out.println("INVALID DATE OF BIRTH"); // in this case the owner will not be born yet which is invalid
		return age;
	}

	@Override
	public String toString() {
		return "name = " + name + " , tel = " + tel + " , address = " + address + ", registrationNo = " + registrationNo
				+ " , dateOfRegistration = " + dateOfRegistration;
	}

	// all classes should be clonable as the assignment said.
	@Override
	public Object clone() throws CloneNotSupportedException {
		Owner owner = (Owner) super.clone();
		return owner;
	}

}
