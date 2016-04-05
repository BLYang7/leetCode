package com.blyang;
/**
 * 括号的匹配
 * 
 * 利用堆栈来处理，符合条件就弹出，否则push进去
 */
import java.util.HashMap;
import java.util.Stack;

public class T020 {
	public static boolean isValid(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
	 
			if (map.keySet().contains(curr)) {
				stack.push(curr);
			} else if (map.values().contains(curr)) {
				if ( ! stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop(); // 如果满足条件，stack最上面的字符弹出
				} else {
					return false; // 否则返回错误
				}
			}
		}
		
		// 当所有的字符都处理完毕之后，判断当前的stack是否为空。
		//如果为空，则说明所有都匹配，那么返回true
		//如果不为空，则说明有不匹配的点，返回false
		return stack.empty();
	}
	
	public static void main(String[] args) {
		T020 t = new T020();
		System.out.println(t.isValid("{{}[]()00}0"));
	}
	
}




