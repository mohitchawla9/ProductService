package com.productservice.productservice;

import com.productservice.productservice.inheritancerelations.singletable.Mentor;
import com.productservice.productservice.inheritancerelations.singletable.MentorRepository;
import com.productservice.productservice.inheritancerelations.singletable.Student;
import com.productservice.productservice.inheritancerelations.singletable.User;
import com.productservice.productservice.inheritancerelations.singletable.StudentRepository;
import com.productservice.productservice.inheritancerelations.singletable.UserRepository;
import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.CategoryRepository;
import com.productservice.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;

	public ProductServiceApplication(CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}

//	private MentorRepository mentorRepository;
//	private UserRepository userRepository;
//	private StudentRepository studentRepository;
//
//	ProductServiceApplication(@Qualifier("st_mentorrepo") MentorRepository mentorRepository,
//							  @Qualifier("st_userrepo") UserRepository userRepository,
//							  @Qualifier("st_studentrepo") StudentRepository studentRepository) {
//		this.mentorRepository = mentorRepository;
//		this.userRepository = userRepository;
//		this.studentRepository = studentRepository;
//	}

//	private MentorRepository mentorRepository;
//	private StudentRepository studentRepository;
//	private UserRepository userRepository;
//
//	public ProductServiceApplication(@Qualifier("tpc_mentorrepository") MentorRepository mentorRepository
//	, StudentRepository studentRepository, UserRepository userRepository) {
//		this.mentorRepository = mentorRepository;
//		this.studentRepository = studentRepository;
//		this.userRepository = userRepository;
//	}

	public static void main(String[] args) {SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Mentor mentor = new Mentor();
//		mentor.setName("Deepak");
//		mentor.setEmail("deepak.kasera@scaler.com");
//		mentor.setAvgRating(4.7);
//		mentorRepository.save(mentor);
//
//		Student student = new Student();
//		student.setEmail("abhshek@scaler.com");
//		student.setName("Abhishek");
//		student.setPsp(90.0);
//		studentRepository.save(student);
//
//		User user = new User();
//		user.setEmail("arshi@scaler.com");
//		user.setName("Arshi");
//		userRepository.save(user);
//
//		//Get all the users
//		List<User> users = userRepository.findAll();
//
//		for (User user1 : users) {
//			System.out.println(user1.toString());
//		}

//		User user = new User();
//		user.setName("Arshi");
//		user.setEmail("arshi@gmail.com");
//		userRepository.save(user);
//
//		Mentor mentor = new Mentor();
//		mentor.setName("Deepak");
//		mentor.setEmail("deepak@gmail.com");
//		mentor.setAvgRating(4.7);
//		mentorRepository.save(mentor);
//
//		Student student = new Student();
//		student.setName("harsh");
//		student.setEmail("harsh@gmail.com");
//		student.setPsp(99.8);
//		studentRepository.save(student);

		Category category = new Category();
		category.setName("Apple Devices");

		Category savedCategory =  categoryRepository.save(category);

		Product product = new Product();
		product.setTitle("iphone 15 pro");
		product.setCategory(savedCategory);
		product.setDescription("Best iphone ever");

		Product savedProduct = productRepository.save(product);


	}

}
