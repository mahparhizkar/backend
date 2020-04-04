package com.dss.backend.dao;

import com.dss.backend.model.School;
import java.util.List;

public interface SchoolDAO {

    List<School> get();

    School get(long id);

    void save(School student);

    void delete(long id);
}
