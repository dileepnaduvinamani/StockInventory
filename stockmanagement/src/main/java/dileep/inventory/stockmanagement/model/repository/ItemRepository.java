package dileep.inventory.stockmanagement.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dileep.inventory.stockmanagement.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
