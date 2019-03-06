package com.springMvcController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class SimpleController {


	@ResponseBody
	@RequestMapping(value="/a",method=GET)
	public String helloworld() {
		return " 使用spring mvc进行编写";
		
	}
}
