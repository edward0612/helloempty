package tw.org.iii.cma.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.org.iii.cma.domain.Emp;
import tw.org.iii.cma.service.EmpService;

@Controller
@RequestMapping("upload")
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@RequestMapping
	public String initPage(){
		return "upload";
	}
	
	@ResponseBody
	@GetMapping(path="queryData")
	public List<Emp> queryData(Integer uuid,HttpServletResponse res) {
//		res.setHeader("Access-Control-Allow-Origin", "*");
		return empService.findListByUuid(uuid);
	}
}
