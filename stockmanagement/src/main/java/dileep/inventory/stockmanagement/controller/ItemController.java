package dileep.inventory.stockmanagement.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dileep.inventory.stockmanagement.exception.ResourceNotFoundException;
import dileep.inventory.stockmanagement.model.Item;
import dileep.inventory.stockmanagement.model.repository.ItemRepository;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ItemRepository itemRepository;

	@PostMapping("/createItem")
	public Item createItem(@Valid @RequestBody Item item) {
		return itemRepository.save(item);
	}

	@DeleteMapping("/deleteItem/{itemNo}")
	public Map<String, Boolean> deleteItem(@PathVariable(value = "itemNo") Long itemNo)
			throws ResourceNotFoundException {
		Item item = itemRepository.findById(itemNo)
				.orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + itemNo));
		itemRepository.delete(item);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted item no: "+itemNo, Boolean.TRUE);
		return response;
	}

}
