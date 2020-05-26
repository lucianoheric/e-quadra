package com.tribosoftec.equadra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tribosoftec.equadra.domains.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
