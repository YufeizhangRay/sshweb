package cn.zyf.sshweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zyf.sshweb.dao.DepartmentDao;
import cn.zyf.sshweb.model.Department;

@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	public List<Department> getAllDepartments() {
		return departmentDao.getAll();
	}

}
