package tw.org.iii.cma.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.org.iii.cma.dao.CsvDaoInterface;
import tw.org.iii.cma.domain.Csv;

@Service
@Transactional
public class CsvService {
	@Autowired
	private CsvDaoInterface dao;
	
	public Integer insertCsvTable(String filename) {
		Csv csvVo = new Csv();
		csvVo.setFilename(filename);
		Csv insert = dao.insert(csvVo);
		return insert.getUuid();
	}
	
	public List<Csv> findAll(){
		return dao.findAll();
	}
	
}
