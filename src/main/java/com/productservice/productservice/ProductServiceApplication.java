package com.productservice.productservice;

import com.productservice.productservice.inheritancerelations.singletable.Mentor;
import com.productservice.productservice.inheritancerelations.singletable.MentorRepository;
import com.productservice.productservice.inheritancerelations.singletable.Student;
import com.productservice.productservice.inheritancerelations.singletable.User;
import com.productservice.productservice.inheritancerelations.singletable.StudentRepository;
import com.productservice.productservice.inheritancerelations.singletable.UserRepository;
import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Order;
import com.productservice.productservice.models.Price;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.CategoryRepository;
import com.productservice.productservice.repositories.OrderRepository;
import com.productservice.productservice.repositories.PriceRepository;
import com.productservice.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	private final OrderRepository orderRepository;
	private final PriceRepository priceRepository;
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;

	public ProductServiceApplication(OrderRepository orderRepository, PriceRepository priceRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.orderRepository = orderRepository;
		this.priceRepository = priceRepository;
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}
//	private final CategoryRepository categoryRepository;
//	private final ProductRepository productRepository;
//
//	public ProductServiceApplication(CategoryRepository categoryRepository, ProductRepository productRepository) {
//		this.categoryRepository = categoryRepository;
//		this.productRepository = productRepository;
//	}

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

//		Category category = new Category();
//		category.setName("Apple Devices");

//		Category savedCategory =  categoryRepository.save(category);

//		Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("c04a219c-ef08-4347-9c5a-9fc1e4815994"));
//
//		if(optionalCategory.isEmpty()) {
//			throw new RuntimeException("Category was null");
//		}
//		Category category = optionalCategory.get();

//		Product product = new Product();
//		product.setTitle("iphone 15 pro");
//		product.setCategory(category.get());
//		product.setDescription("Best iphone ever");
//
//		Product savedProduct = productRepository.save(product);

		//Find all products with category = Apple Devices
//		List<Product> products = category.getProducts();
//		for(Product product : products) {
//			System.out.println(product.getTitle());
//		}

//		Price price = new Price();
//		price.setCurrency("INR");
//		price.setValue(100000);
//
//		Price savedPrice = priceRepository.save(price);
//
//		Category category = new Category();
//		category.setName("Apple Devices");
//		Category savedCategory = categoryRepository.save(category);
//
//		Product product = new Product();
//		product.setTitle("iphone 15 pro");
//		product.setPrice(savedPrice);
//		product.setCategory(savedCategory);
//		product.setDescription("Best iphone ever");
//
//		Product savedProduct = productRepository.save(product);

//		Optional<Price> optionalPrice = priceRepository.findById(UUID.fromString("5c234d44-7a5d-4cdc-96f2-96a62ceb3e3f"));
//
//		if(optionalPrice.isEmpty()){
//			throw new RuntimeException("Price is empty");
//		}


		priceRepository.deleteById(UUID.fromString("5c234d44-7a5d-4cdc-96f2-96a62ceb3e3f"));

	}

}
