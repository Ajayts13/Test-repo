package testNG_parctice;

public class getSaveings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		salary();
	}

	public static void salary() {

		int sal[] = { 12000, 15000, 2000 };
		int exp[] = { 2000, 5000, 200 };
		int maxDiff = 0;
		for (int i = 0; i < sal.length; i++) {
			System.out.println(maxDiff);

			int c = 0;
			c = sal[i] - exp[i];

			if (c > maxDiff) {
				maxDiff = c;

			}
		}
		System.out.println("end " + maxDiff);

	}

}
