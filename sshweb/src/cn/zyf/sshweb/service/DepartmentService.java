package cn.zyf.sshweb.service;

import java.util.List;

import cn.zyf.sshweb.model.Department;

public interface DepartmentService extends BaseService<Department> {

	public List<Department> getAllDepartments();
}
