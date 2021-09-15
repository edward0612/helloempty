package tw.org.iii.cma.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.org.iii.cma.domain.Csv;
import tw.org.iii.cma.service.CsvService;
import tw.org.iii.cma.service.EmpService;

@Controller
@RequestMapping("uploadDone")
public class CsvController {

	@Autowired
	private EmpService empService;
	@Autowired
	private CsvService csvService;

	@RequestMapping
	public String uploadDone(Model model, MultipartFile file) {
		byte[] fileByte = null;
		try {
			BufferedInputStream bs = new BufferedInputStream(file.getInputStream());
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			fileByte = new byte[file.getInputStream().available()];

			bs.read(fileByte);
			bos.write(fileByte);

			String csv = bos.toString("UTF-8");
			
			Integer uuid = csvService.insertCsvTable(file.getOriginalFilename());
			empService.insertEmpTable(csv, uuid);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "uploadDone";
	}

	@ResponseBody
	@GetMapping(path = "loadData")
	public List<Csv> loadData(HttpServletResponse res) {
//		res.setHeader("Access-Control-Allow-Origin", "*");		
		return csvService.findAll();
	}
}
