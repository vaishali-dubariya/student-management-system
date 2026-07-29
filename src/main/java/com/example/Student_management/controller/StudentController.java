package com.example.Student_management.controller;

import com.example.Student_management.dto.StudentRequestDTO;
import com.example.Student_management.dto.StudentResponseDTO;
import com.example.Student_management.entity.Student;
import com.example.Student_management.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;
@Tag(name = "Student Management APIs")
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @Operation(summary = "get all students")
    @GetMapping
    public List<StudentResponseDTO> getAllStudents(){
        return studentService.getAllStudents();
    }

    @Operation(summary = "get student by id")
    @GetMapping("/{id}")
    public StudentResponseDTO getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
    //create student
    @Operation(summary = "create a student")
    @PostMapping
    public StudentResponseDTO createStudent(@Valid @RequestBody StudentRequestDTO studentRequestDTO){
        return studentService.saveStudent(studentRequestDTO);
    }
    @Operation(summary = "update student")
    @PutMapping("/{id}")
    public StudentResponseDTO updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequestDTO studentRequestDTO) {

        return studentService.updateStudent(id, studentRequestDTO);
    }
    @Operation(summary = "partially update a student")
    @PatchMapping("/{id}")
    public StudentResponseDTO patchStudent(
            @PathVariable Long id,
            @RequestBody StudentRequestDTO studentRequestDTO) {

        return studentService.patchStudent(id, studentRequestDTO);
    }

    @Operation(summary = "delete a student")
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "student deleted successfully";
    }
}
