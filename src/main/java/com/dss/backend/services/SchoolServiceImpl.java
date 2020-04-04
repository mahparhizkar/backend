package com.dss.backend.services;

import com.dss.backend.dao.SchoolDAO;
import com.dss.backend.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("schoolService")
@Transactional
public class SchoolServiceImpl implements SchoolService{

    @Autowired
    private SchoolDAO schoolDAO;

    @Transactional
    @Override
    public List<School> get() {
        return schoolDAO.get();
    }

    @Transactional
    @Override
    public School get(long id) {
        return schoolDAO.get(id);
    }

    @Transactional
    @Override
    public void save(School school) {
        schoolDAO.save(school);
    }

    @Transactional
    @Override
    public void delete(long id) {
        schoolDAO.delete(id);
    }
}