package kz.dias.school.controllers;

import kz.dias.school.models.Student;
import kz.dias.school.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class StudentsController {

    @Autowired
    StudentMapper studentMapper;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> list() {
        List<Student> list = studentMapper.getAllStudents();
        System.out.println(list);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/students")
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        int id = studentMapper.saveStudent(student);
        return ResponseEntity.ok().body("New Student has been saved with ID:" + id);
    }

    @DeleteMapping(path="/students/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) {
        studentMapper.deleteStudent(id);
        return ResponseEntity.ok().body("Book has been deleted successfully." + id);
    }
}
