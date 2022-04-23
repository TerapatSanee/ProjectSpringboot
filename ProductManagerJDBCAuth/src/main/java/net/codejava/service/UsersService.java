package net.codejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.model.Users;
import net.codejava.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository repo;
	
	public List<Users> listAll() {		
		return repo.findAll();
	}
	
	public void save(Users users) {
		repo.save(users);
	}
	
	public Users get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
