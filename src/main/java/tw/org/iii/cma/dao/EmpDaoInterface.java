package tw.org.iii.cma.dao;

import java.util.List;

import tw.org.iii.cma.domain.Emp;

public interface EmpDaoInterface {
	public Emp findByNo(String empno);
	public List<Emp> findAll();
	public Emp Update(String name,String email,String cellphone,Integer gender,String groups,Integer uuid,String empno);
	public Emp insert(Emp empVo);
	public boolean delete(String empno);
	
	public List<Emp> findListByUuid(Integer uuid);
}
