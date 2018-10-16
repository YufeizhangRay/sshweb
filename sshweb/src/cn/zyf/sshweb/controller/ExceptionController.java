package cn.zyf.sshweb.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler({ArithmeticException.class})
	public ModelAndView handleArithmeticException(Exception ex) {
		System.out.println("发生了异常ex:"+ex);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		modelAndView.addObject("exception", ex.getMessage());
		return modelAndView;
	}
	
	@ExceptionHandler({RuntimeException.class})
	public ModelAndView handleRuntimeException(Exception ex) {
		System.out.println("发生了异常ex:"+ex);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		modelAndView.addObject("exception", ex.getMessage());
		return modelAndView;
	}
}
