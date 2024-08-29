package JavaLogic;

public class verify_list_of_Values_Present_in_Stringg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "asnbvcd abcadkhbdaj acffbcasb shkd";
		String s1 = "asnbvcd abcadkhbdaj acffbcasb shkd havdjh mdb";
		String[] arr = s.split(" ", 0);
		int j=0;
		int d = arr.length;
		System.out.println(d);
		for (int i = 0; i < d; i++) {

			// System.out.println(arr[i]);
			Boolean b = s1.contains(arr[i]);
			if (b == true) {
				j++;
				//System.out.println("Pass");
			} else {
				System.out.println("fail");
				break;
			}
			if(d==j) {
				
				System.out.println("Pass");
			}
		}

	}

}
