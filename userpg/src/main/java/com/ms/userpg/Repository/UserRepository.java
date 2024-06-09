package com.ms.userpg.Repository;


import com.ms.userpg.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
//    User findByUserName(String userName);
//    User findByGenderAndBirthDate(String gender,String birthDate);
//    User findByFirstName(String firstName);
//    User findByLastName(String lastName);
}
