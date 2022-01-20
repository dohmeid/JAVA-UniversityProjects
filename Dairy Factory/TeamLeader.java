import java.util.Arrays;

public class TeamLeader extends ProductionWorker {

	private int[] teamleader_info = new int[3];

	/*
	 * such that a[0] = Monthly Bonus , a[1] = Required Training Hours, a[2] =
	 * Training Hours Attended
	 */

	/*
	 * NOTE: i didn't put each one in a data field alone because the assignment said
	 * "The TeamLeader class should have a field that holds the following information:..."
	 * ,so it's one field that holds all the informations
	 */

	public TeamLeader() {
		super();
	}

	public TeamLeader(String employee_name, String employee_number, Address address, int shift, double hourly_pay_rate,
			int number_of_hours_permonth, int[] teamleader_info) {
		super(employee_name, employee_number, address, shift, hourly_pay_rate, number_of_hours_permonth);
		this.teamleader_info = teamleader_info;

	}

	public int[] getA() {
		return teamleader_info;
	}

	public void setA(int[] teamleader_info) {
		this.teamleader_info = teamleader_info;
	}

	@Override
	public double getTotalSalary() {
		double total_salary = 0.0;
		double Bonus_achieved = 0.0;

		if (teamleader_info[2] < teamleader_info[1])
			total_salary = super.getTotalSalary();
		/*
		 * because Team leaders are required to attend a minimum number of hours of
		 * training per month and if he/she didn't then he/she won't get bonus ^__^
		 */
		else {
			Bonus_achieved = teamleader_info[0] * (teamleader_info[2] / teamleader_info[1]);
			// the same as Bonus_achieved= Bonus*attended_hours/training_hours
			total_salary = Bonus_achieved + super.getTotalSalary();
		}
		return total_salary;

	}

	@Override
	public String toString() {
		return super.toString() + "teamleader_info=" + Arrays.toString(teamleader_info) + "\n";
	}

}
