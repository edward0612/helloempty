package tw.org.iii.cma.dao;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import tw.org.iii.cma.domain.Csv;
import tw.org.iii.cma.domain.Emp;
@Repository
@Transactional
public class EmpDaoImpl implements EmpDaoInterface{
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	
	@Override
	public Emp findByNo(String empno) {
		if(empno != null) {
			return getSession().get(Emp.class, empno);
		}
		return null;
	}

	@Override
	public List<Emp> findAll() {
		Query query = getSession().createQuery("select * from Emp");
		return query.list();
	}

	@Override
	public Emp insert(Emp empVo) {
		if(empVo!=null && empVo.getEmpno()!=null) {
//			Query query = getSession().createQuery("from emp Emp where emp.empno = :empno");
			NativeQuery sqlQuery = getSession().createSQLQuery("select * from EMP where empno = :empno");
			sqlQuery.setParameter("empno", empVo.getEmpno());
			List<Emp> list = sqlQuery.list();
			if(list.size()==0) {
				getSession().save(empVo);
				return empVo;
			}
	
		}
		return null;
	}

	@Override
	public boolean delete(String empno) {
		if(empno!=null) {
			Emp emp = getSession().get(Emp.class, empno);
			if(emp!=null) {
				getSession().delete(emp);
				return true;
			}
		}
		return false;
	}

	@Override
	public Emp Update(String name, String email, String cellphone, Integer gender, String groups, Integer uuid,
			String empno) {
		if(empno!=null) {
			Emp emp = getSession().get(Emp.class, empno);
			if(emp!=null) {
				emp.setName(name);
				emp.setEmail(email);
				emp.setCellphone(cellphone);
				emp.setGender(gender);
				emp.setGroups(groups);
				emp.setUuid(uuid);
				return emp;
			}
		}
		return null;
	}

	@Override
	public List<Emp> findListByUuid(Integer uuid) {
		if(uuid!=null) {
			NativeQuery sqlQuery = getSession().createSQLQuery("select * from EMP where uuid = :uuid");
			return sqlQuery.setParameter("uuid", uuid).list();
		}
		return null;
	}

}
