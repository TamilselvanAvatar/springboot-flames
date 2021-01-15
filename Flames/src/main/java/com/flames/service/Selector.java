package com.flames.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.flames.model.FlameAttributes;
@Service
public class Selector {
	public static String letterSelection(FlameAttributes flame) {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> newlist = new ArrayList<String>();
		String mName = flame.getMaleName();
		String fName = flame.getFemaleName();
		
		String mame[] = new String[mName.length()];
		String fame[] = new String[fName.length()];
		int len1 = 0, len2 = 0;
		for (int i = 0; i < fName.length(); i++) {
			if (!((fName.charAt(i) - '0') == -16)) {
				fame[i] = fName.charAt(i) + "";
				list.add(fame[i].toUpperCase());

			} else {
				len1++;
			}
		}

		for (int i = 0; i < mName.length(); i++) {
			if (!((mName.charAt(i) - '0') == -16)) {
				mame[i] = mName.charAt(i) + "";
				newlist.add(mame[i].toUpperCase());

			} else {
				len2++;
			}
		}

		int count = 0;

		for (int i = 0; i < fName.length() - len1; i++) {
			if (newlist.contains(list.get(i))) {
				count++;
			}
		}

		return flamesLetterSelect((fName.length() + mName.length()) - (2 * count) - len1 - len2);

	}

	public static String flamesLetterSelect(int num) {

		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> dummy = new ArrayList<String>();
		String str[] = { "F", "L", "A", "M", "E", "S" };
		for (String string : str) {
			list.add(string);
		}

		if (num == 0) {
			return "Same";
		}

		for (int i = 6; i >= 2; i--) {
			dummy = selectionStarted(num, i, list);
			list = dummy;
		}

		return list.get(0);

		/*Older Version for FLAMES selection
		 * ArrayList<String> list = new ArrayList<String>(); ArrayList<String> dummy =
		 * new ArrayList<String>(); if (num == 0) { return
		 * "May be you enter both name as Single name"; } if (num % 6 == 0) { String
		 * str[] = { "F", "L", "A", "M", "E" }; for (String string : str) {
		 * list.add(string); } } if (num % 6 == 1) { String str[] = { "L", "A", "M",
		 * "E", "S" }; for (String string : str) { list.add(string); } } if (num % 6 ==
		 * 2) { String str[] = { "A", "M", "E", "S", "F" }; for (String string : str) {
		 * list.add(string); } } if (num % 6 == 3) { String str[] = { "M", "E", "S",
		 * "F", "L" }; for (String string : str) { list.add(string); } } if (num % 6 ==
		 * 4) { String str[] = { "E", "S", "F", "L", "A" }; for (String string : str) {
		 * list.add(string); } } if (num % 6 == 5) { String str[] = { "S", "F", "L",
		 * "A", "M" }; for (String string : str) { list.add(string); } }
		 * 
		 * if (num % 5 <= 4 && num % 5 > 0) { list.remove((num % 5) - 1);
		 * 
		 * for (String string : list) { dummy.add(string); } list.removeAll(list);
		 * 
		 * int j = (num % 5) - 1;
		 * 
		 * for (int i = 0; i < 4; i++) { if (j < 4) { list.add(dummy.get(j)); j++; } if
		 * (j >= 4) { j -= 4; } }
		 * 
		 * } if (num % 5 == 0) { list.remove(4); }
		 * 
		 * dummy.removeAll(dummy);
		 * 
		 * if (num % 4 <= 3 && num % 4 > 0) { list.remove((num % 4) - 1); for (String
		 * string : list) { dummy.add(string); } list.removeAll(list); int j = (num % 4)
		 * - 1;
		 * 
		 * for (int i = 0; i < 3; i++) { if (j < 3) { list.add(dummy.get(j)); j++; } if
		 * (j >= 3) { j -= 3; } }
		 * 
		 * } if (num % 4 == 0) { list.remove(3); }
		 * 
		 * dummy.removeAll(dummy);
		 * 
		 * if (num % 3 <= 2 && num % 3 > 0) { list.remove((num % 3) - 1); for (String
		 * string : list) { dummy.add(string); } list.removeAll(list); int j = (num % 3)
		 * - 1;
		 * 
		 * for (int i = 0; i < 2; i++) { if (j < 2) { list.add(dummy.get(j)); j++; } if
		 * (j >= 2) { j -= 2; } }
		 * 
		 * } if (num % 3 == 0) { list.remove(2); }
		 * 
		 * dummy.removeAll(dummy);
		 * 
		 * if (num % 2 <= 1 && num % 2 > 0) { list.remove(num % 2 - 1); } if (num % 2 ==
		 * 0) { list.remove(1); }
		 * 
		 * return list.get(0);
		 */
	}

	private static ArrayList<String> selectionStarted(int num, int i, ArrayList<String> list) {
		ArrayList<String> dummy = new ArrayList<String>();
		ArrayList<String> list1 = list;

		if (num % i <= i - 1 && num % i > 0) {
			list.remove((num % i) - 1);
			for (String string : list1) {
				dummy.add(string);
			}
			list1.removeAll(list1);
			int j = (num % i) - 1;

			for (int i1 = 0; i1 < i - 1; i1++) {
				if (j < i - 1) {
					list1.add(dummy.get(j));
					j++;
				}
				if (j >= i - 1) {
					j -= i - 1;
				}
			}

		}

		if (num % i == 0) {
			list.remove(i - 1);
		}

		dummy.removeAll(dummy);

		return list1;
	}
}
