package cn.zyf.sshweb.service;

public interface BaseService<T> {

	public void add(T t);
	
	public void delete(int id);
	
	public void update(T t);
	
	public T getOne(int id);
}
