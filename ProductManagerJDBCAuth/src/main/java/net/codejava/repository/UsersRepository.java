package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
