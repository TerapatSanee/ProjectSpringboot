package net.codejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.model.Cart;
import net.codejava.repository.CartRepository;


@Service
public class CartService {

	@Autowired
	private CartRepository repo;
	
	public List<Cart> listAll() {
		return repo.findAll();
	}
	
	public void save(Cart cart) {
		float s = cart.getCart_quantity() * cart.getProduct_price();
		cart.setTotal_price(s);
		repo.save(cart);
	}
	
	public Cart get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
