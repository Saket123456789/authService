package com.MediFlow.authService;

import com.MediFlow.authService.Entity.User;
import com.MediFlow.authService.Model.Response;
import com.MediFlow.authService.Model.UserFormRequest;
import com.MediFlow.authService.Repository.UserRepo;
import com.MediFlow.authService.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepo repo;
    @Override
    public Response createUserData(UserFormRequest request) {
        Response re= new Response();
        User user = new User();
        user.setEmail(request.email());
        user.setFullName(request.name());
        user.setRole(request.role());
        user.setPassword(request.password());
        user.setPhone(request.phone());
        repo.save(user);
        re.setCode(200);
        re.setMessage("Success Fully Register");
        re.setStatus("Success");

        return re;
    }

    @Override
    public Response authenticateUser(UserFormRequest request) {
        Response re= new Response();
        User user = repo.getUserDetails(request.email());

        if(user.getPassword().equalsIgnoreCase(request.password())){
            re.setCode(200);
            re.setMessage("User IS Authenticated");
            re.setStatus("Success");
        }
        else {
            re.setCode(300);
            re.setMessage("User is Not Authenticated");
            re.setStatus("Failure");
        }



        return re;
    }
}
