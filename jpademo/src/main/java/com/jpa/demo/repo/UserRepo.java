package com.jpa.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.demo.entity.User;

public interface UserRepo extends CrudRepository<User,Integer> {
	public List<User> findByName(String name);
	public List<User> findByNameAndCity(String name,String city);
	@Query("Select u from User u")
	public List<User> all();
	@Query("Select u from User u WHERE u.name=:n")
	public List<User> withName(@Param("n") String name);
	@Query(value="Select * from user",nativeQuery=true)
	public List<User> allsql();
}
