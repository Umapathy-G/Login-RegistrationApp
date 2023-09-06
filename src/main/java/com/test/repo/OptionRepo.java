package com.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.Option;
import java.util.List;


public interface OptionRepo extends JpaRepository<Option, Integer>{
	
	public List<Option> findByName(String name);
}
