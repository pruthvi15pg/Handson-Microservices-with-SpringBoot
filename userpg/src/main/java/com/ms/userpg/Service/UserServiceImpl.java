package com.ms.userpg.Service;


import com.ms.userpg.Entity.Role;
import com.ms.userpg.Entity.User;
import com.ms.userpg.Model.UserRequest;
import com.ms.userpg.Model.UserResponse;
import com.ms.userpg.Repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import jakarta.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Service
@Log4j2
public class UserServiceImpl implements UserService{

    @Autowired
  private UserRepository userRepository;





    @Override
    public UserResponse saveUser(UserRequest userRequest,HttpServletRequest req) {

        log.info("userRequest:{}",userRequest);
        String ipaddr=req.getRemoteAddr();

        User user=User.builder()
                 .userName(userRequest.getUserName())
                 .email(userRequest.getEmail())
                 .lastName(userRequest.getLastName())
                 .firstName(userRequest.getFirstName())
                 .maidenName(userRequest.getMaidenName())
                 .userPassword(userRequest.getUserPassword())
                 .birthDate(userRequest.getBirthDate())
                 .gender(userRequest.getGender())
                 .phone(userRequest.getPhone())
                 .createdDate(Instant.now())
                 .createdBy(userRequest.getUserName())
                 .build();

        log.info("save the user into db",user);
        user.setIp(ipaddr);
        /**
         * Calculating Age from DOB
         *
         * */
        Calendar birthCalendar = Calendar.getInstance();
        birthCalendar.setTime(userRequest.getBirthDate());
        Calendar currentCalendar = Calendar.getInstance();

        int age = currentCalendar.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);
        user.setAge(age);
        userRepository.save(user);

        UserResponse userResponse=UserResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .maidenName(user.getMaidenName())
                .gender(user.getGender())
                .email(user.getEmail())
                .userName(user.getUserName())
                .build();

        log.info("userResponse:",userResponse);
        return userResponse;
    }

    @Override
    public User updateProduct(long id, UserRequest userRequest) {
        return null;
    }


//    public UserResponse mapToUser(User user){
//        UserResponse userResponse=UserResponse.builder()
//                .firstName(user.getFirstName())
//                .lastName(user.getLastName())
//                .maidenName(user.getMaidenName())
//                .gender(user.getGender())
//                .email(user.getEmail())
//                .userName(user.getUserName())
//                .build();
//        return  userResponse;
//    }
}
