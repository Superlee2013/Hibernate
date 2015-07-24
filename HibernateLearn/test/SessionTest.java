import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

/**
 * Created by Super on 2015/7/23.
 */
public class SessionTest {
    @Test
    public void testOpenSession(){
        Configuration configuration=new Configuration().configure();
        ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
        Session session1=sessionFactory.openSession();
        Session session2=sessionFactory.openSession();

        System.out.println(session1==session2);
//        Transaction transaction=session.beginTransaction();
        /*if(session!=null){
            System.out.println("session创建成功");
        }
        else{
            System.out.println("创建失败");
        }*/
    }

    @Test
    public void testGetCurrentSession(){
        Configuration configuration=new Configuration().configure();
        ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
        Session session1=sessionFactory.getCurrentSession();
        Session session2=sessionFactory.getCurrentSession();

        System.out.println(session1==session2);
        /*if(session!=null){
            System.out.println("session创建成功");
        }
        else{
            System.out.println("创建失败");
        }*/
    }
}
