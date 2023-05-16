package com.inspection;

import com.inspection.model.Teacher;
import com.inspection.repository.TeacherRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class InspectionTest {

    @Autowired private TeacherRepository repo;

    @Test
    public void testAddNew(){
        Teacher teacher=new Teacher();

        teacher.setId(8);
        teacher.setAttendance_rate(80);
        teacher.setEmail("benty@gmail.com");
        teacher.setFullname("NTAKIRUTIMANA Elysee");
        teacher.setGraduation_rate(91);
        teacher.setLecturer_satisfactory(78);
        teacher.setStudents_achievement(93);

        Teacher savedTeacher= repo.save(teacher);

        Assertions.assertThat(savedTeacher).isNotNull();
        Assertions.assertThat(savedTeacher.getId()).isGreaterThan(0);

    }

    @Test
    public void testListAll(){
        Iterable<Teacher> teachers= repo.findAll();
        Assertions.assertThat(teachers).hasSizeGreaterThan(0);


        for(Teacher teacher: teachers){
            System.out.println(teacher);
        }
    }

    @Test
    public void testUpdate(){
     Integer teacherId=1;
        Optional<Teacher> optionalTeacher=repo.findById(teacherId);
        Teacher teacher=optionalTeacher.get();
        teacher.setFullname("Berthe");
        repo.save(teacher);
        Teacher updatedTeacher=repo.findById(teacherId).get();
        Assertions.assertThat(updatedTeacher.getFullname()).isEqualTo("Berthe");
    }

    @Test
    public void testGet(){

        Integer Id=3;
        Optional<Teacher> optionUser= repo.findById(Id);
        Assertions.assertThat(optionUser).isPresent();
        System.out.println(optionUser.get());

    }

    @Test
    public void testDelete(){
        Integer Id=10;
        repo.deleteById(Id);

        Optional<Teacher> optionUser= repo.findById(Id);
        Assertions.assertThat(optionUser).isNotPresent();

    }
}
