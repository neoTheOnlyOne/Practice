package nowapps.nxton;

import java.util.*;
import java.util.stream.Collectors;
import java.util.LinkedList;

public class SortNumbers {

	public static void main(String args[]) {
		int arr[] = { 1, 2, 4, 5, 9, 3, 7, 6, 8, 13, 17, 0, 14 };
		int newArr[] = sortAlternate(arr);
		
		doPrint("alternate Sorting: ");
		for(int i=0; i<newArr.length; i++) {
			doPrint(newArr[i]);
		}

		int arr1[] = { 1, 2, 2, 5, 5, 1, 1, 1, 8, 8, 6 };
		int arr2[] = { 5, 2, 2, 6, -1, 9999999, 5, 8, 8, 8 };
		sortFrequencyWise(arr2);
	}

	public static int[] sortAlternate(int arr[]) {
		Arrays.sort(arr);
		int newArr[] = new int[arr.length];
		int newIndx=0;
		
		int maxLoopLen;
		if(arr.length%2==0)
			maxLoopLen = arr.length / 2;
		else
			maxLoopLen = (arr.length / 2)+1;
		
		for (int i = 0, j = arr.length; i < maxLoopLen; i++, j--) {
			newArr[newIndx] = arr[j - 1];
			if(newIndx+1<arr.length)
				newArr[newIndx + 1] = arr[i];
			newIndx +=2;
		}
		return newArr;
	}

	static void sortFrequencyWise(int arr[]) {
		HashMap<Integer, Integer> map = new LinkedHashMap<>();
		int tmpCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				tmpCount = map.get(arr[i]);
				map.put(arr[i], tmpCount + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		HashMap<Integer, Integer> sortedMap = (HashMap<Integer, Integer>) sortHMByValue(map);

		for (Integer i : sortedMap.keySet()) {
			
			//doPrint("Key: " + i + "ferquency: " + map.get(i));
			
			for(int j=0; j<map.get(i); j++) {
				doPrint(i);
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
	
	/** generic */
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new java.util.LinkedList<Map.Entry<K, V>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue8(Map<K, V> map) {
		return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

	public static void doPrint(Object o) {
		System.out.println(o);
	}
}
