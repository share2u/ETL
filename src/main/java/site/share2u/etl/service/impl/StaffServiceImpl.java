package site.share2u.etl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import site.share2u.etl.dao.StaffMapper;
import site.share2u.etl.pojo.Staff;
import site.share2u.etl.service.StaffService;

@Service("staffService")
public class StaffServiceImpl implements StaffService {
	@Resource
	private StaffMapper staffDao;
	public Staff selectByPrimaryKey(String staffId) {
		return  staffDao.selectByPrimaryKey(staffId);
	}
	public int deleteByPrimaryKey(String staffId) {
		return staffDao.deleteByPrimaryKey(staffId);
	}

}
