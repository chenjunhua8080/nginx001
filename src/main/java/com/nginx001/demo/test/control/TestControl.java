package com.nginx001.demo.test.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nginx001.demo.test.dao.ADao;
import com.nginx001.demo.test.entity.A;

@Controller
public class TestControl {
	
	@Autowired
	private ADao aDao;
	
	@GetMapping("/index")
	public String index() {
		return "main";
	}
	
	@GetMapping("/login/{name}")
	public String login(@PathVariable("name")String name,HttpServletRequest request) {
		System.out.println("001----name----"+name);
		request.getSession().setAttribute("name", name);
		return "redirect:/index";
	}
	
	public void login(int i) {
		System.out.println("login : " +i);
	}

	@GetMapping("/get/{id}")
	@ResponseBody
	public A login(@PathVariable("id")Integer id) {
		return aDao.getById(id);
	}
	
	@GetMapping("/list/a")
	public String login(HttpServletRequest request) {
		List<A> list = aDao.findAll();
		request.setAttribute("list", list);
		return "main";
	}
	
	@GetMapping("/slider")
	public String slider() {
		return "slider";
	}
	
}
