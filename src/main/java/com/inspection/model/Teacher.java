package com.inspection.model;


import jakarta.persistence.*;

@Entity
@Table(name="inspection")
public class Teacher {

    public Teacher(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullname;
    @Column(nullable= false, unique = true, length = 45)
    private String email;
    private int students_achievement;
    private int attendance_rate;
    private int graduation_rate;
    private int lecturer_satisfactory;

    public Teacher() {
    }

    public Teacher(Integer id, String fullname, String email, int students_achievement, int attendance_rate, int graduation_rate, int lecturer_satisfactory) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.students_achievement = students_achievement;
        this.attendance_rate = attendance_rate;
        this.graduation_rate = graduation_rate;
        this.lecturer_satisfactory = lecturer_satisfactory;
    }

    public Integer getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStudents_achievement() {
        return students_achievement;
    }

    public void setStudents_achievement(int students_achievement) {
        this.students_achievement = students_achievement;
    }

    public int getAttendance_rate() {
        return attendance_rate;
    }

    public void setAttendance_rate(int attendance_rate) {
        this.attendance_rate = attendance_rate;
    }

    public int getGraduation_rate() {
        return graduation_rate;
    }

    public void setGraduation_rate(int graduation_rate) {
        this.graduation_rate = graduation_rate;
    }

    public int getLecturer_satisfactory() {
        return lecturer_satisfactory;
    }

    public void setLecturer_satisfactory(int lecturer_satisfactory) {
        this.lecturer_satisfactory = lecturer_satisfactory;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", students_achievement=" + students_achievement +
                ", attendance_rate=" + attendance_rate +
                ", graduation_rate=" + graduation_rate +
                ", lecturer_satisfactory=" + lecturer_satisfactory +
                '}';
    }
}
