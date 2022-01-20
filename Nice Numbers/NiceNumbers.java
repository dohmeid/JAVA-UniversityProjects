import java.util.Scanner;

public class NiceNumbers {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("enter 3 integer numbers : ");
		int leftBound = input.nextInt();
		int rightBound = input.nextInt();
		int digitToExclude = input.nextInt();

		niceNumbers(leftBound, rightBound, digitToExclude);

	}

	public static void niceNumbers(int left, int right, int digit) {

		int a, b, c;

		/*
		 * a,b,c are for each number (between the leftBound and rightBound) digit's a is
		 * for the right digit , b for the middle digit , c for the left digit
		 */
		System.out.println("Nice Numbers in Range Left=" + left + ", Right=" + right + " with exclude digit m=" + digit
				+ " are: ");

		if (left < right) {
			for (int i = left; i <= right; i++) {
				a = i % 10;
				b = (i % 100) / 10;
				c = i / 100;

				if (a == digit || b == digit || c == digit)
					System.out.print("");

				else if (c > a + b && b > a)
					System.out.print(" " + i + " ");
			}
		}
	}
}
