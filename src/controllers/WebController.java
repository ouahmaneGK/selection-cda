package controllers;

import java.sql.Connection;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dao.PostDaoImpl;
import dao.TopicDaoImpl;
import entities.Post;
import entities.Topic;
import utils.*;


@Path("webService")
public class WebController {

	private PostDaoImpl postDaoImpl;
	private TopicDaoImpl topicDaoImpl;
	private Connection connection;
	
	
	public WebController( ) {
		   connection= DataConnect.getConnection();
		   postDaoImpl = new PostDaoImpl(connection);
		    topicDaoImpl = new TopicDaoImpl(connection);
	}
	
	
	
	/* Récupérer les posts d'un topic donné*/
	@GET
	@Path("/postsByTopic")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Post> postsByTopic(@QueryParam("id") int id){
		
		return postDaoImpl.findPostByTopic(id);
		
	}
	
	
	/*Créer un post*/
	@POST
	@Path("/createPost")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Post savePost(Post post) {
		
		postDaoImpl.createPost(post);
		
		return post;
	}
	
	/*Supprimer un post*/
	@DELETE
	@Path("/deletePost/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void deletePost(@QueryParam("id") int id) {
		
		postDaoImpl.deletePost(id);
	}
	
	/*Update d'un post*/
	@PUT
	@Path("/updatePost/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Post update( Post post , @PathParam(value="id") int id) {
		
		return  postDaoImpl.updatePost(post, id);
		
	
		
	}
	
   
   /*Récupérer tout les topics*/
	@GET
	@Path("/topics")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Topic> listTopics(){
		
		return topicDaoImpl.getAllTopics();
		
	}
	
	/*Créer un topic*/
	@POST
	@Path("/createTopic")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Topic saveTopic(Topic topic) {
		
		topicDaoImpl.createTopic(topic);
		
		return topic;
	}
	/*Supprimer un topic*/
	@DELETE
	@Path("/deleteTopic/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void deleteTopic(@QueryParam("id") int id) {
		
		topicDaoImpl.deleteTopic(id);;
	}
	
	/*Update d'un topic*/
	@PUT
	@Path("/updateTopic/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Topic update( Topic topic , @PathParam(value="id") int id) {
		
		return  topicDaoImpl.updateTopic(topic);
		
	
		
	}
}

