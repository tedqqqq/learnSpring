package com.springMvcController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.springmvcservice.AddMessage;
@Controller
public class SimpleController {
	
	
	//使用接口进行业务的操作   解耦合
	private  AddMessage  addMesage;
	
	@Autowired
	public SimpleController(AddMessage addMesage) {
		super();
		this.addMesage = addMesage;
	}

	@ResponseBody
	@RequestMapping(value="/a",method=GET)
	public String helloworld() {
		return " 使用spring mvc进行编写";
		
	}
	
	@RequestMapping(value="/mainPage",method=GET)
	public String mainPage() {
		return "home";
	}
	
	//传统的在url中输入变量获取值
	@ResponseBody
	@RequestMapping(value="/getParm1",method=RequestMethod.GET)
	public  String  getTrainditionParm(@RequestParam(value="id") String id) {
		return  "showMessage   "+id;
	}
	
	//使用  /getParm2/XXX的方式进行数据的填充
	@ResponseBody
	@RequestMapping(value="/getParm2/{id}",method=RequestMethod.GET)
	public  String  getNewParm(@PathVariable String  id ) {
		System.out.println(addMesage.addAddress());
		return  "showMessage   "+id;
		//使用redirect进行url的重定向 此时返回的就是url的值了 
		//同样的forward:也会让controller直接进行url
		//		return "redirect:/a";
	}
	
	//使用  /getParm2/XXX的方式进行数据的填充
	@RequestMapping(value="/getParm3/{name}",method=RequestMethod.GET)
	public  String  getNewParm2(@PathVariable String  name ,Model model) {
		System.out.println(addMesage.addAddress());
		model.addAttribute("name"+ name);
		//使用redirect进行url的重定向 此时返回的就是url的值了 
		//同样的forward:也会让controller直接进行url
	    return "profile";
	}
	

}
