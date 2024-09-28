package org.example.springcw.dto;

import org.example.springcw.entity.Student;

public record StudentResponse(
        Integer id,
        String name
) {
    public static StudentResponse fromEntity(Student student) {
        if (student == null) {
            return null;
        }
        return new StudentResponse(student.getId(), student.getName());
    }
}


