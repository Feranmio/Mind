package ePetition;

public class Petition {


public String getCreator() {
	return creator;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
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
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}

public void setCreator(String creator) {
	this.creator = creator;
}
int sign;
public int getSign() {
	return sign;
}
public void setSign(int sign) {
	this.sign = sign;
}
public Petition(int sign, String id, String title, String content, String date, String creator) {
	super();
	this.sign = sign;
	this.id = id;
	this.title = title;
	this.content = content;
	this.date = date;
	this.creator = creator;
}

String id;
String title;
String content;
String date;
String creator;

}
