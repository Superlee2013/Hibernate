import domain.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Super on 2015/7/25.
 */
public class TeacherTest {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init(){
        Configuration configuration=new Configuration().configure();
        ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

        sessionFactory=configuration.buildSessionFactory(serviceRegistry);
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
    }


    @Test
    public void testSaveTeacher(){
        Teacher teacher=new Teacher(1,"he",new Date());
        session.save(teacher);
    }

    @After
    public void destroy(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
