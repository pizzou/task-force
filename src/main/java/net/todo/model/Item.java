package net.todo.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.todo.enumerator.Priority;

@Entity

@ApiModel(description = "Class representing a person tracked by the application.")
public class Item extends Auditable<String>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @ApiModelProperty(notes = "${item.id}", example = "1", required = true, position = 0)
	private Long id;
	private String title;
	private String description;
	@Enumerated
	private Priority priority;
	
	
	
	
	public Item() {
		//super();
	}
	public Item(String title, String description, Priority priority) {
		//super();
		this.title = title;
		this.description = description;
		this.priority = priority;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
	

}
