package site.share2u.etl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.share2u.etl.dao.SchemaMapper;
import site.share2u.etl.pojo.Column;
import site.share2u.etl.pojo.Table;
import site.share2u.etl.service.SchemaService;

@Service("schemaService")
public class SchemaImpl implements SchemaService{
	@Autowired
	private SchemaMapper schemaDao;
	@Override
	public List<Table> getTables() {
		return schemaDao.getTables();
	}
	@Override
	public List<Column> getColumns(String tableName) {
		return schemaDao.getColumns(tableName);
	}

}
