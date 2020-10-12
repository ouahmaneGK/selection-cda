package entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Topic implements Serializable{

	private int id;
	private String title;
	
	
	public Topic() {}


	public Topic(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
