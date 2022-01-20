
public class ProductionWorker extends Employee {

	private int shift;
	private double hourly_pay_rate;
	private int number_of_hours_permonth;

	public ProductionWorker() {
		super();
	}

	public ProductionWorker(String employee_name, String employee_number, Address address, int shift,
			double hourly_pay_rate, int number_of_hours_permonth) {
		super(employee_name, employee_number, address);

		if (shift == 1 || shift == 2) // to check that the the shift is valid
			this.shift = shift;
		else
			System.out.println("INVALID SHIFT: SHIFT SHOULD BE EITHER 1 FOR DAY SHIFT OR 2 FOR NIGHT SHIFT ");

		this.hourly_pay_rate = hourly_pay_rate;
		this.number_of_hours_permonth = number_of_hours_permonth;

	}

	public int getShift() {
		return shift;
	}

	public void setShift(int shift) {

		if (shift == 1 || shift == 2) // to check that the the shift is valid
			this.shift = shift;
		else
			System.out.println("INVALID SHIFT: SHIFT SHULD BE EITHER 1 FOR DAY SHIFT OR 2 FOR NIGHT SHIFT ");
	}

	public double getHourlyPayRate() {
		return hourly_pay_rate;
	}

	public void setHourlyPayRate(double hourly_pay_rate) {
		this.hourly_pay_rate = hourly_pay_rate;
	}

	public int getNumberOfHoursPerMonth() {
		return number_of_hours_permonth;
	}

	public void setNumberOfHoursPerMonth(int number_of_hours_permonth) {
		this.number_of_hours_permonth = number_of_hours_permonth;
	}

	public double salaryBasedOnShift(int minimum_hours_per_day, double extra_hours_rate) {
		/*
		 * this is an extra method to calculate the total salary based on each shift
		 * instead of doing the same calculations twice for each shift and changing
		 * number i made this general method then i am gonna call it for each shift
		 */

		double total_salary = 0.0;
		int x = (minimum_hours_per_day * 26); // x represents minimum work hours per month
		int y = number_of_hours_permonth - x; // y represents extra hours worked in a month

		if (number_of_hours_permonth >= x)
			total_salary = (x * hourly_pay_rate) + y * (hourly_pay_rate / extra_hours_rate);

		else
			System.out.println(
					"SORRY YOU DIDN'T WORK THE MINMUM HOURS REQUIRED TO GET PAID , WORK HARDER NEXT MONTH :( ");

		return total_salary;
	}

	public double getTotalSalary() {

		if (shift == 1)
			return salaryBasedOnShift(8, 1.25);

		else if (shift == 2)
			return salaryBasedOnShift(7, 1.5);

		else
			return -1;
	}

	@Override
	public String toString() {
		return super.toString() + "shift=" + shift + " ,hourly pay rate=" + hourly_pay_rate
				+ " ,number of hours permonth=" + number_of_hours_permonth + "\n";
	}

}
