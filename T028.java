package com.blyang;
/**
 * 寻找一个字符串中与指定字符穿匹配的子字符串出现的位置
 * 
 * 这个在java里面有一个完整的封装函数，直接调用即可
 * 当然也可以自己写一个，不过效率可能不是很高
 */
public class T028 {
   
//	//方法一
//	public int strStr(String haystack, String needle) {
//        return haystack.indexOf(needle);
//    }
	
	
	public int strStr(String haystack, String needle){
	    if(haystack.length()<=0 && needle.length()>0){
	    	return -1;  
	    }
	    
        for(int i=0;i<=haystack.length()-needle.length();i++){  
            boolean flag = true;  
            for(int j=0;j<needle.length();j++){  
                if(haystack.charAt(i+j)!=needle.charAt(j)){  
                    flag = false;  
                    break;  
                }  
            }  
            if(flag){  
                return i;  
            }  
        }  
        
        return -1;  
	}
	
    public static void main(String[] args) {
		T028 t = new T028();
		System.out.println(t.strStr("a", "a"));
	}

}
