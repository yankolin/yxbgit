package com.snmp.test;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSSH {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	private ApplicationContext ctx = null;
	@Test
	public void testDataSource() throws SQLException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
		 //Configuration configuration = new Configuration().configure();
	      //  SessionFactory sessionFactory = configuration.buildSessionFactory();
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		//Session session = //HibernateUtil.getSessionFactory().getCurrentSession();

		//session.beginTransaction();
		Session session =  sessionFactory.getCurrentSession();//.openSession();
		Transaction tx = session.beginTransaction();
		
		//数据库的操作
//		//User users = new User("ruiri");
//		User user = new User();
//		user.setUsername("ruiri");
//		session.delete(user);
		
		
		 //-------------------------------------------------------------
        // Delete
        //-------------------------------------------------------------
        String hqlDelete = "delete user_accountSnmpYanko where username=:username";
        Query queryDelete = session.createQuery(hqlDelete);
        queryDelete.setParameter("username", "ruiri");
        int resultDelete = queryDelete.executeUpdate();
		System.out.println(resultDelete);
		
		  //-------------------------------------------------------------
        // Select
        //-------------------------------------------------------------
    /*    String hqlSelect = "from WorkPack where uProjectID=:uProjectID";
        Query querySelect = session.createQuery(hqlSelect);
        querySelect.setParameter("uProjectID", "b84570f4-81de-4b18-abb3-48c431e398c4");
        List<WorkPack> list = querySelect.list();*/
        
        //-------------------------------------------------------------
        // Update
        //-------------------------------------------------------------
      /*  String hqlUpdate = "update WorkPack set sPackName=:sPackName where uWorkPackID=:uWorkPackID";
        Query queryUpdate = session.createQuery(hqlUpdate);
        queryUpdate.setParameter("sPackName", "hi");
        queryUpdate.setParameter("uWorkPackID", "A1514770-2D6F-43A5-AF83-DD26068F0DF9");
        int resultUpdate = queryUpdate.executeUpdate();*/
		
		tx.commit();
		session.close();
		
	}
	static Logger logger =  Logger.getLogger(TestSSH.class);
	@Test
	public void Testlog() {
		 			//	logger.entry();   //trace级别的信息，单独列出来是希望你在某个方法或者程序逻辑开始的时候调用，和logger.trace("entry")基本一个意思
	       // logger.error("Did it again!");   //error级别的信息，参数就是你输出的信息
	        logger.info("我是info信息");    //info级别的信息
	      //  logger.debug("我是debug信息");
	       // logger.warn("我是warn信息");
	      //  logger.fatal("我是fatal信息");
	      //  logger.l
	       // logger.log(Level.DEBUG, "我是debug信息");   //这个就是制定Level类型的调用：谁闲着没事调用这个，也不一定哦！
	       // logger.exit();    //和entry()对应的结束方法，和logger.trace("exit");一个意思
	}
}
