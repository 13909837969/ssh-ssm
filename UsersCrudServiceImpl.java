package com.qfjy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.qfjy.bean.Users;
import com.qfjy.dao.UsersRepository;

@Service
public class UsersCrudServiceImpl {
	@Autowired
	UsersRepository usersR;
	
	/**
	 * 增删改查
	 */
	public void add(Users u){
		usersR.save(u);
	}
	/**
	 * 删除
	 */
	public void del(int id){
		usersR.delete(id);
	}
	/**
	 * 批量删除  1,2,3,4,5,6,7
	 *  1、 delete Users where id=1
	 *  1、 delete Users where id=2
	 *  1、 delete Users where id=3
	 *  1、 delete Users where id=4
	 *  1、 delete Users where id=5
	 *  1、 delete Users where id=6
	 *  
	 *  2、delete Users where id=1 or id =2 or id=3 or =id=4
	 *  int[] ids={1,2,3,4};
	 *  String sql=" delete Users where 1=1"
	 *  for(int i=0;i<ids.length;i++){
	 *  	sql+="or id="+ids[i];
	 *  }
	 *  
	 *  delete from Users
	 *  
	 */
	//CrudRepository
	public void delBatch(List<Users> list){
		usersR.delete(list);
	}
	//JpaRepository
	public void delInBatch(List<Users> list){
		usersR.deleteInBatch(list);
	}
	public List<Users> getAll(){
		return (List<Users>) usersR.findAll();//查询所有数据
	}
	/**
	 findOne  find()//查询方式
	 */
	public Users getUsersById(Integer id){
		return usersR.findOne(id);  
	}
	
	/**
	 * 分页功能
	 * pageNum:当前页数
	 * pageSize:每页大小
	 */
	public Page<Users> pageOper(int pageNum,int pageSize){
		//排序：根据年龄 降序、 如果年龄相同，姓名按升序
		Order order1=new Sort.Order(Direction.DESC,"age");//年龄降序
		Order order2=new Sort.Order(Direction.ASC,"uname");//姓名升序
		
		Sort sort=new Sort(order1,order2);
		Pageable pageable=new PageRequest(pageNum, pageSize, sort);
	//----------------------------------------------------------------------------------	
		//根据年龄，降序排列，如果年龄相同，根据姓名排序
	//	Pageable pageable=new PageRequest(pageNum,pageSize,Direction.DESC,"age","uname");
		//根据年龄，降序排列
		//Pageable pageable=new PageRequest(pageNum,pageSize,Direction.DESC,"age");
		//分页功能（默认无排序）
		//Pageable pageable=new PageRequest(pageNum,pageSize);
		//分页功能
		Page<Users> page=usersR.findAll(pageable);
				
		return page;
	}

}
