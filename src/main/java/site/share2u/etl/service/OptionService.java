package site.share2u.etl.service;

import java.util.List;
import java.util.Map;

import com.github.abel533.echarts.code.SeriesType;
import com.github.abel533.echarts.json.GsonOption;

import site.share2u.etl.pojo.Column;
import site.share2u.etl.pojo.ColumnType;

public interface OptionService {
	/**
	 * @param types 维度项的类型参数
	 * @param aggregationCount 度量项的个数
	 * @return 返回可以采用的图表类型
	 */
	public List<SeriesType> getTypes(List<Column> types,Map<String, Column> measures);
	
	
	/**
	 * @param dimension 维度项
	 * @param measures 度量项
	 * @param seriesType 图表类型
	 * @return 图表option
	 */
	public GsonOption getOption(String tableName,List<Column> dimension,Map<String,Column> measures,SeriesType seriesType);
}
