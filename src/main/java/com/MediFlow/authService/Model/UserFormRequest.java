package com.MediFlow.authService.Model;

public record UserFormRequest(String name,String role,String email,String phone,String password,String confirmPassword) {
}
