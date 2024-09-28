package org.example.springcw.repository;

import org.example.springcw.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository// just for readabilty
public interface StudentJpaRepository extends JpaRepository<Student, Integer> {
List<Student> findByName(String name);
@Query("from Student where name=: name")
//@Query(value = "query",nativeQuery = true) // pure queries
List<Student> findByNameCustom(String name);
//List<Student> findByNameCustom(@Param("customname") String name); //custom name

//    Student findById(int id);
//
//    boolean deleteById(int id);
//    Student save(Student student);
//    Student update(Student student);
}
