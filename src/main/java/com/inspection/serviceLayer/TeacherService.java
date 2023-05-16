package com.inspection.serviceLayer;


import java.util.Optional;


import com.inspection.model.Teacher;
import com.inspection.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository repo;

    public List<Teacher> listAll(){
        return (List<Teacher>) repo.findAll();
    }

    public void save(Teacher teacher) {
        repo.save(teacher);
    }

    public Teacher get(Integer id) throws UserNotFoundExcpetion {
        Optional<Teacher> result = repo.findById(id);

        if(result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundExcpetion("Couldn't find the teacher with Id" +id);
    }

    public void  delete( Integer id) throws UserNotFoundExcpetion {
         Long count= repo.countById(id);
         if(count==null || count==0){
             throw new UserNotFoundExcpetion("Couldn't find the teacher with Id" +id);
         }
          repo.deleteById(id);
    }
}

