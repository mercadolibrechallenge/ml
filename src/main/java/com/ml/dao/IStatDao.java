package com.ml.dao;


import org.springframework.data.repository.CrudRepository;


import com.ml.entities.Stat;




public interface IStatDao extends CrudRepository<Stat, Long>{
	
	long countByType(String type);
}
