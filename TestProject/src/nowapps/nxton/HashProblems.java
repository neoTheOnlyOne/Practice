package nowapps.nxton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HashProblems {

	public static void main(String args[]) {
		Integer arr[] = {2,5, 2,-1, 6, 9999999,-1, 5, 8, 8, 8 };
		Integer arr1[] = { 2, 5, 2, -1, 6, 9999999, -1, 5, 8, 8, 8, -1, 7, -1 };
		sortByFrequency3(arr);
		//sortByFrequency2(arr);
		System.out.println("\n");
		//sortByFrequency3(arr);
	}

	public static void sortByFrequency(Integer arr[]) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		int index = 0;
		for (int i : arr) {
			if (map.containsKey(i)) {
				List<Integer> l = map.get(i);
				int val = l.get(0) + 1;
				l.set(0, val);
				map.put(i, l);
			} else {
				List<Integer> l = new ArrayList<Integer>();
				l.add(0);
				l.add(index);
				map.put(i, l);
			}
			index++;
		}
		Arrays.sort(arr, new FrequencyComparator(map));
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println("\n");

	}

	public static void sortByFrequency2(Integer arr[]) {
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for (int i : arr) {
			if (map.containsKey(i))
				map.put(i, map.get(i) + 1);
			else
				map.put(i, 1);
		}
		Map<Integer, ArrayList<Integer>> tr = new TreeMap<Integer, ArrayList<Integer>>(
				Collections.reverseOrder());
		for (int k : map.keySet()) {
			int val = map.get(k);
			if (tr.containsKey(val)) {
				ArrayList<Integer> list = tr.get(val);
				list.add(k);
				tr.put(val, list);
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(k);
				tr.put(val, list);
			}
		}

		for (int i : tr.keySet()) {
			for (int k = 0; k < tr.get(i).size(); k++)
				for (int j = 0; j < i; j++)
					System.out.print(tr.get(i).get(k) + " ");
		}

	}
	
	public static void sortByFrequency3(Integer arr[]){
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		Map<Integer, Integer> sortedMap = sortHMByValue(map);
		for (Integer i : sortedMap.keySet()) {
			for(int j=0; j<map.get(i); j++) {
				System.out.print(i+ " ");
			}
		}

	}

	public static Map<Integer, Integer> sortHMByValue(Map<Integer, Integer> map) {
		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		Map<Integer, Integer> result = new LinkedHashMap<Integer, Integer>();
		for (Map.Entry<Integer, Integer> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
}

class FrequencyComparator implements Comparator<Integer> {
	Map<Integer, List<Integer>> map;

	public FrequencyComparator(Map<Integer, List<Integer>> map) {
		this.map = map;
	}

	@Override
	public int compare(Integer o1, Integer o2) {
		//compare the frequency of the elements
		int a = map.get(o1).get(0);
		doPrint("map.get(o1)=> " + map.get(o1) + " : " + map.get(o1).get(0));
		doPrint("a=> " + a);
		
		
		int b = map.get(o2).get(0);
		doPrint("map.get(o2)=> " + map.get(o2) + " : " + map.get(o2).get(0));
		doPrint("b=> " + b);
		//if frequency is same compare the index of the elements
		if (a == b)
			return map.get(o1).get(1) - map.get(o2).get(1);
		return b - a;
	}

	static void doPrint(Object o) {
		System.out.println(o);
	}
	
}