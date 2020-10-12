package dao;

import entities.Topic;

public interface TopicDao {

	public void createTopic(Topic topic);
	public void deleteTopic(int id);
	public Topic updateTopic(Topic topic);
	public Topic getTopic(int id);
	
}
