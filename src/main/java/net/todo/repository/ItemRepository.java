package net.todo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.todo.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item,Long>{

}
