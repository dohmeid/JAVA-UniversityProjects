import java.util.ArrayList;

public class PalestinianDairyFactoryDriver {

	public static void main(String[] args) {

		ArrayList<Employee> employees = new ArrayList<>();

		employees.add(new ProductionWorker("aseel", "110-B", new Address("10", "palsetine", "Ramallah", "30001"), 1, 50,
				220));
		employees.add(new ProductionWorker("Doha", "111-B", new Address("11", "palsetine", "Jerusalem", "30062"), 1, 65,
				235));
		employees.add(
				new ProductionWorker("fada", "132-B", new Address("12", "palsetine", "Nablus", "300050"), 2, 70, 208));

		int[] info1 = { 2000, 300, 40, 33 };
		int[] info2 = { 5000, 50, 30, 28 };
		int[] info3 = { 7000, 400, 60, 44 };
		employees.add(new ShiftSupervisor("joe", "113-H", new Address("13", "palsetine", "Ramallah", "30004"), info1));
		employees.add(new ShiftSupervisor("malak", "114-H", new Address("14", "palsetine", "Jenin", "30082"), info2));
		employees.add(new ShiftSupervisor("sara", "115-H", new Address("15", "palsetine", "Ramallah", "30003"), info3));

		int[] info4 = { 4000, 50, 77 };
		int[] info5 = { 5500, 45, 46 };
		int[] info6 = { 10000, 70, 110 };
		employees.add(new TeamLeader("shaimaa", "116-C", new Address("16", "palsetine", "Tulkarm", "30032"), 2, 50, 220,
				info4));
		employees.add(new TeamLeader("khalil", "116-C", new Address("17", "palsetine", "Tulkarm", "30036"), 1, 50, 220,
				info5));
		employees.add(new TeamLeader("ghaydaa", "116-C", new Address("18", "palsetine", "Ramallah", "30007"), 1, 50,
				220, info6));

		ListGreaterThanAverage(employees);

	}

	public static void ListGreaterThanAverage(ArrayList<Employee> list) {

		System.out.println("EMPLOYEES WHOSE SALARY IS GREATER THAN THE AVAREGE OF THE EMPLOYEES : \n");

		double salareies_sum = 0.0;
		double salaries_avarege = 0.0;

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i) instanceof ProductionWorker)
				salareies_sum += ((ProductionWorker) list.get(i)).getTotalSalary();

			else if (list.get(i) instanceof ShiftSupervisor)
				salareies_sum += ((ShiftSupervisor) list.get(i)).getTotalSalary();

			else if (list.get(i) instanceof TeamLeader)
				salareies_sum += ((TeamLeader) list.get(i)).getTotalSalary();
		}

		salaries_avarege = salareies_sum / list.size();

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i) instanceof ProductionWorker)
				if (((ProductionWorker) list.get(i)).getTotalSalary() > salaries_avarege)
					System.out.println(((ProductionWorker) list.get(i)).toString() + "\n");

				else if (list.get(i) instanceof ShiftSupervisor)
					if (((ShiftSupervisor) list.get(i)).getTotalSalary() > salaries_avarege)
						System.out.println(((ShiftSupervisor) list.get(i)).toString() + "\n");

					else if (list.get(i) instanceof TeamLeader)
						if (((TeamLeader) list.get(i)).getTotalSalary() > salaries_avarege)
							System.out.println(((TeamLeader) list.get(i)).toString() + "\n");

		}
	}
}
