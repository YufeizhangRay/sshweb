package cn.zyf.sshweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import cn.zyf.sshweb.model.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getAll() {
		String hql = "from Department";
		Session session = getSession();
		Query<Department> query = session.createQuery(hql);
		return query.list();
	}

}
