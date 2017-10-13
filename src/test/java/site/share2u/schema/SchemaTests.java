package site.share2u.schema;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;

import site.share2u.BaseJunit4Test;
import site.share2u.etl.pojo.Column;
import site.share2u.etl.pojo.Table;
import site.share2u.etl.service.SchemaService;


public class SchemaTests extends BaseJunit4Test{
	@Autowired
	private SchemaService schemaService;
	
	@Test
	public void getTables(){
		List<Table> list = schemaService.getTables();
		System.out.println(JSONArray.toJSONString(list));
	}
	@Test
	public void getColumns(){
		List<Column> list = schemaService.getColumns("test_tb_grade");
		System.out.println(JSONArray.toJSONString(list));
	}
}
