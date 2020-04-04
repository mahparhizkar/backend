package com.dss.backend.dao;

import com.dss.backend.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> get() {
        Session currSession = entityManager.unwrap(Session.class);
        Query<Student> query = currSession.createQuery("from Student", Student.class);
        List<Student> list = query.getResultList();
        return list;
    }

    @Override
    public Student get(long id) {
        Session currSession = entityManager.unwrap(Session.class);
        Student stu = currSession.get(Student.class, id);
        return stu;
    }

    @Override
    public void save(Student student) {
        Session currSession = entityManager.unwrap(Session.class);
        currSession.saveOrUpdate(student);
    }

    @Override
    public void delete(long id) {
        Session currSession = entityManager.unwrap(Session.class);
        Student stu = currSession.get(Student.class, id);
        currSession.delete(stu);
    }

    @Override
    public Student getByMeliCode(String melicode) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Student.class)
                .add(Restrictions.eq("melicode", melicode));
        return (Student) criteria.uniqueResult();
    }
}
