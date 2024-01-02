package net.javaguides.springboot.controller;


import net.javaguides.springboot.bean.Student;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student student  = new Student(
                7,
                "shayan",
                "ansari"
        );
        return ResponseEntity.ok().header("custom", "new header").body(student);
    }


    @GetMapping
    public List<Student> getStudents( ) {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "shayan", "ansari"));
        students.add(new Student(2, "ramesh", "alam"));
        students.add(new Student(3, "suresh", "ahmed"));

        return students;
    }

    @GetMapping("/student/{id}/{firstName}/{lastName}")
    public Student getStudentPathVariable(@PathVariable int id, @PathVariable String firstName, @PathVariable String lastName) {
        return new Student(id, firstName, lastName);
    }

    @GetMapping("/student/query")
    public Student getStudentsRequestVariable(@RequestParam int id, @RequestParam String firstName) {
        return new Student(id, firstName, "sudare");
    }

    @PostMapping("/student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@NotNull @RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    @PutMapping("/student/update/{id}")
    public Student updateStudent(@NotNull @RequestBody Student student, @PathVariable int id) {
        System.out.println(id);
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        student.setId(id);
        return student;
    }

}
