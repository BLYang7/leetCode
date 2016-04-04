package com.blyang;

public class T010 {

    public boolean isMatch(String s, String p) {
    	
//    	方法一，可读性差一些的方案 
//        if(p.length() == 0)
//            return s.length() == 0;
// 
//        //p's length 1 is special case    
//        if(p.length() == 1 || p.charAt(1) != '*'){
//            if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
//                return false;
//            return isMatch(s.substring(1), p.substring(1));    
// 
//        }else{
//            int len = s.length();
// 
//            int i = -1; 
//            while(i<len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
//                if(isMatch(s.substring(i+1), p.substring(2)))
//                    return true;
//                i++;
//            }
//            return false;
//        }
//        
       
    	
    	
    	// 方法二，高效率的操作
		if(p.length() == 0){
			return s.length() == 0;
		}
		
		boolean[][] res = new boolean[s.length() + 1][p.length() + 1];
		res[0][0] = true;
		
		//
		for (int j = 0; j < p.length(); j++) {
			
			if (p.charAt(j) == '*') {
				if (j > 0 && res[0][j - 1])
					res[0][j + 1] = true;
				if (j < 1)
					continue;
				if (p.charAt(j - 1) != '.') {
					for (int i = 0; i < s.length(); i++) {
						if (res[i + 1][j] || j > 0 && res[i + 1][j - 1]
								|| i > 0 && j > 0 && res[i][j + 1]
								&& s.charAt(i) == s.charAt(i - 1)
								&& s.charAt(i - 1) == p.charAt(j - 1))
							res[i + 1][j + 1] = true;
					}
				} else {
					int i = 0;
					while (j > 0 && i < s.length() && !res[i + 1][j - 1]
							&& !res[i + 1][j])
						i++;
					for (; i < s.length(); i++) {
						res[i + 1][j + 1] = true;
					}
				}
				
			} else {
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
						res[i + 1][j + 1] = res[i][j];
				}
			}
		}
		return res[s.length()][p.length()];
		
		
		
//		方案三，可读性比较高
//		// base case
//		if (p.length() == 0) {
//			return s.length() == 0;
//		}
//	 
//		// special case
//		if (p.length() == 1) {
//	 
//			// if the length of s is 0, return false
//			if (s.length() < 1) {
//				return false;
//			}
//	 
//			//if the first does not match, return false
//			else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
//				return false;
//			}
//	 
//			// otherwise, compare the rest of the string of s and p.
//			else {
//				return isMatch(s.substring(1), p.substring(1));
//			}
//		}
//	 
//		// case 1: when the second char of p is not '*'
//		if (p.charAt(1) != '*') {
//			if (s.length() < 1) {
//				return false;
//			}
//			if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
//				return false;
//			} else {
//				return isMatch(s.substring(1), p.substring(1));
//			}
//		}
//	 
//		// case 2: when the second char of p is '*', complex case.
//		else {
//			//case 2.1: a char & '*' can stand for 0 element
//			if (isMatch(s, p.substring(2))) {
//				return true;
//			}
//	 
//			//case 2.2: a char & '*' can stand for 1 or more preceding element, 
//			//so try every sub string
//			int i = 0;
//			while (i<s.length() && (s.charAt(i)==p.charAt(0) || p.charAt(0)=='.')){
//				if (isMatch(s.substring(i + 1), p.substring(2))) {
//					return true;
//				}
//				i++;
//			}
//			return false;
//		}
		
	}
    
    
    public static void main(String[] args) {
    	T010 t = new T010();
		System.out.println(t.isMatch("ab", ".*") );
	}
    
}
