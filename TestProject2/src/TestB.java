
import java.util.Arrays;
import java.util.List;

public class TestB {
	
	public static void main(String args[]) {
		/*String s1 = "10 15";
		String arr[] = s1.split("\\s");
		System.out.println(arr[0]);
		System.out.println(arr[1]);*/
		
		//test comments
		testArray();
		
	}
	
	static void testArray() {
		
		int arr[] = {1, 200, 150, 4, 5, 100};
		int sum = 0;
		int n = arr.length;
		for(int i : arr) {
			sum+=i;
		}
		System.out.println("sum: " + sum);
		System.out.println("array size: " + n);
		int t = sum/n;
		System.out.println("sum / n= " + t);
		System.out.println(t * n);
		System.out.println((t +1)* n);
		
	}
	
	void testLambda() {
		List<Integer> list = Arrays.asList(1, 2, 3);
		list.forEach(x -> System.out.println());
		list.forEach((x) -> {
			x+=10;
			System.out.println(x);
		});
	} 
	
	
}
