package student_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import student_management.entity.Student;
import student_management.repository.StudentRepository;

@RestController
@CrossOrigin
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    // ✅ GET all students
    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // ✅ POST - Add student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {

        if (student.getName() == null || student.getName().isEmpty()) {
            throw new RuntimeException("Name is required");
        }

        return repository.save(student);
    }

    // ✅ PUT - Update student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {

        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(updatedStudent.getName());
        student.setRollNumber(updatedStudent.getRollNumber());
        student.setGrade(updatedStudent.getGrade());

        return repository.save(student);
    }

    // ✅ DELETE student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
        return "Student deleted successfully";
    }

    // ✅ SEARCH 
    @GetMapping("/search")
    public List<Student> searchStudents(@RequestParam String name) {

        return repository.findAll().stream()
                .filter(s -> s.getName() != null &&
                        s.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}