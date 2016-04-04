package com.blyang;
/**
 * 最长回文子字符串
 * 		1、中心扩展法：以某一点为中心，向两边扩展，轮询确认这个点的两边的最长的回文子字符串
 * 		2、动态规划法：用一个二维数组，palin[i][j]表示从i到j到字符组成的子串是回文串
 */

public class T005 {

	/**
	 * 中心扩展法
	 */
	public String longestPalindrome(String s) {
        
		if(s == null || s.length() == 0){
			return "";
		}
		
		int maxLen = 0;
		String res = "";
		
		for(int i=0; i<2*s.length() - 1; i++){
			int left = i/2;
			int right = i/2;
			
			if(i%2 == 1){
				right ++;
			}
			
			String str = lengthOfPalindrom(s, left, right);
			
			if(maxLen < str.length()){
				maxLen = str.length();
				res = str;
			}
		}
		return res;
    }
	
	private String lengthOfPalindrom(String s, int left, int right){
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
			left --;
			right ++;
		}
		return s.substring(left +1, right);
	}
	
	
	
	/**
	 *  动态规划法
	 * @param args
	 */
	public String longestPalindromeDynamic(String s){
		if(s == null || s.length() == 0){
			return "";
		}
		
		boolean[][] palin = new boolean[s.length()][s.length()];
		String res = "";
		int maxLen = 0;
		
		for(int i=s.length() - 1; i>=0; i--){
			for(int j=i; j<s.length(); j++){
				if(s.charAt(i) == s.charAt(j) && (j-i <=2 || palin[i+1][j-1])){
					palin[i][j] = true;
					
					if(maxLen < j-i+1){
						maxLen = j-i+1;
						res = s.substring(i, j+1);
					}
				}
			}
		}
		
		return res;
	}
	
	
	
	public static void main(String[] args) {
		T005 t = new T005();
		System.out.println(t.longestPalindrome("1234566543212312242"));
		System.out.println(t.longestPalindromeDynamic("1234566543212312242"));
	}

	
}









