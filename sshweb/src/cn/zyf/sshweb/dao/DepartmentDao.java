package cn.zyf.sshweb.dao;

import java.util.List;

import cn.zyf.sshweb.model.Department;

public interface DepartmentDao extends BaseDao<Department>{

	/**
	 * 获取对应数据表中的所有记录
	 */
	public List<Department> getAll();
}
