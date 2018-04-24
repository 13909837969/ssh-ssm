package com.qfjy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.qfjy.bean.Info;
import com.qfjy.dao.InfoRepository;
@Service
public class InfoCrudRepostiry {

	@Autowired
	InfoRepository infor;
	//添加
	public void add(Info r)
	{
		infor.save(r);
	}
	//删除
	public void delete(Integer id)
	{
		infor.delete(id);
	}
	//批量删除
	public void delBatch(List<Info> list)
	{
		infor.delete(list);
	}
	//findOne
	public Info getInfosById(Integer id)
	{
		return infor.findOne(id);
	}
	//findAll
	public List<Info>findAll()
	{
		List<Info> list = (List<Info>) infor.findAll();
		return list;
	}
	//分页和排序
	//第一种分页
	public Page<Info> pageOper(int currtPage,int pageSize)
	{
		
		Pageable pageable = new PageRequest(currtPage, pageSize);
		Page<Info> page = infor.findAll(pageable);
		return page;
	}
	//第二种分页 分页+排序
	public Page<Info> pageSort(int currtPage,int pageSize)
	{
		//根据年龄降序排序 年龄相同根据name进行升序排序
		Order orders1 = new Sort.Order(Direction.DESC,"age");
		Order orders2 = new Sort.Order(Direction.ASC,"name");

		Sort sort = new Sort(orders1,orders2); 
		//Pageable pageable = new PageRequest(currtPage, pageSize,Direction.DESC,"age");
		Pageable pageable = new PageRequest(currtPage, pageSize,sort);
		
		Page<Info> page = infor.findAll(pageable);
		return page;
		
		
		
		
	}
	
	
}
