import domain.Students;
import javassist.tools.rmi.ObjectNotFoundException;
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
public class HibernateTest {
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
    public void testSaveStudents(){
        Students students=new Students();
        students.setSname("李四");
        students.setAddress("梅三");
        students.setBirthday(new Date());
        students.setGender("女");
        session.save(students);
    }


    @Test
    public void testGetStudents(){
        Students students= (Students) session.get(Students.class,20);
        System.out.println(students);
//        System.out.println(students.getClass().getName());
    }

    @Test
    public void testLoadStudents(){
        try {
            Students students = (Students) session.load(Students.class, 20);
            System.out.println(students);
        }
        catch (org.hibernate.ObjectNotFoundException o){
            System.out.println("hahah");
        }
//        Students students= (Students) session.load(Students.class, 20);
//        System.out.println(students.getClass().getName());
//        System.out.println(students);
    }

    @Test
    public void testUpdateStudents(){
        Students students= (Students) session.get(Students.class,4);
        students.setSname("hahahah");
        session.update(students);
    }

    @Test
    public void testDeleteStudents(){
        Students students= (Students) session.get(Students.class,5);
        students.setSname("dasda");
        session.delete(students);
    }


    @After
    public void destroy(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

}
