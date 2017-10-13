package site.share2u.echarts;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.abel533.echarts.Legend;
import com.github.abel533.echarts.Title;
import com.github.abel533.echarts.axis.Axis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.AxisType;
import com.github.abel533.echarts.code.LineType;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.Series;

import edu.emory.mathcs.backport.java.util.Arrays;
import site.share2u.etl.util.CEcharts;

public class ScatterTest {
	@Test
	public void test1() throws InstantiationException, IllegalAccessException {
		CEcharts cEcharts = new CEcharts();
		String title = "title 标题";
		String xAxis = "x轴";
		String yAxis = "y轴";
		List<Data> legendData = new ArrayList<>();
		legendData.add(new Data("A"));
		legendData.add(new Data("B"));
		legendData.add(new Data("聚类中心"));

		List<List<List<Object>>> series = new ArrayList<>();
		List<List<Object>> serieA = new ArrayList<>();
		List<Object> aA1 = new ArrayList<>();
		aA1.add(3);
		aA1.add(0);
		aA1.add(33);
		aA1.add("A");
		serieA.add(aA1);
		List<Object> aA2 = new ArrayList<>();
		aA2.add(5);
		aA2.add(2);
		aA2.add(16);
		aA2.add("A");
		serieA.add(aA2);
		List<Object> aA3 = new ArrayList<>();
		aA3.add(2);
		aA3.add(1);
		aA3.add(6);
		aA3.add("A");
		serieA.add(aA3);
		List<Object> aA4 = new ArrayList<>();
		aA4.add(0);
		aA4.add(2);
		aA4.add(31);
		aA4.add("A");
		serieA.add(aA4);
		List<Object> aA5 = new ArrayList<>();
		aA5.add(1);
		aA5.add(4);
		aA5.add(46);
		aA5.add("A");
		serieA.add(aA5);
		List<Object> aA6 = new ArrayList<>();
		aA6.add(0);
		aA6.add(4);
		aA6.add(1);
		aA6.add("A");
		serieA.add(aA6);
		List<Object> aA7 = new ArrayList<>();
		aA7.add(0);
		aA7.add(0);
		aA7.add(20);
		aA7.add("A");
		serieA.add(aA7);
		List<Object> aA8 = new ArrayList<>();
		aA8.add(9);
		aA8.add(0);
		aA8.add(32);
		aA8.add("A");
		serieA.add(aA8);
		List<Object> aA9 = new ArrayList<>();
		aA9.add(7);
		aA9.add(1);
		aA9.add(29);
		aA9.add("A");
		serieA.add(aA9);

		series.add(serieA);

		List<List<Object>> serieB = new ArrayList<>();
		List<Object> aB1 = new ArrayList<>();
		aB1.add(7);
		aB1.add(9);
		aB1.add(59);
		aB1.add("B");
		serieB.add(aB1);
		List<Object> aB2 = new ArrayList<>();
		aB2.add(9);
		aB2.add(9);
		aB2.add(425);
		aB2.add("B");
		serieB.add(aB2);
		List<Object> aB3 = new ArrayList<>();
		aB3.add(2);
		aB3.add(9);
		aB3.add(44);
		aB3.add("B");
		serieB.add(aB3);
		List<Object> aB4 = new ArrayList<>();
		aB4.add(3);
		aB4.add(9);
		aB4.add(59);
		aB4.add("B");
		serieB.add(aB4);
		List<Object> aB5 = new ArrayList<>();
		aB5.add(6);
		aB5.add(9);
		aB5.add(89);
		aB5.add("B");
		serieB.add(aB5);
		List<Object> aB6 = new ArrayList<>();
		aB6.add(4);
		aB6.add(9);
		aB6.add(57);
		aB6.add("B");
		serieB.add(aB6);
		List<Object> aB7 = new ArrayList<>();
		aB7.add(1);
		aB7.add(9);
		aB7.add(18);
		aB7.add("B");
		serieB.add(aB7);
		List<Object> aB8 = new ArrayList<>();
		aB8.add(8);
		aB8.add(9);
		aB8.add(18);
		aB8.add("B");
		serieB.add(aB8);
		List<Object> aB9 = new ArrayList<>();
		aB9.add(8);
		aB9.add(9);
		aB9.add(48);
		aB9.add("B");
		serieB.add(aB9);
		List<Object> aB10 = new ArrayList<>();
		aB10.add(0);
		aB10.add(9);
		aB10.add(60);
		aB10.add("B");
		serieB.add(aB10);
		List<Object> aB11 = new ArrayList<>();
		aB11.add(0);
		aB11.add(8);
		aB11.add(3);
		aB11.add("B");
		serieB.add(aB11);
		List<Object> aB12 = new ArrayList<>();
		aB12.add(5);
		aB12.add(9);
		aB12.add(99);
		aB12.add("B");
		serieB.add(aB12);

		series.add(serieB);

		List<List<Object>> serie3 = new ArrayList<>();
		// [[7.6229916,8.644005],[1.9754099,5.3825135]]
		List<Object> a31 = new ArrayList<>();
		a31.add(6.4);
		a31.add(8.9);
		a31.add(10);
		a31.add("聚类中心");
		serie3.add(a31);
		List<Object> a32 = new ArrayList<>();
		a32.add(3.4);
		a32.add(1.4);
		a32.add(10);
		a32.add("聚类中心");
		serie3.add(a32);
		series.add(serie3);
//		Option option = cEcharts.setScatterOption(Scatter.class, null, title, legendData, xAxis, yAxis, series);
	//	System.out.println(option.toString());
	}

@Test
public void test2() throws InstantiationException, IllegalAccessException{
	CEcharts cEcharts = new CEcharts();
	Title title = new Title();
	title.setText("科目与学生");
	Legend legend = new Legend();
	List<Data> legendData = new ArrayList<>();
	legendData.add(new Data("张三"));
	legendData.add(new Data("李四"));
	legend.setData(legendData);
	
	List<Axis> xAxis = new ArrayList<>();
	List<Axis> yAxis = new ArrayList<>();
	ValueAxis xAxisx = new ValueAxis();
	ValueAxis yAxisy = new ValueAxis();
	xAxisx.name("科目").splitLine().lineStyle().type(LineType.dashed);
	yAxisy.name("分数").splitLine().lineStyle().type(LineType.dashed);
	xAxisx.setType(AxisType.category);//类目轴必须设置data
	xAxisx.setData(Arrays.asList(new String[]{"语文","数学","英语"}));
	xAxis.add(xAxisx);
	yAxis.add(yAxisy);
	
	List<Series> series = new ArrayList<>();
	Series scatter = new Line();
	scatter.setName("张三");
	List<List<Object>> serieData = new ArrayList<>();
	serieData.add(Arrays.asList(new Object[]{"语文",12}));
	serieData.add(Arrays.asList(new Object[]{"数学",6}));
	serieData.add(Arrays.asList(new Object[]{"英语",5}));
	scatter.setData(serieData );
	series.add(scatter);
	Series scatter1 = new Line();
	scatter1.setName("李四");
	List<List<Object>> serieData1 = new ArrayList<>();
	serieData1.add(Arrays.asList(new Object[]{"语文",4}));
	serieData1.add(Arrays.asList(new Object[]{"数学",3}));
	serieData1.add(Arrays.asList(new Object[]{"英语",2}));
	scatter1.setData(serieData1 );
	series.add(scatter1);
	GsonOption option = cEcharts.setScatterOption(title, legend, xAxis, yAxis,series );
	System.out.println(option.toString());
}
}