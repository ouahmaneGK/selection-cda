package entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;

@XmlRootElement
public class Post implements Serializable{

	

	private int id;
	private String content;
	private String author;
	private DateTime date;
	private Topic topic;
	
	public Post(int id, Topic topic, String content, String author, DateTime date) {
		super();
		this.id = id;
		this.content = content;
		this.author = author;
		this.date = date;
		this.topic = topic;
	}

	

	public Post() {
		super();
		
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}
	
	@XmlElement
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	
	
	
}
