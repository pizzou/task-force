package net.todo.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.todo.model.Item;
import net.todo.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository repo;
	public List<Item> getAll(){
		
		return StreamSupport.stream(repo.findAll().spliterator(), false).collect(Collectors.toList());
		
		
	}

	public Item getItem(Long id) {
	
		
		return repo.findById(id).orElseThrow(() -> new RuntimeException());
	}
	
	public Item  addItem(Item item) {
		
		return repo.save(item);
	}
	
	
	public Item editItem(Long id, Item item) {
		Item items = getItem(id);
		items.setTitle(item.getTitle());
		items.setDescription(item.getDescription());
		items.setPriority(item.getPriority());
		
		return repo.save(item);
	}
	
	public Item deleteItem(Long id) {
		
		Item item= getItem(id);
		repo.delete(item);
		return item;
	}
	
	}
