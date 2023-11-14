package bussiness;

import entity.Student;

import java.util.List;

public interface StudentBussiness {
    List<Student> getAllStudent();
    boolean createStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(int studentId);
    int getCntStudentByStatus(boolean status);
}
