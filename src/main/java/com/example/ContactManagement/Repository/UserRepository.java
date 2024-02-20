package com.example.ContactManagement.Repository;

import com.example.ContactManagement.Entity.UserObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserObject, Long> {
}