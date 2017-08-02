/*package site.share2u.etl.staff;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import site.share2u.etl.pojo.Staff;
import site.share2u.etl.service.StaffService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestStaff {
	private static Logger logger = Logger.getLogger(TestStaff.class);

	@Resource
	private StaffService staffService = null;

	@Test
	public void testSelect() {
		Staff staff = staffService.selectByPrimaryKey("000135");
		System.out.println(JSON.toJSON(staff));
	}
}



*/