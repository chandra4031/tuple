package com.srs.tuples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Sekhar
 * @Date 20/02/2019
 *
 */
public class TupleTest {

	public static void main(String[] args) {

		List<Map<Integer, Integer>> tupleList = new ArrayList<Map<Integer, Integer>>();
		List<List<Map<Integer, Integer>>> result = new ArrayList<List<Map<Integer, Integer>>>();

		int size = addTuplesToMap(tupleList);
		displayOptimumPossibleSlots(tupleList, result, size);

		System.out.println(result);
	}

	/**
	 * method to display optimum possible slots for given tuples
	 * 
	 * @param tupleList
	 * @param result
	 * @param size
	 */
	private static void displayOptimumPossibleSlots(List<Map<Integer, Integer>> tupleList,
			List<List<Map<Integer, Integer>>> result, int size) {
		/**
		 * finding the optimum selection possibles
		 */
		for (int i = 0; i < size; i++) {
			List<Map<Integer, Integer>> possibleSelection = new ArrayList<Map<Integer, Integer>>();
			Map<Integer, Integer> tuple = tupleList.get(i);
			possibleSelection.add(tuple);
			Integer endSlot = tuple.get(Integer.parseInt(tuple.keySet().toArray()[0].toString()));
			for (int j = 0; j < size; j++) {
				if (i != j) {
					tuple = tupleList.get(j);
					if (endSlot < Integer.parseInt(tuple.keySet().toArray()[0].toString())) {
						possibleSelection.add(tuple);
						endSlot = tuple.get(Integer.parseInt(tuple.keySet().toArray()[0].toString()));
					}
				}
			}
			result.add(possibleSelection);

		}
	}

	/**
	 * Method is ues to add tuples into map as a key value pair
	 * 
	 * @param tupleList
	 * @return
	 */
	private static int addTuplesToMap(List<Map<Integer, Integer>> tupleList) {
		// [(1, 3), (2, 5), (5, 8), (4, 9), (1, 9)]
		// adding tuples to map
		Map<Integer, Integer> tuple1 = new HashMap<Integer, Integer>();
		tuple1.put(1, 3);
		tupleList.add(tuple1);

		Map<Integer, Integer> tuple2 = new HashMap<Integer, Integer>();
		tuple2.put(2, 5);
		tupleList.add(tuple2);

		Map<Integer, Integer> tuple3 = new HashMap<Integer, Integer>();
		tuple3.put(5, 8);
		tupleList.add(tuple3);

		Map<Integer, Integer> tuple4 = new HashMap<Integer, Integer>();
		tuple4.put(4, 9);
		tupleList.add(tuple4);

		Map<Integer, Integer> tuple5 = new HashMap<Integer, Integer>();
		tuple5.put(1, 9);
		tupleList.add(tuple5);

		int size = tupleList.size();
		return size;
	}

}
