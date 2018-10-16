package cn.zyf.sshweb.service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.zyf.sshweb.dao.BaseDaoImpl;

public class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	public BaseDaoImpl<T> baseDaoImpl;
	
	@Override
	public void add(T t) {
		baseDaoImpl.add(t);
	}

	@Override
	public void delete(int id) {
		baseDaoImpl.delete(id);
	}

	@Override
	public void update(T t) {
		baseDaoImpl.update(t);
	}

	@Override
	public T getOne(int id) {
		return baseDaoImpl.getOne(id);
	}

}
