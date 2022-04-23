package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.codejava.model.Financial;

public interface FinancialRepository extends JpaRepository<Financial, Long> {

}
