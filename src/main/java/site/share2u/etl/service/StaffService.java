package site.share2u.etl.service;

import site.share2u.etl.pojo.Staff;

public interface StaffService {
	Staff selectByPrimaryKey(String staffId);
	int deleteByPrimaryKey(String staffId);
}
