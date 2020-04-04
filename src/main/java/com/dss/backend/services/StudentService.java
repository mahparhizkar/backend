package com.dss.backend.services;

import com.dss.backend.model.Student;
import java.util.List;

public interface StudentService {

    List<Student> get();

    Student get(long id);

    void save(Student student);

    void delete(long id);

    Student getByMeliCode(String melicode);
}
