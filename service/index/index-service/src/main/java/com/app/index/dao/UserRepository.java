package com.app.index.dao;

import com.app.index.domain.po.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.stream.Stream;

public interface UserRepository extends CrudRepository<User, Long> {

    @Async
    Stream<User> findAllByIsDelIsNotNull();

}