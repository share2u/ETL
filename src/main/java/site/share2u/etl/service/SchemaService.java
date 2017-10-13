package site.share2u.etl.service;

import java.util.List;

import site.share2u.etl.pojo.Column;
import site.share2u.etl.pojo.Table;

public interface SchemaService {
	/**获取表的列表
	 * @return
	 */
	List<Table> getTables();
	/**
	 * 根据表名获取字段
	 * @param tableName
	 * @return
	 */
	List<Column> getColumns(String tableName);
}
