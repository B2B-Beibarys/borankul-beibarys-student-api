package com.borankul.studentapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    private StudentRepository repository;

    @InjectMocks
    private StudentController controller;

    @Test
    void getAll_returnsStudents() {
        Student s = new Student("Beibarys Borankul", "beibarys@example.com", "IT2-2306");
        when(repository.findAll()).thenReturn(List.of(s));
        assertEquals(1, controller.getAll().size());
        assertEquals("Beibarys Borankul", controller.getAll().get(0).getFullName());
    }

    @Test
    void create_savesStudent() {
        Student s = new Student("Beibarys Borankul", "beibarys@example.com", "IT2-2306");
        when(repository.save(s)).thenReturn(s);
        assertEquals("Beibarys Borankul", controller.create(s).getFullName());
    }
}
