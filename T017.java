package com.blyang;
/**
 * 寻找串字符的所有字符的组合方式
 * 
 * 深度优先遍历DFS, 使用迭代
 * 
 */
import java.util.List;
import java.util.ArrayList;

public class T017 {
	
	private StringBuilder word;  
	List<String> ret = new ArrayList<String>();  
	
    private String[] alpha = new String[] {  
            " ",  
            "1", "abc", "def",  
            "ghi", "jkl", "mno",  
            "pqrs", "tuv", "wxyz"  
    };  
  
    private void dfs(List<String> res, String digits, int cur) {  
    	//终止条件，当current的数字大于等于当前字符的长度时，表明到底了
        if (cur >= digits.length()) {  
            res.add(word.toString());  
        }
        //如果没有到底，就继续向下加上去
        else {  
            for (int i = 0; i < alpha[digits.charAt(cur) - '0'].length(); ++i) {  
            	// 加上cur数字的第i个字符之后，current数字加一继续向下遍历，这里用迭代
                word.append(alpha[digits.charAt(cur) - '0'].charAt(i));  
                dfs(res, digits, cur + 1);  
                
                //删除最后一个字符，用于最后一个字符的添加和组合
                word.deleteCharAt(word.length() - 1);  
            }  
        }  
    }  
  
    public List<String> letterCombinations(String digits) {  
        if(digits.equals("") || digits == null){
        	return ret;
        }
        word = new StringBuilder();  
        dfs(ret, digits, 0);  
        return ret;  
    }  
    
    public static void main(String[] args) {
    	
    	T017 t = new T017();
		System.out.println(t.letterCombinations("23"));
	}
    
    
}
