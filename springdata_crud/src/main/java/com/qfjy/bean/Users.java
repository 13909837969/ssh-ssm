package com.qfjy.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
// java bean包名  ：pojo   bean   entity  domain
public class Users {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
   private String uname;
   private int age;
   private Date currtDate;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Date getCurrtDate() {
	return currtDate;
}
public void setCurrtDate(Date currtDate) {
	this.currtDate = currtDate;
}
public Users() {
	super();
}
@Override
public String toString() {
	return "Users [id=" + id + ", uname=" + uname + ", age=" + age + ", currtDate=" + currtDate + "]";
}
   
}
