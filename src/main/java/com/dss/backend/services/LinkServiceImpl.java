package com.dss.backend.services;

import com.dss.backend.dao.LinkDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("linkService")
@Transactional
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkDAO linkDAO;


    /*@
    Transactional
    @Override
    public List<Long> getSchoolIdByStudentId(long id) {
        return linkDAO.getSchoolIdByStudentId(id);
    }
    */

    @Transactional
    @Override
    public Long getSchoolIdByStudentId(long id) {
        return linkDAO.getSchoolIdByStudentId(id).get(0);
    }
}
