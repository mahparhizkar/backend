package com.dss.backend.services;

import com.dss.backend.model.School;
import java.util.List;

public interface SchoolService {

    List<School> get();

    School get(long id);

    void save(School school);

    void delete(long id);
}
