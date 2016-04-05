package com.blyang;

/**
 * 阿拉伯数字转罗马数字
 * 
 * 罗马数字：
 * 1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
 * 10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
 * 100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
 * 1000~3000: {"M", "MM", "MMM"}.
 */

public class T012 {

	public String intToRoman(int num) {
		String[][] roman = {
				{ "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
				{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
				{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
				{ "", "M", "MM", "MMM" } 
			};
		String ret = "";
		
		int digit = 0;
		while (num != 0) {
			int remain = num % 10;
			ret = roman[digit][remain] + ret;
			digit++;
			num /= 10;
		}
		return ret;
	}
	
	
	public static void main(String[] args) {
		T012 t = new T012();
		System.out.println(t.intToRoman(601));
	}

}






