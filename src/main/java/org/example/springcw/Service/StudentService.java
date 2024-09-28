package org.example.springcw.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.springcw.dto.StudentRequest;
import org.example.springcw.dto.StudentResponse;
import org.example.springcw.entity.Student;
import org.example.springcw.repository.StudentJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentJpaRepository studentJpaRepository;

    public List<Student> findAll() {
        return studentJpaRepository.findAll();
    }

    public List<Student> searchByName(String shayan) {
        return studentJpaRepository.findByName(shayan);
    }

    public StudentResponse findById(int id) {
        return  StudentResponse.fromEntity(studentJpaRepository.findById(id).get());
    }

    public void deleteStudent(Integer id) {
        if (!studentJpaRepository.existsById(id)) {
            throw new EntityNotFoundException("Student not found");
        }
        studentJpaRepository.deleteById(id);
    }

    public StudentResponse updateStudent(Integer id, StudentRequest studentDetails) {
        Student student = studentJpaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        student.setName(studentDetails.name());
        return StudentResponse.fromEntity(studentJpaRepository.save(student));
    }

    public StudentResponse save(StudentRequest studentRequest) {
        Student student =new Student();
    student.setId(studentRequest.id());
    student.setName(studentRequest.name());
       return StudentResponse.fromEntity(studentJpaRepository.save(student));
    }



}
