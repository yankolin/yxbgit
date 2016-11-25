package com.snmp.daoImpl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snmp.dao.BaseDAOI;

@Repository("BaseDAOI")
public class BaseDAOImpl<T> implements BaseDAOI<T> {
	public SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	//指定自动装配，默认使用byType方法进行搜索
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	} 

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}


	public Serializable save(T o) {		
		Serializable serializable = getCurrentSession().save(o);
		return serializable;
	}

	public void delete(T o) {		
		this.getCurrentSession().delete(o);
	}

	public void update(T o) {
		this.getCurrentSession().update(o);
	}

	public void saveOrUpdate(T o) {	
		this.getCurrentSession().saveOrUpdate(o);
	}

	public List<T> find(String hql) {

		 Query querySelect = this.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
            List<T> list = (List<T>)querySelect.list();
		return list;
	}
	
	/**
	 * new 使用数据库表名
	 * @param hql
	 * @return
	 */
	public List<T> findSql(String hql) {

		 Query querySelect = this.getCurrentSession().createSQLQuery(hql);
			@SuppressWarnings("unchecked")
           List<T> list = (List<T>)querySelect.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object[] param, Integer page, Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String hql,  Integer page, Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		Query q = this.getCurrentSession().createQuery(hql);
		
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}
	
	/*new findSql*/
	@SuppressWarnings("unchecked")
    public List<T> findSql(String hql,  Integer page, Integer rows) {
        if (page == null || page < 1) {
            page = 1;
        }
        if (rows == null || rows < 1) {
            rows = 10;
        }
        Query q = this.getCurrentSession().createQuery(hql);
        
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }
	
	/*new find Create by chc 20160419*/
    @SuppressWarnings("unchecked")
    public List<T> findSql(String sql,  Integer page, Integer rows,Integer index) {
        if (page == null || page < 1) {
            page = 1;
        }
        if (rows == null || rows < 1) {
            rows = 10;
        }
        Query q = this.getCurrentSession().createSQLQuery(sql);
        
        return q.setFirstResult(index).setMaxResults(rows).list();
    }
    
	
	@SuppressWarnings("unchecked")
	public List<T> find(String hql, List<Object> param, Integer page,
			Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@SuppressWarnings("unchecked")
	public T get(Class<T> c, Serializable id) {
		T t = (T) this.getCurrentSession().get(c, id);
		return t;
	}

	public T get(String hql, Object[] param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	public T get(String hql, List<Object> param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	public Long count(String hql) {
		Long lon = (Long) this.getCurrentSession().createQuery(hql).uniqueResult();
		return lon;
	}

	/*new SQL count 20160418by chc**/
    public BigInteger countSql(String sql) {
        BigInteger lon = (BigInteger) this.getCurrentSession().createSQLQuery(sql).uniqueResult();
        return lon;
    }
	
	public Long count(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return (Long) q.uniqueResult();
	}

	public Long count(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return (Long) q.uniqueResult();
	}

	public Integer executeHql(String hql) {
		Integer integer = this.getCurrentSession().createQuery(hql).executeUpdate();
		return integer;
	}

	public Integer executeHql(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.executeUpdate();
	}

	public Integer executeHql(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.executeUpdate();
	}
}
