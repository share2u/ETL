package site.share2u.echarts;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.LineType;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Scatter;

public class TestEcharts {
	
	@Test
	public void testScatter(){
		//创建option
		GsonOption option = new GsonOption();
		option.title("散点图测试");
		
		//横纵轴
		ValueAxis valueAxis = new ValueAxis();
		valueAxis.splitLine().lineStyle().type(LineType.dashed);
		option.xAxis(valueAxis);
		option.yAxis(valueAxis);
		
		//数据
		Scatter scatter =new Scatter();
		Object[] data1 ={3,4,15,43};
		Object[] data2 ={4,2,20,91};
		Object[] data3 ={10,9,30,18};
		scatter.data(data1,data2,data3);
		Scatter scatter1 =new Scatter();
		Object[] data11 ={5,4,5,43};
		Object[] data12 ={5,2,5,91};
		Object[] data13 ={11,9,11,18};
		scatter1.data(data11,data12,data13);
		
		//散点的大小
		scatter1.symbolSize("function(data){return Math.sqrt(data[0])*10}");
		Scatter scatter3 =new Scatter();
		Object[] data31 ={2,4,15,43};
		Object[] data32 ={3,2,20,91};
		Object[] data33 ={8,9,30,18};
		scatter3.data(data31,data32,data33);
		option.series(scatter,scatter1,scatter3);
		System.out.println(option.toString());
		option.view();
	}
}
