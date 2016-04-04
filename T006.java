package com.blyang;

/**
 * ZigZag 处理，寻找每个字符在的位置的规律，找循环
 * 要使用StringBuilder,不要使用 String
 */
public class T006 {
	public static String convert(String s, int numRows) {
		int len = s.length();
		
		if(len == 0 || numRows < 2 || len < numRows){
			return s;
		}
		
		StringBuilder res = new StringBuilder();
		
		int lagLen = 2*numRows - 2;
		
		for(int i=0; i<numRows; i++){
			for(int j=i; j<len; j+=lagLen){
				res.append( s.charAt(j) );
				
				//非首非尾处要再加一个
				if(i>0 && i<numRows-1){
					int tag = j + lagLen - 2*i;
					if(tag < len){
						res.append( s.charAt(tag) );
					}
				}
				
			}
		}
		
        return res.toString();
    }
	
	
	public static void main(String[] args) {
		System.out.println(convert("123456789", 4));
	}
	
}





