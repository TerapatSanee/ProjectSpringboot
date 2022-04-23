package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
}
