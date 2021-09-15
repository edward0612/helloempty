package tw.org.iii.cma.dao;

import java.util.List;

import tw.org.iii.cma.domain.Csv;



public interface CsvDaoInterface {
	public Csv findByPk(Integer uuid);
	public List<Csv> findAll();
	public Csv update(String filename,Integer uuid);
	public boolean delete(Integer uuid);
	public Csv insert(Csv csvVo);
	
	
}
