package com.MediFlow.authService.Controller;

import com.MediFlow.authService.Model.Response;
import com.MediFlow.authService.Model.UserFormRequest;
import com.MediFlow.authService.Service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService authService) {
        this.service = authService;
    }



    @PostMapping("/register")
    public Response createUser(@RequestBody UserFormRequest request){
        return service.createUserData(request);
    }

    @PostMapping("/authenticate")
    public Response authenticateUser(@RequestBody UserFormRequest request){
        return service.authenticateUser(request);
    }
}
