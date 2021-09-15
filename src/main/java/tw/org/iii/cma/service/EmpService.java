package tw.org.iii.cma.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.org.iii.cma.dao.EmpDaoInterface;
import tw.org.iii.cma.domain.Emp;

@Service
@Transactional
public class EmpService {
	@Autowired
	private EmpDaoInterface dao;
	
	public void insertEmpTable(String file,Integer uuid) {
		String[] split = file.split("\n");
		
		for (int i = 1; i < split.length; i++) {
			String[] split2 = split[i].split(",");
			Emp empVo = new Emp();
			empVo.setEmpno(split2[0]);
			empVo.setName(split2[1]);
			empVo.setEmail(split2[2]);
			empVo.setCellphone(split2[3]);
			empVo.setGender(split2[4].equals("男")?0:1);
			empVo.setGroups(split2[5]);
			empVo.setUuid(uuid);
			dao.insert(empVo);
		}
	}
	
	public List<Emp> findListByUuid(Integer uuid){
		return dao.findListByUuid(uuid);
	}
}
