package com.qfjy.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;

import com.qfjy.bean.Users;
/**
  Repository是一个空接口。代表一种标记作用。
 */
//public interface UsersDao extends Repository<Users, Integer> {
//@RepositoryDefinition(domainClass=Users.class,idClass=Integer.class)

public interface UsersDao extends JpaRepository<Users, Integer>{	
	//方法定义规范 方法名中：get | read | find
	//根据ID查询实体对象
	/**
	  1、方法名进行字符串解析（从右至左）
	  select * from users where id=?1
	  2、entityManager.createQuery(jpql);
	  3、 query.getSingleResult(); // query.getResultList();
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
	public long count();	
}
