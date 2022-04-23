package net.codejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.model.Financial;
import net.codejava.repository.FinancialRepository;


@Service
public class FinancialService {
	
	@Autowired
	private FinancialRepository repo;
	
	public List<Financial> listAll() {
		return repo.findAll();
	}
	
	public void save(Financial financial) {
		repo.save(financial);
	}
	
	public Financial get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
