package in.ashokit;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import in.ashokit.entity.StudentEntity;
import in.ashokit.repository.StudentRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		StudentRepository studentRepo = context.getBean(StudentRepository.class);
		
		/*System.out.println("-------------findAll()-----------------------------------------------------------------");
		List<StudentEntity> students = studentRepo.findAll();
		for(StudentEntity student:students)
		{
			System.out.println(student);
			
		}
		System.out.println("-------------findAll()-----------------------------------------------------------------");
		*/
		

		/*System.out.println("-------findAll(ascending order)-----------------------------------------------------");
		List<StudentEntity> students1 = studentRepo.findAll(Sort.by("studentName").ascending());
		for(StudentEntity student:students1)
		{
			System.out.println(student);
			
		}
		System.out.println("-------findAll(ascending order)------------------------------------------------------");*/
		
		
		
		
		
		/*System.out.println("========================================================================================");
		StudentEntity st1 = new StudentEntity();
		st1.setStudentAge(19);
		List<StudentEntity> students1 = studentRepo.findAll(Example.of(st1));
		for(StudentEntity student:students1)
		{
			System.out.println(student);
			
		}
		System.out.println("========================================================================================");
*/
		System.out.println("=========================================================================================");
		int pageNo = 4;
		Page<StudentEntity> pageable = studentRepo.findAll(PageRequest.of(pageNo-1, 3));
		List<StudentEntity> students = pageable.getContent();
		
		for (StudentEntity s : students) {
			System.out.println(s);
		}
		System.out.println("============================================================================================");

		context.close();
		
	

	}

}
