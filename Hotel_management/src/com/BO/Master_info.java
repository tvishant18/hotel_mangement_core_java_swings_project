package com.BO;

public class Master_info {
private String Username;
private String Password;
private String Secret_question;
private String Secret_answer;
private String New_password;
public String getNew_password() {
	return New_password;
}
public void setNew_password(String new_password) {
	New_password = new_password;
}
public String getRetype_password() {
	return Retype_password;
}
public void setRetype_password(String retype_password) {
	Retype_password = retype_password;
}
private String Retype_password;
public String getUsername() {
	return Username;
}
public void setUsername(String username) {
	Username = username;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getSecret_question() {
	return Secret_question;
}
public void setSecret_question(String secret_question) {
	Secret_question = secret_question;
}
public String getSecret_answer() {
	return Secret_answer;
}
public void setSecret_answer(String secret_answer) {
	Secret_answer = secret_answer;
}
}
