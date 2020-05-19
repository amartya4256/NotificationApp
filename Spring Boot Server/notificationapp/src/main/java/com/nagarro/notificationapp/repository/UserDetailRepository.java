package com.nagarro.notificationapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.notificationapp.entity.UserDetail;

public interface UserDetailRepository extends CrudRepository<UserDetail, String> {

}
