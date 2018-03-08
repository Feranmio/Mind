package ePetition;

public class CommentInfo {

	public CommentInfo(String id, String comment, String by_mp) {
		super();
		this.id = id;
		this.comment = comment;
		this.by_mp = by_mp;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getBy_mp() {
		return by_mp;
	}
	public void setBy_mp(String by_mp) {
		this.by_mp = by_mp;
	}
	String id;
	String comment;
	String by_mp;
}
