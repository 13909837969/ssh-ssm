package com.qfjy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qfjy.bean.Users;
import com.qfjy.dao.UsersDao;

@Service
public class UsersServiceImpl {
	@Autowired
	UsersDao usersDao;

	// 根据ID查询实体对象
	public Users getById(Integer id) {
		return usersDao.getById(id);
	}

	public List<Users> getByUname(String uname) {
		System.out.println("实现类：" + usersDao);
		return usersDao.getByUname(uname);
	}

	// 查询想根据姓名 且 年龄 select * from users where age=? and uname=?
	public Users getByAgeAndUname(int age, String uname) {
		return usersDao.getByAgeAndUname(age, uname);
	}

	//
	public List<Users> getByAgeOrUname(int age, String uname) {
		return usersDao.getByAgeOrUname(age, uname);
	}

	// Between 查询年龄在20到30之间的用户
	public List<Users> getByAgeBetween(int min, int max) {
		return usersDao.getByAgeBetween(min, max);
	}
	//查询年龄在20-30的用户，且姓名叫董天峰 的人
	public List<Users> getByAgeBetweenAndUname(int min,int max,String uname){
		return usersDao.getByAgeBetweenAndUname(min, max, uname);
	}
	//查看没有姓名的用户 uname is null   or uname=""
		public List<Users> findByUnameIsNullOrUname(String uname){
			return usersDao.findByUnameIsNullOrUname(uname);
		}
		//查询所有姓董的同学 Like
		public List<Users> findByUnameLike(String uname){
			return usersDao.findByUnameLike(uname);
		}
		//查询所有姓董的同学 Like
		public List<Users> findByUnameStartingWith(String uname){
			return usersDao.findByUnameStartingWith(uname);
		}
		//
		//查询所有姓董的同学，且年龄在20-30之间， 根据 年龄排序（按降序）
		//from users where uname like '董%' and age between 20,30  order by age desc
		public List<Users> getByUnameStartingWithAndAgeBetweenOrderByAgeDesc(
				String uname,int min ,int max){
			return usersDao.getByUnameStartingWithAndAgeBetweenOrderByAgeDesc(uname, min, max);
		}
		//表的总记录数
		public int count(){
			return (int) usersDao.count();
		}
}
