import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) throws IOException, CloneNotSupportedException {

		File file1 = new File("inputdata.txt");
		File file2 = new File("output.txt");
		ArrayList<Vehicles> vehicles;
		StringBuilder data = readfile(file1);
		vehicles = dataToArrayList(data);
		int operationNumber = 0;
		Scanner in = new Scanner(System.in);
		System.out.println(
				"HELLO , HERE IS THE MENU , PLEASE ENTER THE NUMBER FOR THE OPERATION YOU WANT TO DO , 9 IS TO EXIT THE MENU");
		do {
			System.out.println(
					"1. Read the data about objects from the file “inputdata.txt” and store them in Arraylist.\n"
							+ "2. Set prices of petroleum.\n"
							+ "3. Print sorted order Vehicles in an ascending order based on costFor100Km.\n"
							+ "4. (Bonus ) Print sorted order Vehicles in an ascending order based on owner name .\n"
							+ "5. (Bonus ) Print sorted order Vehicles in an descending order based on vehicle brand.\n"
							+ "6. Clone Vehicle without owner. (Ask user to choice one object for cloning from Arraylist, after Listing them to user )\n"
							+ "7. Turn air-condition on\r\n"
							+ "8. Write Output on the “output.txt” file after sort them.\n" + "9. Exit from System");

			operationNumber = in.nextInt();

			if (operationNumber == 1) {
				for (Vehicles str : vehicles) // to print the array list.
					System.out.println(str);
				continue;
			}

			else if (operationNumber == 2) {
				System.out.println("SETTING PRICES FOR Petroleum \n" + "PRICE FOR DIESEL: ");
				PetroleumType.setDieselPrice(in.nextDouble());
				System.out.println("PRICE FOR GASOLINE: ");
				PetroleumType.setGasolinePrice(in.nextDouble());
				System.out.println("^_^ DONE ^_^");
			}

			else if (operationNumber == 3) {
				sorting(vehicles);
				for (Vehicles str : vehicles) // to print the array list after sorting .
					System.out.println(str);
			}

			else if (operationNumber == 4) {

				Vehicles temp;
				for (int i = 0; i < vehicles.size(); i++) {
					for (int j = i + 1; j < vehicles.size(); j++) {
						if (vehicles.get(i).getOwnerName().compareTo(vehicles.get(j).getOwnerName()) > 0) {
							temp = vehicles.get(i);
							vehicles.set(i, vehicles.get(j));
							vehicles.set((j), temp);
						}
					}
				}

				for (Vehicles str : vehicles) // to print the array list after sorting.
					System.out.println(str);
			}

			else if (operationNumber == 5) {

				Vehicles temp;
				for (int i = 0; i < vehicles.size(); i++) {
					for (int j = i + 1; j < vehicles.size(); j++) {
						if (vehicles.get(i).getBrand().compareTo(vehicles.get(j).getBrand()) > 0) {
							temp = vehicles.get(i);
							vehicles.set(i, vehicles.get(j));
							vehicles.set((j), temp);
						}
					}
				}

				for (Vehicles str : vehicles) // to print the array list after sorting.
					System.out.println(str);

			}

			else if (operationNumber == 6) {

				for (Vehicles str : vehicles) // to print the array list to the user.
					System.out.println(str.toString());

				System.out.println("CHOOSE ONE OBJECT TO CLONE FROM THE ABOVE LIST");
				System.out.println("NOTE :ENTER THE NUMBER OF THE OBJECT (AS IT APPEARS) THAT YOU WANT TO CLONE");
				int index = in.nextInt();

				while (true) {
					if (index >= vehicles.size()) { // to check if index is wrong
						System.out.println("ERROR: THE NUMBER IS WRONG , PLEASE SELECT CAREFULLY AGAIN");
						index = in.nextInt();
					}
					Vehicles clonedVehicle = (Vehicles) vehicles.get(index - 1).clone();
					System.out.println("HERE IS THE CLONED OBJECT " + clonedVehicle.toString());
					break;
				}
			}

			else if (operationNumber == 7)
				turnAirConditionOn(vehicles);

			else if (operationNumber == 8)
				writeOutputOnFile(file2, vehicles);

			else if (operationNumber == 9) {
				System.out.println("GOODBYE :'( ");
				System.exit(0);
			}

			else
				System.out.println("WRONG INPUT , TRY AGAIN");

			System.out.println("********************************************** \n" + "^.^ CHOOSE AGAIN ^_^");
		} while (operationNumber != 9);

		System.out.println("GOODBYE :'( ");

		in.close();

	}

	public static StringBuilder readfile(File f) throws IOException {
		StringBuilder data1 = new StringBuilder("");
		try {
			Scanner input = new Scanner(f);
			while (input.hasNextLine()) {
				data1.append(input.nextLine());
				// to split by comma :
				for (int i = 0; i < data1.length(); i++) {
					if (data1.charAt(i) == ',')
						data1.setCharAt(data1.indexOf(","), ' ');
				}
				data1.append("\n");
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("ERROR : FILE NOT FOUND :( ");
		}
		return data1;
	}

	public static ArrayList<Vehicles> dataToArrayList(StringBuilder a) {

		ArrayList<Vehicles> vehicles = new ArrayList<>();
		String[] lines = a.toString().trim().split("\n");

		try {
			for (int i = 0; i < lines.length; i++) {
				String[] words = lines[i].split(" ");

				Vehicles vec;
				if (words[0].equals("Car"))
					vec = new Car();

				else if (words[0].equals("MiniVan")) {
					vec = new Minivan();
					if (words[9].equals("true"))// because in the default its false so no need to initialized
						// another time if it false.
						vec.setAirConditionON();

				} else if (words[0].equals("Truck")) {
					vec = new Truck();
					((Truck) vec).setPower(Integer.parseInt(words[9]));

				} else
					throw new IllegalArgumentException();// there is no type other than car,minivan,truck.

				vec.setModelName(words[1]);
				vec.setModelNo(words[2]);
				vec.setBrand(words[3]);
				Owner owner = new Owner(words[4]);
				vec.setOwner(owner);
				vec.setEngineType(words[5]);
				vec.setTunkSize(Double.parseDouble(words[6]));
				vec.setFuelConsumption(Double.parseDouble(words[7]));
				vec.setNumberOfSeats(Integer.parseInt(words[8]));
				vehicles.add(vec);
			}

		} catch (IllegalArgumentException e) {
			System.out.println("ERROR , WRONG TYPE");
		}

		return vehicles;
	}

	public static void sorting(ArrayList<Vehicles> v) {
		Collections.sort(v);// note: since i overridden the compare to method , i can use the
		// collections.sort for sorting in ascending order.
	}

	public static void turnAirConditionOn(ArrayList<Vehicles> v) {
		System.out.println("SETTING THE AIR CONDITION TO ON IN PROCESS");
		for (Vehicles o : v)
			o.setAirConditionON();
		System.out.println("^_^ DONE ^_^");
	}

	public static void writeOutputOnFile(File f, ArrayList<Vehicles> v) throws FileNotFoundException {

		try {
			PrintWriter output = new PrintWriter(f);
			sorting(v); // to sort data before printing them using the method defined earlier.

			output.print("\n *************** HERE ARE THE DATA AFTER SORTING *************** + \n");
			for (Vehicles str : v) // to print the array list to file.
				output.print(str + "\n");

			output.close();

		} catch (FileNotFoundException e) {
			System.out.println("ERROR : FILE NOT FOUND :( ");
		}
		System.out.println("FINISHED YOU CAN CHECK THE OUTPUT FILE ^_^");

	}

}
