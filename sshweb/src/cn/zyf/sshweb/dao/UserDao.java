package cn.zyf.sshweb.dao;

import java.util.List;

import cn.zyf.sshweb.model.User;

public interface UserDao extends BaseDao<User>{
	
	/**
	 * 获取对应数据表中的所有记录
	 */
	public List<User> getAll();
}
