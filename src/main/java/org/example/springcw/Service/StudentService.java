package org.example.springcw.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.springcw.entity.Student;
import org.example.springcw.repository.StudentJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentJpaRepository studentJpaRepository;
    public List<Student> findAll(){
        return studentJpaRepository.findAll();
    }

    public List<Student> searchByName(String shayan) {
  return studentJpaRepository.findByName(shayan);
    }
}
