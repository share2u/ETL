package site.share2u.som;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;

public class FlagMain {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("E:\\eclipseWorkspace\\ETL\\atest4.txt"));
		String s="";
		String[] split;
		TreeMap<String, Integer> count = new TreeMap<>();
		while ((s=br.readLine())!=null) {
			split = s.split(" ");
			if(count.get(split[4]) ==null){
				count.put(split[4], 1);
			}else{
				count.put(split[4], count.get(split[4])+1);
			};
		}
		br.close();
		StringBuilder sb = new StringBuilder();
		Set<String> keySet = count.keySet();
		//sb.append("[");
		for (String string : keySet) {
			String[] split2 = string.split("-");
			sb.append("[").append(split2[1]).append(",").append(split2[2]).append(",").append(count.get(string)).append(",'").append(split2[0]).append("'").append("],");
			//sb.append(split2[0]).append(" ").append(split2[1]).append(";");
		}
		//sb.append("],");
		System.out.println(sb.toString());
	}
	//[A,4,0,2],[A,5,0,5],[A,6,0,10],[A,7,0,4],[A,8,0,4],[A,8,1,1],[A,9,0,23],[A,9,2,1],[B,0,3,5],[B,0,4,3],[B,0,5,1],[B,1,4,1],[B,2,4,2],[B,3,5,1],[B,3,6,2],[B,4,5,2],[B,4,6,1],[B,5,5,2],[B,5,6,1],[B,5,7,1],[B,6,5,1],[B,6,6,3],[B,6,7,1],[B,6,9,2],[B,7,6,1],[B,7,7,1],[B,8,6,1],[B,8,7,1],[B,8,9,1],[B,9,5,2],[B,9,6,4],[B,9,7,5],[B,9,8,4],[B,9,9,1],[C,0,7,2],[C,0,9,25],[C,1,7,2],[C,1,9,1],[C,2,9,2],[C,3,7,1],[C,3,9,4],[C,4,8,2],[C,4,9,3],[C,5,9,5],[C,6,9,1],[C,8,9,1],[C,9,9,1]

}
