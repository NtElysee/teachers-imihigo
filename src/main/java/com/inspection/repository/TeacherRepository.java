package com.inspection.repository;

import com.inspection.model.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository  extends CrudRepository<Teacher, Integer> {
    public Long countById(Integer id);
}
