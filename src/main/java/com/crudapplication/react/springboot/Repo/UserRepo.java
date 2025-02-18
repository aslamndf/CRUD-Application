package com.crudapplication.react.springboot.Repo;

import com.crudapplication.react.springboot.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
