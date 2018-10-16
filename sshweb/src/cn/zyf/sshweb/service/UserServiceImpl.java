package cn.zyf.sshweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.zyf.sshweb.dao.UserDao;
import cn.zyf.sshweb.model.User;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getAllUsers() {
		return userDao.getAll();
	}

}
