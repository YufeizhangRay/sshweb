package cn.zyf.sshweb.dao;

public interface BaseDao<T> {

	/**
	 * 新增 T 到数据库中的对应数据表中
	 */
	public void add(T t);
	
	/**
	 * 通过 id 来删除对应 T 的记录
	 */
	public void delete(int id);
	
	/**
	 * 传入一个 T 对象
	 */
	public void update(T t);
	
	/**
	 * 通过 id 获取一条数据记录
	 */
	public T getOne(int id);
}
