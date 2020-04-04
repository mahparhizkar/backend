package com.dss.backend.dao;

import com.dss.backend.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import org.hibernate.Session;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SchoolDAOImpl implements SchoolDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<School> get() {
        Session currSession = entityManager.unwrap(Session.class);
        Query<School> query = currSession.createQuery("from School", School.class);
        List<School> list = query.getResultList();
        return list;
    }

    @Override
    public School get(long id) {
        Session currSession = entityManager.unwrap(Session.class);
        School sch = currSession.get(School.class, id);
        return sch;
    }

    @Override
    public void save(School school) {
        Session currSession = entityManager.unwrap(Session.class);
        currSession.saveOrUpdate(school);
    }

    @Override
    public void delete(long id) {
        Session currSession = entityManager.unwrap(Session.class);
        School sch = currSession.get(School.class, id);
        currSession.delete(sch);
    }
}
