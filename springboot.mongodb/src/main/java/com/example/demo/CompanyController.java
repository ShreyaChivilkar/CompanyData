package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")

public class CompanyController {
	
	private CompanyRepository companyRepository;
	
	public CompanyController(CompanyRepository companyRepository)
	{
		this.companyRepository = companyRepository;
	}
	
	@GetMapping("/all")
	
	public List<Company>getAll(){
		List<Company>companies = this.companyRepository.findAll();
		return companies;
	}
	
	@GetMapping("/{id}")
	public Company getCompany(@PathVariable("id") String id)
	{
		return this.companyRepository.findById(id).orElse(null);
		
	}
	
	@PutMapping("/{name}")
	public void insert(@RequestBody Company company, @PathVariable("name") String name)
	{
		this.companyRepository.save(company);
	}
	
	@PostMapping
	public void update(@RequestBody Company company) 
	{
		this.companyRepository.save(company);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id)
	{
		this.companyRepository.deleteById(id);
	}

	@GetMapping("/price/{maxStock}")
	public List<Company> getByStock(@PathVariable("maxStock") int maxStock)
	{
		List<Company>companies = this.companyRepository.findByStockLessThan(maxStock);
		return companies;
	}
}
