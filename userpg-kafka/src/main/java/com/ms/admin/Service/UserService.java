package com.ms.userpg.Service;

import com.ms.userpg.Entity.User;
import com.ms.userpg.Model.UserRequest;
import com.ms.userpg.Model.UserResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

public interface UserService {


    UserResponse saveUser(UserRequest userRequest,HttpServletRequest req);

    User updateProduct(long id, UserRequest userRequest);
}
