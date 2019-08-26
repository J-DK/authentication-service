package com.auth.login.service;

import com.auth.login.model.ForgotPasswordRequestResponse.ForgotPasswordResponse;
import com.auth.login.model.LoginUserRequestResponse.LoginUserResponse;
import com.auth.login.model.LoginUserRequestResponse.LoginUserRequest;
import com.auth.login.model.SignupUserRequestResponse.SignupUserResponse;
import com.auth.login.model.SignupUserRequestResponse.SignupUserRequest;

public interface UserService {

    SignupUserResponse createUser(SignupUserRequest signupUserRequest);

    LoginUserResponse loginUser(LoginUserRequest loginUserRequest);

    ForgotPasswordResponse forgotPassword(String email);
}
