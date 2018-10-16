package cn.zyf.sshweb.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.zyf.sshweb.model.Department;
import cn.zyf.sshweb.model.User;
import cn.zyf.sshweb.service.DepartmentServiceImpl;
import cn.zyf.sshweb.service.UserServiceImpl;

@Controller
public class UserController extends BaseController{

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;
	
	/**
	 * REST 风格
	 * url: xxxxx/users   get   获取所有 users
	 */
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String getAllUsers(Model model) {
		List<User> users = userServiceImpl.getAllUsers();
		model.addAttribute("users", users);
		return "users";
	}
	
	/**
	 * 符合 REST 风格: /user/1 get 获得一条 user 记录
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public String updateUserView(@PathVariable("id") Integer id, Model model) {
		if(id!=null) {
			User user = userServiceImpl.getOne(id);
			model.addAttribute("user", user);
		}
		List<Department> dpts = departmentServiceImpl.getAllDepartments();
		model.addAttribute("dpts", dpts);
		
		return "updateUserView";
	}
	
	
	//自动执行，代替传统做法
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id,
			@RequestParam(value="dpt.id",required=false) Integer dptid, Model model) {
		if(id!=null&&dptid!=null) {
			User user = userServiceImpl.getOne(id);
			Department dpt = departmentServiceImpl.getOne(dptid);
			user.setDpt(dpt);
			model.addAttribute("user", user);
		}
	}
	
	@RequestMapping(value="/user",method=RequestMethod.PUT)
	public String updateUser(@ModelAttribute(value="user") User user) {
		System.out.println("====user:"+user);
//		//传统的做法
//		//1.通过user对象中的id值，获取修改前的数据库中的这条记录
//		//通过传过来的dpt的id值获取对象
//		User user2 = userServiceImpl.getOne(user.getId());
//		Department dpt2 = departmentServiceImpl.getOne(user.getDpt().getId());
//		//2.将传过来的user对象覆盖从数据库取出的对象
//		user2.setPassword(user.getPassword());
//		user2.setDpt(dpt2);
//		System.out.println("====user2:"+user2);
		
		userServiceImpl.update(user);
		//有一个问题需要解决，之后才能使用 userServiceImpl 的方法修改
		//userServiceImpl.update(user);
		
		return "redirect:/users";
	}
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public String addUserView(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("dpts", departmentServiceImpl.getAllDepartments());
		return "addUserView";
	}
	
	/**
	 * 符合 REST 风格: /user post 新增加一条 user 记录
	 */
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String addUser(@Valid User user,BindingResult error,Model model) {
		if(error.getErrorCount()>0) {
			System.out.println("某些数据不符合数据有效性校验！");
			for(FieldError fe:error.getFieldErrors()) {
				System.out.println("==="+fe.getField()+":"+fe.getDefaultMessage());
			}
			model.addAttribute("dpts", departmentServiceImpl.getAllDepartments());
			return "addUserView";
		}
		userServiceImpl.add(user);
		return "redirect:/users";
	}
	
	/**
	 * 符合 REST 风格: /user/1 delete 删除一条 user 记录
	 */
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable("id") Integer id) {
		if(id!=null) {
			userServiceImpl.delete(id);
		}
		return "redirect:/users";
	}
	
	/**
	 * 自定义类型转换
	 */
	@RequestMapping(value="convertUser",method=RequestMethod.POST)
	public String convertUser(User user) {
		System.out.println("用了自定义的类型转换器转换出来的user对象："+user);
		//userServiceImpl.add(user);
		return "redirect:users";
	}
	
	@RequestMapping("/jsonTestView")
	public String jsonTestView() {
		return "jsonTestView";
	}
	
	//傻瓜法
	@ResponseBody
	@RequestMapping(value="/testjson2",method=RequestMethod.POST)
	public List<User> testjson2(){
		List<User> users = userServiceImpl.getAllUsers();
		return users;
	}
	
	//老土法
	@RequestMapping(value="/testjson1",method=RequestMethod.POST)
	public void testjson1(HttpServletResponse resp,PrintWriter out) throws JsonProcessingException {
		resp.setContentType("application/json;charset=utf-8");
		resp.setHeader("pragma", "no-cache");
		resp.setHeader("cache-control", "no-cache");
		List<User> users = userServiceImpl.getAllUsers();
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(users);
		System.out.println("====json 格式的所有用户信息:"+jsonStr);
		out.print(jsonStr);//向浏览器相应json格式的数据
	}
	
	@ResponseBody
	@RequestMapping(value="/testConvert",method=RequestMethod.POST)
	public String testConvert(@RequestBody String text) {
		System.out.println(text);
		return "Ray"+new Date();//跟视图没关系，直接响应给浏览器显示
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(@RequestParam("mark") String mark,
			@RequestParam("file") MultipartFile file,
			HttpServletRequest request) throws IllegalStateException, IOException {
		System.out.println("===== mark:"+mark);
		if(!file.isEmpty()) {  
			//保存文件的绝对路径
			String path = request.getServletContext().getRealPath("/resouces/uploadfiles");
			//拿到被传上来文件的原文件名
			String fileName = file.getOriginalFilename();
			File file2 = new File(path,fileName);
			System.out.println("====file2:"+file2);
			if(!file2.getParentFile().exists()) {
				file2.getParentFile().mkdirs();//若路径不存在则创建				
			}
			file.transferTo(file2);//写进硬盘里
			System.out.println("成功");
		}else {
			System.out.println("失败");
		}
		return "redirect:/users";
	}
	
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(@RequestParam("fileName") String fileName,
			HttpServletRequest request) throws IOException {
		//用 request 拿到保存文件的绝对路径
		String path = request.getServletContext().getRealPath("/resouces/uploadfiles");
		File file = new File(path+File.separator+fileName);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", new String(fileName.getBytes("UTF-8"),"ios-8859-1"));
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
    
	@RequestMapping("/testError")
	public String testError(@RequestParam("i") int i) {
		System.out.println(10/i);
		return "redirect:/users";
	}
	
}
