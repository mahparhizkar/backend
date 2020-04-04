package com.dss.backend.dao;

import java.util.List;

public interface LinkDAO {

    List<Long> getSchoolIdByStudentId(long id);
}
