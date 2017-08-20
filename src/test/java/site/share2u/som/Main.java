package site.share2u.som;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("F:\\test\\MySOM\\atest2.txt"));
		String s="";
		String[] split;
		TreeMap<String, Integer> count = new TreeMap<>();
		while ((s=br.readLine())!=null) {
			split = s.split(" ");
			if(count.get(split[5]) ==null){
				count.put(split[5], 1);
			}else{
				count.put(split[5], count.get(split[5])+1);
			};
		}
		br.close();
		StringBuilder sb = new StringBuilder();
		Set<String> keySet = count.keySet();
		//sb.append("[");
		for (String string : keySet) {
			String[] split2 = string.split("-");
			sb.append("[").append(split2[0]).append(",").append(split2[1]).append(",").append(count.get(string)).append("],");
			//sb.append(split2[0]).append(" ").append(split2[1]).append(";");
		}
		//sb.append("],");
		System.out.println(sb.toString());
	}
}
//[[[0,3,12],[1,2,24],[1,6,1],[1,8,6],[1,9,1],[2,3,4],[2,8,15],[3,6,6],[3,7,11],[4,0,5],[4,7,15],[5,4,1],[6,2,18],[6,4,7],[6,9,5],[7,3,4],[7,9,2],[9,7,13]]];