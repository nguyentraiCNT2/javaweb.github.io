package project_onthi_01.beans;

public class Posts {
private Integer postsid;
private Integer user_id;
private String title;
private String content;
public Posts() {
	
}
public Posts(Integer postsid, Integer user_id, String title, String content) {
	this.postsid = postsid;
	this.user_id = user_id;
	this.title = title;
	this.content = content;
}
public Integer getPostsid() {
	return postsid;
}
public void setPostsid(Integer postsid) {
	this.postsid = postsid;
}
public Integer getUser_id() {
	return user_id;
}
public void setUser_id(Integer user_id) {
	this.user_id = user_id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}


}
