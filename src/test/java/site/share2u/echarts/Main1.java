package site.share2u.echarts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main1 {

	// 求解两个字符号的最长公共子串
	public static String maxSubstring(String strOne, String strTwo) {
		// 参数检查
		if (strOne == null || strTwo == null) {
			return null;
		}
		if (strOne.equals("") || strTwo.equals("")) {
			return null;
		}
		// 二者中较长的字符串
		String max = "";
		// 二者中较短的字符串
		String min = "";
		if (strOne.length() < strTwo.length()) {
			max = strTwo;
			min = strOne;
		} else {
			max = strTwo;
			min = strOne;
		}
		String current = "";
		// 遍历较短的字符串，并依次减少短字符串的字符数量，判断长字符是否包含该子串
		for (int i = 0; i < min.length(); i++) {
			for (int begin = 0, end = min.length() - i; end <= min.length(); begin++, end++) {
				current = min.substring(begin, end);
				if (max.contains(current)) {
					return current;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> ls = new ArrayList<>();
		String s="";
		try {
			while(ls.size()==2 ||(s=br.readLine())!= null){
				ls.add(s);
				if(ls.size()==2 )break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = maxSubstring(ls.get(0), ls.get(1));
		System.out.println(result.length());
	}
}
