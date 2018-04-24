package com.qfjy.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import com.qfjy.bean.Users;
/**
  Repository是一个空接口。代表一种标记作用。
 */
//public interface UsersDao extends Repository<Users, Integer> {
//@RepositoryDefinition(domainClass=Users.class,idClass=Integer.class)

public interface UsersDao extends Repository<Users, Integer>{	
	//方法定义规范 方法名中：get | read | find
	//根据ID查询实体对象
	/**
	  1、方法名进行字符串解析（从右至左）
	  select * from users where id=?1
	  2、entityManager.createQuery(jpql);
	  3、 query.getSingleResult(); // query.getResultList();
	    query.executeUpdate();
	 */
	public Users getById(Integer id);
	//Users表中所有的数据全部查询出来
	public List<Users> getByUname(String uname);
	
	//And 查询想根据姓名 且 年龄  select * from users where age=? and uname=?
	public Users getByAgeAndUname(int age,String uname);
	//Or
	public List<Users> getByAgeOrUname(int age,String uname);
	//Between 查询年龄在20到30之间的用户
	public List<Users> getByAgeBetween(int min,int max);
	//查询年龄在20-30的用户，且姓名叫董天峰 的人
	public List<Users> getByAgeBetweenAndUname(int min,int max,String uname);
	//查看没有姓名的用户 uname is null   or uname=""
	public List<Users> findByUnameIsNullOrUname(String uname);
	//查询所有姓董的同学 Like 默认前后都不加%号。
	public List<Users> findByUnameLike(String uname);
	//StartingWith 默认语法后%  董%
	public List<Users> findByUnameStartingWith(String uname);
	//OrderBy
	//查询所有姓董的同学，且年龄在20-30之间， 根据 年龄排序（按降序）
	//from users where uname like '董%' and age between 20,30  order by age desc
	public List<Users> getByUnameStartingWithAndAgeBetweenOrderByAgeDesc(
			String uname,int min ,int max);
	//表的总记录数
	public int count();	
	
	/**
	   优点：简单、快捷，
	     复杂的SQL语句，方法名过长，方法知其意。
	  缺点：复杂查询无法实现。
	  子查询
	 */
	/**
	  查询：entityManager.createQuery(jpql);
	     entityManager.createNativeQuery(sql);
	 */
	//查询最大年龄的学生信息 select * from users where age in (select max(age) from users); 
	@Query(value="select u from Users u where age in ( select max(age) from Users )") // entityManager.createQuery(jpql);
	public List<Users> getMaxAge();
	//select * from users where age in (select max(age) from users)
	@Query(value="select * from users where age in (select max(age) from users)",
			nativeQuery=true)
	public List<Users> getMaxNativeAge();
	/**
	   方法传参三种 方式：
	   Query query=entityManager.createQuery()/createNativeQuery;
	   query.setParameter();
	    1、 ?  下标0
	    2、?1  1
	    3、:uname   String uname    在方法参数中要加@Param注解
	 */
	//select * from users  where age in ( select max(age) from users)  and uname like '董%' 
	// 查询所有姓董的学生，年龄最大的学生信息
	@Query(value="SELECT u FROM Users u WHERE age IN "
			+ "(SELECT max(age) FROM Users ) and uname like :uname  ")
	public List<Users> getMaxAgeAndUname(@Param("uname")String unafdsafdsaame);
	//@Query 根据用户名和年龄 查询学生信息
	@Query(value="select * from users where uname=?1 and age=?2",
			nativeQuery=true)
	public List<Users> getUnameAndAge(String uname ,int age);
	
	@Query(value="select * from users where uname=:uname and age=:age ",
			nativeQuery=true)
	public List<Users> getUnameAndAge1(@Param("age")int age123,@Param("uname")String uname123
			);
	
	
	/**
	 JPA(J2EE提供一系列规范接口声明）
	 Hibernate(是JPA的实现产品）
	 
	 SpringData:(JPA进行了进一步封装）
	 
	 增删改 功能
	 @Modifying和@Query注解统一使用
	 默认情况下，Jpa只对查询加了事务管理。 增删改操作 都需要自定义添加事务。(Service层中）
	   
	 */
	//根据ID修改年龄。自定义，删除/修改    
	// int num=query.executeUpdate();
	@Modifying
	@Query(value="update users set age=?1 where id=?2",nativeQuery=true)
	public int updateAgeById(int age,int id);
	
	//能添加   MyBatis底层是JDBC
	@Modifying
	@Query(value="insert into users(uname,age) values(:uname,:age)",nativeQuery=true)
	public int  add(@Param("uname")String uname,@Param("age")int age);
	
	
	
	
}
