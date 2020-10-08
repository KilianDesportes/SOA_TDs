package fr.insa.msa.StudentsListService.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.insa.msa.StudentsListService.model.Evaluation;
import fr.insa.msa.StudentsListService.model.Student;
import fr.insa.msa.StudentsListService.model.StudentIDList;
import fr.insa.msa.StudentsListService.model.StudentInfos;

@RestController
@RequestMapping("/students")
public class StudentListResource {

	@GetMapping(value="all/{idSpeciality}")
	public List<Student> getStudents(@PathVariable("idSpeciality")  String speciality) {
		
		StudentIDList studentsId = new StudentIDList();
		studentsId.saddStudentToList(0);
		studentsId.saddStudentToList(1);
		studentsId.saddStudentToList(2);
		studentsId.saddStudentToList(3);
		
		RestTemplate restTemplate = new RestTemplate();
		int i = 0;
		List<Student> listStudents = new ArrayList<Student>();
		
		while(i < studentsId.getStudentList().size()) {
			
			StudentInfos etudInfos = restTemplate.getForObject("http://localhost:8081/student/"+i, StudentInfos.class);
			
			Evaluation eval = restTemplate.getForObject("http://localhost:8082/evaluation/"+i, Evaluation.class);
			
			listStudents.add(new Student(i,etudInfos.getFirstName(),etudInfos.getLastName(),eval.getAverage()));
			i++;
			
		}
		
		return listStudents;
	}
}
