package com.lab.Lab1.repository;

import com.lab.Lab1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository< User,String> {

}
