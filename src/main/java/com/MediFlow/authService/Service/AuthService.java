package com.MediFlow.authService.Service;

import com.MediFlow.authService.Model.Response;
import com.MediFlow.authService.Model.UserFormRequest;

public interface AuthService {
    Response createUserData(UserFormRequest request);

    Response authenticateUser(UserFormRequest request);
}
