package site.share2u.etl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import site.share2u.etl.pojo.PageData;

public interface OptionMapper {
	 List<PageData> getOptionData(String sql);
}
