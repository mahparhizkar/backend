package com.dss.backend.dao;

import com.dss.backend.model.Student;
import java.util.List;

public interface StudentDAO {

    List<Student> get();

    Student get(long id);

    void save(Student student);

    void delete(long id);

    Student getByMeliCode(String melicode);
}
