package org.example.springcw.dto;

import org.example.springcw.entity.Student;

public record StudentRequest (
        Integer id,
        String name
) {
    public static StudentRequest fromEntity(Student student) {
        if (student == null) {
            return null;
        }
        return new StudentRequest(student.getId(), student.getName());
    }

}


