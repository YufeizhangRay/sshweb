package cn.zyf.sshweb.service;

import java.util.List;

import cn.zyf.sshweb.model.User;

public interface UserService extends BaseService<User> {

	public List<User> getAllUsers();
}
