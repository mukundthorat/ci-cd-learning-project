package com.example.ci_cd_demo.repository;


import com.example.ci_cd_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {

}
