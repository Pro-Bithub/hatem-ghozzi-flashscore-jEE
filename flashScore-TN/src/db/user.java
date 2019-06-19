package db;

public class user {
private	String name;
private	String password;
private	String type;
private	Integer userid;
public user(String name , String password ,String type, Integer userid) {
	setName(name);
	setPassword(password);
	setUserid(userid);
	setType(type);
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Integer getUserid() {
	return userid;
}
public void setUserid(Integer userid) {
	this.userid = userid;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
}
