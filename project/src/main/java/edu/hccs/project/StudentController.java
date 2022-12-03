package edu.hccs.project;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public class StudentController {
    @RestController
    @RequestMapping("/student")
    public class StudentController {

        List<Student> sl;

        @PostConstruct
        public void addstudent() {
            sl = new ArrayList<>();
            sl.add(new Student(1, "Caleb", 3.6, "jdtg0@aws.com", "Female"));
            sl.add(new Student(2, "Aida", 3.1, "adattt@test.gov", "Female"));
            sl.add(new Student(3, "Alex", 3.4, "Adavis@bccs.com", "Male"));
            sl.add(new Student(4, "Meba", 3.2, "mtravis@yahoo.com", "Male"));

        }

        @RequestMapping("getAll")
        public List<Student> getAllStudent() {
            return sl;
        }

        @RequestMapping("getByName")
        public List<Student> getByName(@RequestParam("first_name") String first_name) {
            List<Student> matchedStudents = new ArrayList<Student>();
            for (Student currentStudent : sl) {
                if (currentStudent.getFirst_name().equalsIgnoreCase(first_name)) {
                    matchedStudents.add(currentStudent);
                }
            }
            return matchedStudents;
        }


        @RequestMapping("getByGpaAndGender")
        public List<Student> getByGpaAndGender(@RequestParam("gpa") double gpa, @RequestParam("gender") String gender) {
            List<Student> matchedStudents = new ArrayList<Student>();
            for (Student currentStudent : sl) {
                if (currentStudent.getGpa() == gpa && currentStudent.getGender().equalsIgnoreCase(gender)) {
                    matchedStudents.add(currentStudent);
                }
            }
            return matchedStudents;
        }


        @RequestMapping("getAvgGpa")
        public double getAvgGpa() {
            double totalGpa = 0;
            int count = 0;
            double avgGpa = 0;
            for (Student currentStudent : sl) {
                count++;
                totalGpa += currentStudent.getGpa();
            }
            if (count > 0) {
                avgGpa = totalGpa / count;
            }
            return avgGpa;
        }
    }
}
