package site.share2u.etl.dao;

import java.util.List;

import site.share2u.etl.pojo.Column;
import site.share2u.etl.pojo.Table;

public interface SchemaMapper {
	List<Table> getTables();
	List<Column> getColumns(String tableName);
}
