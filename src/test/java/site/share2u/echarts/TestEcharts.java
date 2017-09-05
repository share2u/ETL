package site.share2u.echarts;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.AxisType;
import com.github.abel533.echarts.code.LineType;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Scatter;
import com.github.abel533.echarts.series.Series;

import site.share2u.kmeans.Kmeans;
import site.share2u.kmeans.KmeansImpl;
import site.share2u.kmeans.XYbean;

public class TestEcharts {

	@Test
	public void testScatter() {
		// 创建option
		GsonOption option = new GsonOption();
		// option.title("散点图测试");

		// 横纵轴
		ValueAxis valueAxisx = new ValueAxis();
		valueAxisx.name("序号").splitLine().lineStyle().type(LineType.dashed);
		// valueAxisx.type(AxisType.category);
		// valueAxisx.data("Iris Setosa","Iris Versicolour","Iris Virginica");
		option.xAxis(valueAxisx);
		ValueAxis valueAxisy = new ValueAxis();
		// 花萼长度,花萼宽度,花瓣长度,花瓣宽度
		valueAxisy.name("花瓣宽度").splitLine().lineStyle().type(LineType.dashed);
		option.yAxis(valueAxisy);

		Map<String, String> irons = new HashMap<String, String>();
		irons.put("Iris Setosa", "circle");
		irons.put("Iris Versicolour", "roundRect");
		irons.put("Iris Virginica", "triangle");
		// 数据
		Map<String, List<List<Object>>> irisData = getIrisData(3);
		Set<String> keySet = irisData.keySet();
		List<Series> series = new ArrayList<>();
		List<Data> legendDatas = new ArrayList<>();
		for (String key : keySet) {
			Series scatter = new Scatter();
			scatter.name(key);
			Data legendData = new Data();
			legendData.name(key).icon(irons.get(key));// 图例
			legendDatas.add(legendData);
			scatter.setData(irisData.get(key));
			scatter.symbol(irons.get(key));// 数据标记图形
			// scatter.symbolSize("function(data){return
			// Math.sqrt(data[0])*10}");
			series.add(scatter);
		}
		option.setSeries(series);
		option.legend().setData(legendDatas);
		option.legend().show();
		System.out.println("option=" + option.toString() + ";");
	}

	public Map<String, List<List<Object>>> getIrisData(Integer i) {
		Map<String, List<List<Object>>> map = new HashMap<String, List<List<Object>>>();

		File file = new File("e:/iris.data");
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String readLine = null;
			Integer count = 0;
			List<List<Object>> a1 = new ArrayList<>();
			List<List<Object>> a2 = new ArrayList<>();
			List<List<Object>> a3 = new ArrayList<>();
			String[] splitStr;
			while ((readLine = bufferedReader.readLine()) != null) {
				splitStr = readLine.split(",");
				switch (count / 50) {
				case 0:
					List<Object> arrayList1 = new ArrayList<Object>();
					/*
					 * for (String string : splitStr) {
					 * arrayList1.add(Double.parseDouble(string)); }
					 */
					arrayList1.add(count);
					arrayList1.add(Double.parseDouble(splitStr[i]));
					a1.add(arrayList1);
					break;
				case 1:
					List<Object> arrayList2 = new ArrayList<Object>();
					/*
					 * for (String string : splitStr) {
					 * arrayList2.add(Double.parseDouble(string)); }
					 */
					arrayList2.add(count);
					arrayList2.add(Double.parseDouble(splitStr[i]));
					a2.add(arrayList2);
					break;
				case 2:
					List<Object> arrayList3 = new ArrayList<Object>();
					/*
					 * for (String string : splitStr) {
					 * arrayList3.add(Double.parseDouble(string)); }
					 */
					arrayList3.add(count);
					arrayList3.add(Double.parseDouble(splitStr[i]));
					a3.add(arrayList3);
					break;
				}
				count++;
			}
			map.put("Iris Setosa", a1);
			map.put("Iris Versicolour", a2);
			map.put("Iris Virginica", a3);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * 获取欧式距离的下的聚类结果
	 * 
	 * @return
	 */
	public Map<String, List<List<Object>>> getESOM() {
		Map<String, List<List<Object>>> map = new HashMap<String, List<List<Object>>>();

		File file = new File("E:/eclipseWorkspace/ETL/somtest变异系数.txt");
		FileReader fileReader;
		try {
			fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String readLine = null;
			String[] split;
			TreeMap<String, Integer> count = new TreeMap<>();
			while ((readLine = bufferedReader.readLine()) != null) {
				split = readLine.split(" ");
				if (count.get(split[4]) == null) {
					count.put(split[4], 1);
				} else {
					count.put(split[4], count.get(split[4]) + 1);
				}
				;
			}

			Set<String> keySet = count.keySet();
			List<List<Object>> arrayList1 = new ArrayList<List<Object>>();
			List<List<Object>> arrayList2 = new ArrayList<List<Object>>();
			List<List<Object>> arrayList3 = new ArrayList<List<Object>>();
			for (String key : keySet) {
				String[] split2 = key.split("-");// a-x-y
				List<Object> a = new ArrayList<Object>();
				a.add(split2[1]);
				a.add(split2[2]);
				a.add(count.get(key));
				switch (split2[0]) {
				case "A":
					arrayList1.add(a);
					break;
				case "B":
					arrayList2.add(a);
					break;
				case "C":
					arrayList3.add(a);
					break;
				}
			}
			map.put("Iris Setosa", arrayList1);
			map.put("Iris Versicolour", arrayList2);
			map.put("Iris Virginica", arrayList3);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * som 结合kmeans
	 * @throws Exception
	 */
	@Test
	public void testSomKmeans() throws Exception {
		// 初始化一个Kmean对象，将k置为10
		Kmeans k = new Kmeans(2);
		ArrayList<float[]> dataSet = new ArrayList<float[]>();
		BufferedReader bufferedReader = new BufferedReader(
//				new FileReader(new File("E:/eclipseWorkspace/ETL/somtest加权欧式.txt")));
//		new FileReader(new File("E:/eclipseWorkspace/ETL/test09.txt")));
//		new FileReader(new File("E:/eclipseWorkspace/ETL/somtest未归一化.txt")));
//		new FileReader(new File("E:/eclipseWorkspace/ETL/somtest变异系数.txt")));
		new FileReader(new File("E:/spring/ETL/dacheng.txt")));

		String s = null;
		String[] split;
		ArrayList<String> arrayList = new ArrayList<String>();
		while ((s = bufferedReader.readLine()) != null) {
			split = s.split(" ");
			
			arrayList.add(split[11]);
		}
		StringBuilder s1=new StringBuilder();
		StringBuilder s2=new StringBuilder();
		Map<String,Integer> m =new HashMap<String,Integer>();
		for (Iterator<String> iterator = arrayList.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			if(string.startsWith("A") || string.startsWith("B")||string.startsWith("C")){
				string = string.substring(2);
			}
			if(m.keySet().contains(string)){
				m.put(string, m.get(string)+1);
			}else{
				m.put(string, 1);
			}
			String[] split2 = string.split("-");
			float[] f = new float[2];
			f[0] = Float.parseFloat(split2[0]);
			f[1] = Float.parseFloat(split2[1]);
			s1.append(f[0]+",");
			s2.append(f[1]+",");
			dataSet.add(f);
		}
//		System.out.println(m);
//		System.out.println(s1.toString());
//		System.out.println(s2.toString());
		
		/*
		 * 
	var data = [
    [[3,0,33,'Australia',1990],[7,9,59,'Australia',1990],[9,9,425,'Australia',1990],
    [2,9,44,'Australia',1990],[5,2,16,'Australia',1990],[3,9,59,'Australia',1990],
    [6,9,89,'Australia',1990],[2,1,6,'Australia',1990],[0,2,31,'Australia',1990],
    [1,4,46,'Australia',1990],[0,4,1,'Australia',1990],[4,9,57,'Australia',1990],
    [1,9,18,'Australia',1990],[0,0,20,'Australia',1990],[8,9,48,'Australia',1990],
    [0,9,60,'Australia',1990],[0,8,3,'Australia',1990],[5,9,99,'Australia',1990],
    [9,0,32,'Australia',1990],[7,1,29,'Australia',1990]
    ]
];

		 */
		
		// 设置原始数据集
		k.setDataSet(dataSet);
		// 执行算法
		k.execute();
		// 得到聚类结果
		ArrayList<ArrayList<float[]>> cluster = k.getCluster();
		
		// 查看结果
		for (int i = 0; i < cluster.size(); i++) {
			k.printDataArray(cluster.get(i), "cluster[" + i + "]");
		}
		ArrayList<float[]> center = k.getCenter();
		System.out.println(JSON.toJSONString(center));
	}

	/**
	 * 欧式距离下的聚类结果
	 */
	@Test
	public void testE() {
		// 创建option
		GsonOption option = new GsonOption();

		// 横纵轴
		ValueAxis valueAxisx = new ValueAxis();
		valueAxisx.name("x").splitLine().lineStyle().type(LineType.dashed);
		// valueAxisx.type(AxisType.category);
		// valueAxisx.data("Iris Setosa","Iris Versicolour","Iris Virginica");
		option.xAxis(valueAxisx);
		ValueAxis valueAxisy = new ValueAxis();
		// 花萼长度,花萼宽度,花瓣长度,花瓣宽度
		valueAxisy.name("y").splitLine().lineStyle().type(LineType.dashed);
		option.yAxis(valueAxisy);

		Map<String, String> irons = new HashMap<String, String>();
		irons.put("Iris Setosa", "circle");
		irons.put("Iris Versicolour", "roundRect");
		irons.put("Iris Virginica", "triangle");
		// 数据
		Map<String, List<List<Object>>> irisData = getESOM();
		Set<String> keySet = irisData.keySet();
		List<Series> series = new ArrayList<>();
		List<Data> legendDatas = new ArrayList<>();
		for (String key : keySet) {
			Series scatter = new Scatter();
			scatter.name(key);
			Data legendData = new Data();
			legendData.name(key).icon(irons.get(key));// 图例
			legendDatas.add(legendData);
			scatter.setData(irisData.get(key));
			scatter.symbol(irons.get(key));// 数据标记图形
			scatter.symbolSize("function(data){return Math.sqrt(data[2])*10}");
			scatter.label().emphasis().formatter("{c}").show(true);
			series.add(scatter);
		}
		option.setSeries(series);
		option.legend().setData(legendDatas);
		option.legend().show();
		System.out.println("option=" + option.toString() + ";");
	}
	
	@Test
	public void testSomKmeans1() throws Exception {
		int K = 3;  
		KmeansImpl xyCluster = new KmeansImpl();  
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(new File("E:/eclipseWorkspace/ETL/test09.txt")));

		String s = null;
		String[] split;
		ArrayList<String> arrayList = new ArrayList<String>();
		while ((s = bufferedReader.readLine()) != null) {
			split = s.split(" ");
			arrayList.add(split[4]);
		}
		for (Iterator<String> iterator = arrayList.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			String[] split2 = string.split("-");
			float[] f = new float[2];
			XYbean xYbean = new XYbean(Integer.parseInt(split2[1]), Integer.parseInt(split2[2]));
			xyCluster.addRecord(xYbean);
		}
		
		xyCluster.setK(K);
		long a = System.currentTimeMillis();  
	    List<List<XYbean>> cresult = xyCluster.clustering();  
	    List<XYbean> center = xyCluster.getClusteringCenterT();  
	    System.out.println(JSON.toJSONString(center));  
	    long b = System.currentTimeMillis();  
	    System.out.println("耗时：" + (b - a) + "ms");  
	}
	
	@Test
	public void testSomKmeans2() throws Exception {
		int K = 3;  
		KmeansImpl xyCluster = new KmeansImpl();  
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(new File("E:/eclipseWorkspace/ETL/dacheng.txt")));

		String s = null;
		String[] split;
		ArrayList<String> arrayList = new ArrayList<String>();
		while ((s = bufferedReader.readLine()) != null) {
			split = s.split(" ");
			arrayList.add(split[11]);
		}
		System.out.println(arrayList);
		for (Iterator<String> iterator = arrayList.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			if(string.startsWith("A") || string.startsWith("B")||string.startsWith("C")){
				string = string.substring(2);
			}
			String[] split2 = string.split("-");
			float[] f = new float[2];
			XYbean xYbean = new XYbean(Integer.parseInt(split2[0]), Integer.parseInt(split2[1]));
			xyCluster.addRecord(xYbean);
		}
		
		xyCluster.setK(K);
		long a = System.currentTimeMillis();  
	    List<List<XYbean>> cresult = xyCluster.clustering();  
	    List<XYbean> center = xyCluster.getClusteringCenterT();  
	    System.out.println(JSON.toJSONString(center));  
	    long b = System.currentTimeMillis();  
	    System.out.println("耗时：" + (b - a) + "ms"); 
	}

}
