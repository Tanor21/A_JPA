package com.norcorp;

import com.norcorp.dao.CategoryRepository;
import com.norcorp.entities.Category;
import com.norcorp.entities.Product;
import com.norcorp.dao.EntityRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class AJpaApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(AJpaApplication.class, args);
		EntityRepository<Product> productDao = ctx.getBean(EntityRepository.class);
		CategoryRepository categoryRepository = ctx.getBean(CategoryRepository.class);
		Category c1 = new Category("Computer");
		Category c2 = new Category("Printer");
		Category c3 = new Category("Software");

		categoryRepository.save(c1);
		categoryRepository.save(c2);
		categoryRepository.save(c3);

		productDao.save(new Product("LENOVO", 8000, 7, c1));
		productDao.save(new Product("MACBOOK", 9000, 10, c1));
		productDao.save(new Product("THINKPAD", 6000, 5, c2));

		List<Product> products = productDao.findAll();
		for (Product p:products) {
			System.out.println("Designation : " + p.getDesignation());
			System.out.println("Price : " + p.getPrice());
			System.out.println("Quantity : " + p.getQuantity());
		}
		System.out.println("---------------------------------------------");
		List<Product> productss = productDao.findByDesignation("%O%");
		for (Product p:productss) {
			System.out.println("Designation : " + p.getDesignation());
			System.out.println("Price : " + p.getPrice());
			System.out.println("Quantity : " + p.getQuantity());
		}
	}

}
