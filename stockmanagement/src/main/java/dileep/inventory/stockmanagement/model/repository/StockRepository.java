package dileep.inventory.stockmanagement.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dileep.inventory.stockmanagement.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
