package com.example.demo;

import java.util.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner {
	
	private CompanyRepository companyRepository;
	
	public DbSeeder(CompanyRepository companyRepository)
	{
		this.companyRepository = companyRepository;
	}
	
	@Override
	public void run(String...strings) throws Exception{
		
		Company twitter = new Company(
				"Twitter",300,
				new Address("Paris","France"),
				Arrays.asList(
						new Review("John",8,false),
						new Review("Mary",7,true),
						new Review("Sam",5,false)));
		
		
		Company facebook = new Company(
				"Facebook",300,
				new Address("NYC","United States"),
				Arrays.asList(
						new Review("Anna",6,false),
						new Review("Andy",7,true)));
		
		Company instagram = new Company(
				"Instagram",300,
				new Address("Bucharest","Romania"),
				Arrays.asList());
		
		//drop all companies
		
		this.companyRepository.deleteAll();
		
		List<Company>companies = Arrays.asList(twitter,instagram,facebook); 
		this.companyRepository.saveAll(companies);
		
	}
	
	
	
	
}
