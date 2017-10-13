package site.share2u.echarts;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.github.abel533.echarts.Legend;
import com.github.abel533.echarts.Title;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Pie;
import com.github.abel533.echarts.series.Series;

import site.share2u.etl.util.CEcharts;

public class PieTest {
	@Test
	public void test2(){
		CEcharts cEcharts = new CEcharts();
		Title title = new Title();
		title.setText("张三的成绩");
		Legend legend = new Legend();
		List<Data> legendData = new ArrayList<>();
		legendData.add(new Data("语文"));
		legendData.add(new Data("数学"));
		legendData.add(new Data("英语"));
		legend.setData(legendData);
		//数据
		List<Series> series = new ArrayList<>();
		Series pie = new Pie();
		pie.setName("张三");
		List<JSONObject> serieData = new ArrayList<>();
		JSONObject j1 = new JSONObject();
		j1.put("name", "语文");
		j1.put("value", 10);
		JSONObject j2 = new JSONObject();
		j2.put("name", "数学");
		j2.put("value", 20);
		JSONObject j3 = new JSONObject();
		j3.put("name", "英语");
		j3.put("value", 30);
		serieData.add(j1);
		serieData.add(j2);
		serieData.add(j3);
		pie.setData(serieData );
		
		series.add(pie);
		GsonOption option = cEcharts.setPieOption(title, legend, series);
		System.out.println(option.toString());
	}
	
}
