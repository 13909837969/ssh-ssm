package com.qfjy.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qfjy.bean.Users;
import com.qfjy.service.impl.UsersServiceImpl;

import javassist.ClassPath;

public class UsersTest {
	
	@Test
	public void t1(){
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring_core.xml");
	
		UsersServiceImpl uImpl=(UsersServiceImpl) ctx.getBean("usersServiceImpl");
//		int id=8;
//		Users users=uImpl.getById(id);
//		System.out.println(users.getId()+"\t"+users.getUname());
		
//		List<Users> list=uImpl.getByUname("董天峰2");
//		for(Users u :list){
//			System.out.println(u.getUname()+"\t"+u.getId());
//		}
	
	
//		//查询想根据姓名 且 年龄
//		Users u=uImpl.getByAgeAndUname(21,"董天峰2");
//		System.out.println(u.getUname()+"\t"+u.getId());
	
//		List<Users> list=uImpl.getByAgeOrUname(21, "董天峰2");
//		for(Users u :list){
//			System.out.println(u.getUname()+"\t"+u.getId());
//		}
		
		List<Users> list=uImpl.getByUnameStartingWithAndAgeBetweenOrderByAgeDesc
				("董",20,30);
		for(Users u :list){
			System.out.println(u.getUname()+"\t"+u.getId()+"\t"+u.getAge());
		}
		
		int num=uImpl.count();
		System.out.println("总记录数是："+num);
	}
}
