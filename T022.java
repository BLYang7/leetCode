package com.blyang;
/**
 * 括号的组合方式
 *  
 * 给定括号的数量N，给出这些括号所有的组合方式
 * 例如 n = 3, 组合方式是: "((()))", "(()())", "(())()", "()(())", "()()()"
 */
import java.util.List;
import java.util.ArrayList;

public class T022 {
	
//  方法一：深度优先遍历
	public List<String> generateParenthesis(int n) {
	    ArrayList<String> result = new ArrayList<String>();
	    dfs(result, "", n, n);
	    return result;
	}
	
	/**
	 * left and right represents the remaining number of ( and ) that need to be added. 
	 * When left > right, there are more ")" placed than "(". Such cases are wrong and the method stops. 
	 */
	public void dfs(ArrayList<String> result, String s, int left, int right){
	    if(left > right)
	        return;
	 
	    if( left==0 && right==0 ){
	        result.add(s);
	        return;
	    }
	 
	    if(left>0){
	        dfs(result, s+"(", left-1, right);
	    }
	 
	    if(right>0){
	        dfs(result, s+")", left, right-1);
	    }
	}
	
	
//方法二：
//	public List<String> generateParenthesis(int n) {
//		ArrayList<String> result = new ArrayList<String>();
//		ArrayList<Integer> diff = new ArrayList<Integer>();
//	 
//		result.add("");
//		diff.add(0);
//	 
//		for (int i = 0; i < 2 * n; i++) {
//			ArrayList<String> temp1 = new ArrayList<String>();
//			ArrayList<Integer> temp2 = new ArrayList<Integer>();
//
//			for (int j = 0; j < result.size(); j++) {
//				String s = result.get(j);
//				int k = diff.get(j);
//	 
//				if (i < 2 * n - 1) {
//					temp1.add(s + "(");
//					temp2.add(k + 1);
//				}
//	 
//				if (k > 0 && i < 2 * n - 1 || k == 1 && i == 2 * n - 1) {
//					temp1.add(s + ")");
//					temp2.add(k - 1);
//				}
//			}
//	 
//			result = new ArrayList<String>(temp1);
//			diff = new ArrayList<Integer>(temp2);
//		}
//	 
//		return result;
//	}
	
	public static void main(String[] args) {
		T022 t = new T022();
		System.out.println(t.generateParenthesis(3));
	}
    
}






