package fr.insa.mas.StudentInfoService.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.mas.StudentInfoService.model.StudentInfos;

@RestController
@RequestMapping("/student")
public class StudentInfoResource {

	@GetMapping(value="/{idStudent}")
	public StudentInfos getInfoEtudiant(@PathVariable("idStudent")  int id) {
		
		List<StudentInfos> etudInfos = Arrays.asList(
				new StudentInfos(0,"Godart","Noemie","12/12/1992"),
				new StudentInfos(1,"Perrin","Ania","13/12/1992"),
				new StudentInfos(2,"Az","Ana","14/12/1992"),
				new StudentInfos(3,"Yala","Nelia","15/12/1992")
				);
		
		return etudInfos.get(id);
	}
}
