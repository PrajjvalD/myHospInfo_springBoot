package com.myhospinfos.oauth.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myhospinfos.oauth.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUserName(String username);
}