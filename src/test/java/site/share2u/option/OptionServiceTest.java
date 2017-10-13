package site.share2u.option;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.code.SeriesType;
import com.github.abel533.echarts.json.GsonOption;

import site.share2u.BaseJunit4Test;
import site.share2u.etl.pojo.Column;
import site.share2u.etl.service.OptionService;

public class OptionServiceTest extends BaseJunit4Test {

	@Autowired
	private OptionService optionService;
	@Test
	public void testGetTypes() {
	}

	@Test
	public void testGetOption() {
		String tableName = "test_tb_grade";
		List<Column> dimension = new ArrayList<>();
		dimension.add(new Column("user_name","varchar"));
		dimension.add(new Column("course","varchar"));
		Map<String, Column> measures = new HashMap<>();
		measures.put("avg", new Column("score", "int"));
		List<SeriesType> types = optionService.getTypes(dimension, measures);
		if(types.size()>0){
			GsonOption option =optionService.getOption(tableName, dimension, measures, types.get(0));
			System.out.println(option.toString());
		}else{
			System.out.println("暂无图表可生成");
		}
	}

}
