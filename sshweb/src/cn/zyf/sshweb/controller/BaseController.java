package cn.zyf.sshweb.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import cn.zyf.sshweb.web.MyDoubleEditor;

public class BaseController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);//日期格式遵守严格格式：1999-10-33 日期不顺延
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
		//自定义的编辑器需要注册在 binder 里
	//	binder.registerCustomEditor(Double.class, new MyDoubleEditor());
	}
}
