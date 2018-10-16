package cn.zyf.sshweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import cn.zyf.sshweb.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		String hql = "from User";
		Session session = getSession();
		Query<User> query = session.createQuery(hql);
		return query.list();
	}

}
