package dao;

import java.util.List;

import entities.Post;

public interface PostDao {

	public void createPost(Post post);
	public List<Post> getPosts();
	public void deletePost(int id);
	public Post updatePost(Post post, int id);
	
	
}
