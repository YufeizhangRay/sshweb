package cn.zyf.sshweb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import cn.zyf.sshweb.model.Department;
import cn.zyf.sshweb.model.User;
import cn.zyf.sshweb.service.DepartmentServiceImpl;

public class StringConvertUser implements Converter<String, User>{

	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;
	
	@Override
	public User convert(String source) {
		//id,username,password,dpt_id
		if(source!=null) {
			String[] arr = source.split(",");
			User user = new User();
			user.setId(Integer.parseInt(arr[0]));
			user.setUsername(arr[1]);//把字符串的 username 部分放到 User 对象的 username 属性里
			user.setPassword(arr[2]);
			Department dpt = departmentServiceImpl.getOne(Integer.parseInt(arr[3]));
			user.setDpt(dpt);
			return user;//完成类型转换后，返回user对象
		}
		return null;
	}

	
}
