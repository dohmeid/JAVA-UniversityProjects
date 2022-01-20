import java.util.Arrays;

public class ShiftSupervisor extends Employee {

	private int[] supervisor_info = new int[4];

	/*
	 * such that supervisor_info[0] =monthly salary ,supervisor_info[1] = monthly
	 * production bonus that a shift supervisor has earned.
	 * supervisor_info[2]=Number of products that produced by team that he/she
	 * supervised, supervisor_info[3]= Number of products must produced under
	 * his/her supervision.
	 */

	/*
	 * NOTE: i didn't put each one in a data field alone because the assignment said
	 * "the ShiftSupervisor class should have a field that holds the following
	 * information..." ,so it's one field that holds all the informations
	 */

	public ShiftSupervisor() {
		super();
	}

	public ShiftSupervisor(String employee_name, String employee_number, Address address, int[] supervisor_info) {
		super(employee_name, employee_number, address);
		this.supervisor_info = supervisor_info;

	}

	public int[] getSupervisorInfo() {
		return supervisor_info;
	}

	public void setSupervisorInfo(int[] supervisor_info) {
		this.supervisor_info = supervisor_info;
	}

	public double getTotalSalary() {
		double total_salary = 0.0;

		if (supervisor_info[2] >= supervisor_info[3]) {
			// means if shift supervisor team's produce the required number of products or
			// more
			total_salary = supervisor_info[0] + supervisor_info[1];

		} else
			total_salary = supervisor_info[0];

		return total_salary;
	}

	@Override
	public String toString() {
		return super.toString() + "supervisor_info=" + Arrays.toString(supervisor_info) + "\n";
		// Arrays.toString(...) to convert from array to string
	}

}
