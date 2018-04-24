package com.qfjy.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;

import com.qfjy.bean.Info;
import com.qfjy.bean.Users;
import com.qfjy.dao.InfoRepository;
import com.qfjy.service.impl.InfoCrudRepostiry;
import com.qfjy.service.impl.UsersServiceImpl;

import javassist.ClassPath;

public class InfoCrudTest {
	
	@Test
	public void test1()
	{
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring_core.xml");
		InfoCrudRepostiry infoImpl=(InfoCrudRepostiry) ctx.getBean("infoCrudRepostiry");
		Info ind = infoImpl.getInfosById(3);
		System.out.println(ind);
	}
	
	@Test
	public void test2()
	{
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring_core.xml");
		InfoCrudRepostiry infoImpl=(InfoCrudRepostiry) ctx.getBean("infoCrudRepostiry");
		List<Info> ind = infoImpl.findAll();
		for(Info inf : ind)
		{
			System.out.println(inf);
		}
	}
	//分页
	@Test
	public void test3()
	{
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring_core.xml");
		InfoCrudRepostiry infoImpl=(InfoCrudRepostiry) ctx.getBean("infoCrudRepostiry");
		Page<Info> ind = infoImpl.pageOper(1, 2);
		for(Info inf : ind)
		{
			System.out.println(inf.getId()
					+"\t"+inf.getName());
		}
		System.out.println("下标索引从0开始");
		System.out.println("当前页："+ind.getNumber());
		System.out.println("不知道："+ind.getNumberOfElements());
		System.out.println("总页数："+ind.getSize());
		System.out.println("总记录数："+ind.getTotalElements());
	}
	//排序+分页
	@Test
	public void test4()
	{
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring_core.xml");
		InfoCrudRepostiry infoImpl=(InfoCrudRepostiry) ctx.getBean("infoCrudRepostiry");
		Page<Info> ind = infoImpl.pageSort(0, 4);
		for(Info inf : ind)
		{
			System.out.println(inf.getId()
					+"\t"+inf.getName());
		}
	}
	
	@Test
	public void test5()
	{
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring_core.xml");
		InfoCrudRepostiry infoImpl=(InfoCrudRepostiry) ctx.getBean("infoCrudRepostiry");
		Page<Info> ind = infoImpl.pageSort(0, 4);
		for(Info inf : ind)
		{
			System.out.println(inf.getId()
					+"\t"+inf.getName());
		}
	}
	
	
	
	
}
