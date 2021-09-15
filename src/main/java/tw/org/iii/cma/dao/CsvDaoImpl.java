package tw.org.iii.cma.dao;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import tw.org.iii.cma.domain.Csv;

@Repository
@Transactional
public class CsvDaoImpl implements CsvDaoInterface{
	@PersistenceContext
	Session session;
	
	public Session getSession() {
		return session;
	}
	
	@Override
	public Csv findByPk(Integer uuid) {
		if(uuid!=null) {
			return getSession().get(Csv.class, uuid);
		}
		return null;
	}

	@Override
	public List<Csv> findAll() {
		Query query = getSession().createQuery("from Csv");
		return query.list();
	}

	@Override
	public Csv insert(Csv csvVo) {
		if(csvVo!=null) {
//			Csv csv = getSession().get(Csv.class, csvVo.getUuid());
//			if(csv ==null) {
				getSession().save(csvVo);
				return csvVo;
//			}
		}
		return null;
	}

	@Override
	public boolean delete(Integer uuid) {
		if(uuid != null) {
			Csv csv = getSession().get(Csv.class, uuid);
			if(csv !=null) {
				getSession().delete(csv);
				return true;
			}
		}
		return false;
	}


	@Override
	public Csv update(String filename, Integer uuid) {
		if(uuid!=null) {
			Csv csv = getSession().get(Csv.class, uuid);
			if(csv!=null) {
				csv.setFilename(filename);
				return csv;
			}
		}
		return null;
	}


}
