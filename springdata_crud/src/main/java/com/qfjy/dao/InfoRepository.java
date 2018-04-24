package com.qfjy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.qfjy.bean.Info;

public interface InfoRepository extends JpaRepository<Info,Integer>
{

	
}
