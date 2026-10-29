package com.borankul.studentapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

@ExtendWith(MockitoExtension.class)
class StudentNotFoundTest {

    @Mock
    private StudentRepository repository;

    @InjectMocks
    private StudentController controller;

    @Test
    void getById_returns404_whenStudentMissing() {
        when(repository.findById(99L)).thenReturn(Optional.empty());
        ResponseStatusException ex = assertThrows(ResponseStatusException.class, () -> controller.getById(99L));
        assertEquals(404, ex.getStatusCode().value());
    }
}
