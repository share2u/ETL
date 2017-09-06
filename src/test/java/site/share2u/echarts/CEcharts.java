package site.share2u.echarts;

import java.util.ArrayList;
import java.util.List;

import com.github.abel533.echarts.Legend;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.Title;
import com.github.abel533.echarts.axis.Axis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.LineType;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Scatter;
import com.github.abel533.echarts.series.Series;

public class CEcharts {
	String[] icons ={"triangle","circle", "rect", "roundRect", "diamond", "pin", "arrow"}; 
	/*
	 * 标题，
	 * 
	 * 图例legend， data中的name需要同series中的数组中的对象的name一致,以及对于的图表类型icon 数据（x,y,大小,标签）
	 * 遍历多个serie
	 */
	
	/**
	 * 最
	 * @param title
	 * @param legendData
	 * @param xAxis
	 * @param yAxis
	 * @param series List<List<List<Object>>> series   x,y,大小，标签
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public  Option setScatterOption(Class<? extends Series> seriesClass,String title,List<Data> legendData,String xAxis,String yAxis,List<List<List<Object>>> series) throws InstantiationException, IllegalAccessException{
		//设置标题
		Title titleRes = new Title();
		titleRes.setText(title);
		//设置图列
		boolean iconFlag =false;
		Legend legendRes = new Legend();
		if(legendData != null){
			if(legendData.size()<=7)iconFlag=true;
			if(iconFlag){
				for (int i = 0; i < legendData.size(); i++) {
					legendData.get(i).setIcon(icons[i]);//设置内部图表
				}
			}
			legendRes.setData(legendData);
		}
		//设置x,y轴
		List<Axis> xAxisRes = new ArrayList<>();
		List<Axis> yAxisRes = new ArrayList<>();
		ValueAxis xAxisx = new ValueAxis();
		ValueAxis yAxisy = new ValueAxis();
		xAxisx.name(xAxis).splitLine().lineStyle().type(LineType.dashed);
		yAxisy.name(yAxis).splitLine().lineStyle().type(LineType.dashed);
		xAxisRes.add(xAxisx);
		yAxisRes.add(yAxisy);
		//设置数据
		List<Series> seriesRes = new ArrayList<>();
		 for (int i = 0; i < series.size(); i++) {
			 String name=legendData.get(i).getName();//第一个数据的标记
			 Series e =seriesClass.newInstance();
			 e.setName(name);//name,与图列一样
			 e.setData(series.get(i));//设置数据
			 if(iconFlag)e.setSymbol(icons[i]);//数据标记图形
			 e.setSymbolSize("function(data){return Math.sqrt(data[0])*10}");//设置标记大小
			 seriesRes.add(e);
		}
		return setOption(titleRes, legendRes, xAxisRes, yAxisRes, seriesRes);
	}
	
	
	/**
	 * @param title 标题
	 * @param legend 图列
	 * @param xAxis x轴
	 * @param yAxis y轴
	 * @param series 数据
	 * @return
	 */
	private Option setOption(Title title, Legend legend, List<Axis> xAxis, List<Axis> yAxis, List<Series> series) {
		// 创建option
		Option option = new GsonOption();
		//设置标题
		option.setTitle(title);
		//设置图列
		option.legend(legend);
		//设置x,y轴
		option.setxAxis(xAxis);
		option.setyAxis(yAxis);
		//设置数据
		option.series(series);
		//option.setSeries(series);
		return option;
	}
}
