package com.example.Student_management.service;

import com.example.Student_management.dto.StudentRequestDTO;
import com.example.Student_management.dto.StudentResponseDTO;
import com.example.Student_management.entity.Student;
import com.example.Student_management.exception.StudentNotFoundException;
import com.example.Student_management.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;

    public List<StudentResponseDTO> getAllStudents(){

        List<Student> students = studentRepo.findAll();

        List<StudentResponseDTO> responseList = new ArrayList<>();

        for(Student student : students){

            StudentResponseDTO dto = new StudentResponseDTO();

            dto.setId(student.getId());
            dto.setName(student.getName());
            dto.setEmail(student.getEmail());
            dto.setAge(student.getAge());

            responseList.add(dto);
        }

        return responseList;
    }

    public StudentResponseDTO getStudentById(Long id){
       Student student=studentRepo.findById(id)
               .orElseThrow(()-> new StudentNotFoundException("student not found with id :"+id));
       StudentResponseDTO responseDTO= new StudentResponseDTO();
       responseDTO.setId(student.getId());
       responseDTO.setName(student.getName());
       responseDTO.setAge(student.getAge());
       responseDTO.setEmail(student.getEmail());

       return responseDTO;
    }
    public StudentResponseDTO saveStudent(StudentRequestDTO studentRequestDTO) {

        // Convert DTO to Entity
        Student student = new Student();

        student.setName(studentRequestDTO.getName());
        student.setEmail(studentRequestDTO.getEmail());
        student.setAge(studentRequestDTO.getAge());

        // Save Entity
        Student savedStudent = studentRepo.save(student);

        // Convert Entity to Response DTO
        StudentResponseDTO responseDTO = new StudentResponseDTO();

        responseDTO.setId(savedStudent.getId());
        responseDTO.setName(savedStudent.getName());
        responseDTO.setEmail(savedStudent.getEmail());
        responseDTO.setAge(savedStudent.getAge());

        return responseDTO;
    }
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO studentRequestDTO) {

        Student student = studentRepo.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id));

        student.setName(studentRequestDTO.getName());
        student.setEmail(studentRequestDTO.getEmail());
        student.setAge(studentRequestDTO.getAge());

        Student updatedStudent = studentRepo.save(student);

        StudentResponseDTO responseDTO = new StudentResponseDTO();

        responseDTO.setId(updatedStudent.getId());
        responseDTO.setName(updatedStudent.getName());
        responseDTO.setEmail(updatedStudent.getEmail());
        responseDTO.setAge(updatedStudent.getAge());

        return responseDTO;
    }
    public StudentResponseDTO patchStudent(Long id, StudentRequestDTO studentRequestDTO) {

        Student student = studentRepo.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id));

        if (studentRequestDTO.getName() != null) {
            student.setName(studentRequestDTO.getName());
        }

        if (studentRequestDTO.getEmail() != null) {
            student.setEmail(studentRequestDTO.getEmail());
        }

        if (studentRequestDTO.getAge() != null) {
            student.setAge(studentRequestDTO.getAge());
        }

        Student updatedStudent = studentRepo.save(student);

        StudentResponseDTO responseDTO = new StudentResponseDTO();

        responseDTO.setId(updatedStudent.getId());
        responseDTO.setName(updatedStudent.getName());
        responseDTO.setEmail(updatedStudent.getEmail());
        responseDTO.setAge(updatedStudent.getAge());

        return responseDTO;
    }
    public void deleteStudent(Long id){
        Student s = studentRepo.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id));
        studentRepo.delete(s);
    }

}
