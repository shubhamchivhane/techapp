package com.jarvis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jarvis.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
