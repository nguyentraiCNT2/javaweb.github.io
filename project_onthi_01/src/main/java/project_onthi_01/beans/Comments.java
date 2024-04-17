package project_onthi_01.beans;

public class Comments {
	private Integer commentsid;
	private Integer post_id;
	private Integer user_id;
	private String comment_content;
	public Comments() {
	
	}
	
	public Comments(Integer commentsid, Integer post_id, Integer user_id, String comment_content) {
		
		this.commentsid = commentsid;
		this.post_id = post_id;
		this.user_id = user_id;
		this.comment_content = comment_content;
	}

	public Integer getCommentsid() {
		return commentsid;
	}

	public void setCommentsid(Integer commentsid) {
		this.commentsid = commentsid;
	}

	public Integer getPost_id() {
		return post_id;
	}

	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	

}
