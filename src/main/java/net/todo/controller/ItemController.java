package net.todo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.todo.model.Item;

import net.todo.service.ItemService;

@RestController
@RequestMapping("/v2/todo")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of PItem.")
public class ItemController {

	@Autowired
	private ItemService service;
	
	@GetMapping("/findAll")
	@ApiOperation("${itemcontroller.dogetall}")
	public ResponseEntity<List<Item>> doGetAll(){
		
		List<Item> items = service.getAll();
		List<Item> item = items.stream().collect(Collectors.toList());
		
		return new ResponseEntity<>(item, HttpStatus.OK);
		
	}
	
	@PostMapping("/addItem")
	@ApiOperation("${itemcontroller.createitem}")
	public ResponseEntity<?> createItem(@RequestBody Item item){
		
		service.addItem(item);
		
		
		return new ResponseEntity<>("new Item was created successfully",HttpStatus.OK);
	}
	
	@GetMapping("/findOne/{id}")
	
	 @ApiOperation("${itemcontroller.getone}")
	public ResponseEntity<Item> getOne(@PathVariable Long id){
		return new ResponseEntity<Item>(service.getItem(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	@ApiOperation("${itemcontroller.deleteitem}")
	public ResponseEntity<Item> deleteItem(@PathVariable Long id){
		
		return new ResponseEntity<Item>(service.deleteItem(id),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	@ApiOperation("${itemcontroller.updateitem}")
	public ResponseEntity<?> updateItem(@PathVariable Long id,@RequestBody Item item){
		
		Item items = service.editItem(id, item);
		
		
		return new ResponseEntity<>(items,HttpStatus.OK);
		
	}
}
