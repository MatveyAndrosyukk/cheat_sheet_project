package project_structure;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        getById();
        getListByQuery();
        save();
        update();
        delete();
    }

    public static void getById(){
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Sensor.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            Sensor sensor = session.get(Sensor.class, 1);

            session.getTransaction().commit();
        }catch (Exception exception){
            session.close();
            sessionFactory.close();
        }
    }

    public static void getListByQuery(){
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Sensor.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            List sensor = session.createQuery("update Sensor set name = 500 where name = 'sensor_1'").getResultList();

            session.getTransaction().commit();
        }catch (Exception exception){
            session.close();
            sessionFactory.close();
        }
    }

    public static void save(){
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Sensor.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {

            Sensor sensor = new Sensor("sensor_1");
            session.save(sensor);

            session.getTransaction().commit();
        }catch (Exception exception){
            session.close();
            sessionFactory.close();
        }
    }

    public static void update(){
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Sensor.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            session.createQuery("update Sensor set name = 'sensor_2' where id = 1").executeUpdate();

            session.getTransaction().commit();
        }catch (Exception exception){
            session.close();
            sessionFactory.close();
        }
    }

    public static void delete(){
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Sensor.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            Sensor sensor = session.get(Sensor.class, 1);
            session.delete(sensor);
            //или
            session.createQuery("delete from Sensor where id = 1").executeUpdate();

            session.getTransaction().commit();
        }catch (Exception exception){
            session.close();
            sessionFactory.close();
        }
    }
}
