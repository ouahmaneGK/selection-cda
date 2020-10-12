package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import entities.Post;
import entities.Topic;

public class TopicDaoImpl implements TopicDao {

	private TopicDaoImpl topicDao; 
	private Connection con;
	
	
	
	public TopicDaoImpl(Connection con) {
	
		this.con = con;
		TopicDaoImpl topicDao = new TopicDaoImpl(con);
	}

	@Override
	public void createTopic(Topic topic) {
		
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO topic(title) VALUES (?)");
		    ps.setString(1, topic.getTitle());
		    
		
		    
		    ps.executeUpdate();
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Post p = new Post();
		
		
	}



	@Override
	public void deleteTopic(int id) {
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM topic WHERE id =?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Topic updateTopic(Topic topic) {
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE topic  SET title=?  where id =?");
			ps.setString(1, topic.getTitle());
			ps.setInt(2, topic.getId());

		    ps.executeUpdate();
		    
		    ps.close();
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return topic;
		
	}

	@Override
	public Topic getTopic(int id) {
		Topic topic = new Topic();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM topic WHERE id =?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				topic.setId(rs.getInt("id"));
				topic.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return topic;
	}

	public List<Topic> getAllTopics() {
		 
		List<Topic> topics = new ArrayList<Topic>();
		
		try {
			PreparedStatement ps= con.prepareStatement("SELECT * FROM topic");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				topics.add(  new Topic(  rs.getInt("id"),  rs.getString("title") ));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return topics;
	}

	

}
