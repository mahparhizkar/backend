package com.dss.backend.services;

import com.dss.backend.dao.StudentDAO;
import com.dss.backend.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Transactional
    @Override
    public List<Student> get() {
        return studentDAO.get();
    }

    @Transactional
    @Override
    public Student get(long id) {
        return studentDAO.get(id);
    }

    @Transactional
    @Override
    public void save(Student student) {
        studentDAO.save(student);
    }

    @Transactional
    @Override
    public void delete(long id) {
        studentDAO.delete(id);
    }

    @Transactional
    @Override
    public Student getByMeliCode(String melicode) {
        return studentDAO.getByMeliCode(melicode);
    }
}
