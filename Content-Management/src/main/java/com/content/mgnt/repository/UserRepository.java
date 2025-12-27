package com.content.mgnt.repository;

import com.content.mgnt.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}