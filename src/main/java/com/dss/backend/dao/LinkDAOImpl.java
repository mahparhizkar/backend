package com.dss.backend.dao;

import com.dss.backend.model.Link;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class LinkDAOImpl implements LinkDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Long> getSchoolIdByStudentId(long id) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Link.class)
                .add(Restrictions.eq("id", id))
                .setProjection(Projections.projectionList()
                        .add(Projections.property("school_id"), "school_id"));
        return criteria.list();
    }
}
