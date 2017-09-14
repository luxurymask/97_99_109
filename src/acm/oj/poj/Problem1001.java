package acm.oj.poj;

import java.util.Scanner;

public class Problem1001 {
	public static String floatMultiply(String num1, String num2){
		String[] array1 = num1.split("\\.");
		String[] array2 = num2.split("\\.");
		int spot = array1[1].length() + array2[1].length();
		String newNum1 = array1[0] + array1[1];
		String newNum2 = array2[0] + array2[1];
		char[] charArray1 = newNum1.toCharArray();
		char[] charArray2 = newNum2.toCharArray();
		int[] result = new int[charArray1.length + charArray2.length];
		for(int i = charArray1.length - 1;i >= 0;i--){
			for(int j = charArray2.length - 1;j >= 0;j--){
				result[charArray1.length + charArray2.length - 2 - i - j] += Character.getNumericValue(charArray1[i]) * Character.getNumericValue(charArray2[j]);
			}
		}
		StringBuffer sb = new StringBuffer();
		int cache = 0;
		for(int i = 0;i < result.length;i++){
			result[i] += cache;
			cache = result[i] / 10;
			result[i] %= 10;
			sb.insert(0, result[i]);
			if(i == spot - 1) sb.insert(0, ".");
		}
		if(sb.charAt(0) == '0' && sb.charAt(1) != '.'){
			sb.delete(0, 1);
		}
		
		return sb.toString();
	}
	
	public static String power(String num, int n){
		if(n == 0) return "1";
		if(n == 1) return num;
		if(n == 2) return floatMultiply(num, num);
		if((n & 1) == 0){
			return power(power(num, n >> 1), 2);
		}else{
			return floatMultiply(power(power(num, n >> 1), 2), num);
		}
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int n = in.nextInt();
		
		String result = power(s, n);
		int i = result.length() - 1;
		for(;i >= 0 && result.charAt(i) == '0';i--){
			
		}
		result = result.substring(0, i + 1);
		System.out.println(result);
	}
}
