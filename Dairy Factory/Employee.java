
import java.util.Date;

public class Employee {

	private String employee_name;
	private String employee_number;
	private java.util.Date hire_date;
	private Address address;

	public Employee() { // it's Important to always provide an empty constructor (constructor with no
						// arguments).
		super(); // cause Employee class (as all classes) is a subclass from the Object class.
		hire_date = new Date(); // i don't wanna assign new date for every employee :).

	}

	public Employee(String employee_name, String employee_number, Address address) {
		this(); // to call the empty constructor to initialize hire date.

		this.employee_name = employee_name;
		this.address = address;

		if (isEmpNumberValid(employee_number) == false) // to check that the employee number has the right format
			System.out.println("INVALID EMPLOYEE NUMBER");
		else
			this.employee_number = employee_number;

	}

	public String getName() {
		return employee_name;
	}

	public void setName(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getNumber() {
		return employee_number;
	}

	public void setNumber(String employee_number) {
		if (isEmpNumberValid(employee_number) == false) // to check that the employee number has the right format
			System.out.println("INVALID EMPLOYEE NUMBER");
		else
			this.employee_number = employee_number;
	}

	public java.util.Date getHireDate() {
		return hire_date;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isEmpNumberValid(String employee_number) {

		boolean flag1 = false, flag2 = false;

		// to check if the first 3 digits in the employee_number are integers with range
		// from 0 to 9.
		for (int i = 0; i < 3; i++) {
			for (char j = '0'; j <= '9'; j++) {
				if (employee_number.charAt(i) == j) {
					flag1 = true;
					break;
				}
			}
		}

		// to check if the last digit in the employee_number is character within range
		// from A to M.
		for (char i = 'A'; i <= 'M'; i++) {
			if (employee_number.charAt(4) == i) {
				flag2 = true;
				break;
			}
		}

		// to check if all the rules apply to the employee_number
		if (employee_number.length() == 5 && employee_number.charAt(3) == '-' && flag1 == true && flag2 == true)
			return true;
		else
			return false;
	}

	/*
	 * i noticed that all the subclasses have a getTotalSalary method so i decided
	 * to write it as an extra method in the Employee class and all the subclasses
	 * will override it.
	 */

	@Override // it's overridden from the Object class (o_o)
	public String toString() {
		return "employee name=" + employee_name + " ,employee number=" + employee_number + " ,hire date=" + hire_date
				+ " ,address=" + address.toString();

	}

}
