package dileep.inventory.stockmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dileep.inventory.stockmanagement.model.Item;
import dileep.inventory.stockmanagement.model.Stock;
import dileep.inventory.stockmanagement.model.repository.ItemRepository;
import dileep.inventory.stockmanagement.model.repository.StockRepository;
import dileep.inventory.stockmanagement.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	StockRepository stockRepository;

	@Autowired
	ItemRepository itemRepository;

	@PostMapping("/createStock")
	public Stock createStock(@Valid @RequestBody Stock stock) throws ResourceNotFoundException {
		Item item = itemRepository.findById(stock.getItemNo()).orElseThrow(() -> new ResourceNotFoundException(""));
		stock.setStockNumber(item.getItemNo());
		stock.setStockName(item.getItemName());
		stock.setStockDesc(item.getItemDesc());
		return stockRepository.save(stock);
	}

	@PutMapping("/updateStock/{id}")
	public ResponseEntity<Stock> updateEmployee(@PathVariable(value = "id") Long stockNumber,
			@Valid @RequestBody Stock stockDetails) throws ResourceNotFoundException {
		Stock stock = stockRepository.findById(stockNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Stock not found for this id :: " + stockNumber));
		stock.setPurchaseDate(stockDetails.getPurchaseDate());
		stock.setPurchasePrice(stockDetails.getPurchasePrice());
		stock.setQuantity(stockDetails.getQuantity());
		stock.setSellingDate(stockDetails.getSellingDate());
		stock.setSellingPrice(stockDetails.getSellingPrice());
		final Stock updatedEmployee = stockRepository.save(stock);
		return ResponseEntity.ok(updatedEmployee);
	}

	@GetMapping("/displayStock")
	public List<Stock> getStockDetails() {
		return stockRepository.findAll();
	}

	@PostMapping("/sellingStock")
	public Stock sellingStock(@Valid @RequestBody Stock stock) throws ResourceNotFoundException {
		Stock stockTemp = stockRepository.findById(stock.getStockNumber()).orElseThrow(
				() -> new ResourceNotFoundException("Stock not found for this id :: " + stock.getStockNumber()));
		if (stockTemp.getQuantityAvailable() == 0) {
			stockRepository.delete(stockTemp);
			throw new ResourceNotFoundException("No Stock Available");
		} else if (stockTemp.getQuantityAvailable() < stock.getQuantity()) {
			throw new ResourceNotFoundException("Number of available Stock is less, Stock available to quantiy are: "
					+ stockTemp.getQuantityAvailable());
		} else {
			Double availableStock = stockTemp.getQuantityAvailable() - stock.getQuantity();
			stockTemp.setQuantityAvailable(availableStock);
			stockTemp.setSellingDate(stock.getSellingDate());
			stockTemp.setSellingPrice(stock.getSellingPrice());
			Stock st = stockRepository.save(stockTemp);
			if (availableStock == 0) {
				stockRepository.delete(stockTemp);
				throw new ResourceNotFoundException("All Stock are sold out ");
			}
			return st;
		}
	}

}
