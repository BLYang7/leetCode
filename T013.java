package com.blyang;

/**
 * 罗马数字转阿拉伯数字
 * 
 * 罗马数字：
 * 1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
 * 10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
 * 100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
 * 1000~3000: {"M", "MM", "MMM"}.
 * 
 */


public class T013 {
    public int romanToInt(String str) {
    	char[] s = str.toCharArray();
    	int ret = toNumber(s[0]);  
    	
        for (int i = 1; i < str.length(); i++) {  
            if (toNumber(s[i - 1]) < toNumber(s[i])) {  
                ret += toNumber(s[i]) - 2 * toNumber(s[i - 1]);  
            } else {  
                ret += toNumber(s[i]);  
            }
        }
        
        return ret;  
    }

    private int toNumber(char ch) {  
        switch (ch) {  
            case 'I': return 1;  
            case 'V': return 5;  
            case 'X': return 10;  
            case 'L': return 50;  
            case 'C': return 100;  
            case 'D': return 500;  
            case 'M': return 1000;  
        }  
        return 0;  
    } 
    
    
    public static void main(String[] args) {
		T013 t = new T013();
		System.out.println(t.romanToInt("IV"));
	}
    
}





