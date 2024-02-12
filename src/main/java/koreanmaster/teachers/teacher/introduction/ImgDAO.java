package koreanmaster.teachers.teacher.introduction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ImgDAO {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public ImgDAO(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.getTransaction();
    }

    public void addImg(){
        System.out.println("===> Hibernate 기반");

        ImgVO img = new ImgVO();
        img.setUrl("abcd");

        session.save(img);
        session.close();    //세션을 닫음.
        sessionFactory.close();

    }

    public List<ImgVO> getImg(){
        return session.createQuery("from ImgVO", ImgVO.class).getResultList();
    }
}
