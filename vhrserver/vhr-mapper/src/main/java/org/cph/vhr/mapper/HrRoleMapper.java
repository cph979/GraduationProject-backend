package org.cph.vhr.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.cph.vhr.model.HrRole;

public interface HrRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HrRole record);

    int insertSelective(HrRole record);

    HrRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HrRole record);

    int updateByPrimaryKey(HrRole record);

	Integer insertHrRole(@Param("hrid") Integer hrid, @Param("rids") Integer[] rids);

	@Delete("delete from hr_role where hrid = #{hrid}")
	void deleteByHrid(Integer hrid);
}