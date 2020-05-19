package com.nagarro.notificationapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.notificationapp.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
