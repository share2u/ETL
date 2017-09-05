package site.share2u.som0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MathUtil {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("e:/dacheng.csv"))));
		String str=null;
		List<? super List<Double>> dataRow = new ArrayList<>();
		while((str=br.readLine())!= null){
			String[] split = str.split(",");
			List<Double> al = new ArrayList<Double>();
			try {
				for (int i = 0; i < split.length; i++) {
					al.add(Double.parseDouble(split[i]));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			dataRow.add(al);
		}
		List<? super List<Double>> dataCol = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			List<Double> cl = new ArrayList<>();
			for (Iterator iterator = dataRow.iterator(); iterator.hasNext();) {
				List<Double> object =(List<Double>) iterator.next();
				cl.add(object.get(i));
			}
			dataCol.add(cl);
			
		}
		for (int i = 0; i < dataCol.size(); i++) {
			List<Double> object = (List<Double>) dataCol.get(i);
			Double[] x =new Double[object.size()];
			System.out.println("第"+i+"维度变异系数："+bianyixishu(object.toArray(x)));
		}
	}

	public static double bianyixishu(Double[] x) {
		System.out.println("标准差"+StandardDiviation(x));
		System.out.println("均值"+mean(x));
		return StandardDiviation(x) / mean(x);
	}

	public static double StandardDiviation(Double[] x) {
		int m = x.length;
		double sum = 0;
		for (int i = 0; i < m; i++) {// 求和
			sum += x[i];
		}
		double dAve = sum / m;// 求平均值
		double dVar = 0;
		for (int i = 0; i < m; i++) {// 求方差
			dVar += (x[i] - dAve) * (x[i] - dAve);
		}
		return Math.sqrt(dVar / m);
	}

	public static double mean(Double[] x) {
		int m = x.length;
		double sum = 0;
		for (int i = 0; i < m; i++) {// 求和
			sum += x[i];
		}
		double dAve = sum / m;// 求平均值
		return dAve;
	}
}
