package com.auth.login.controller;

import com.auth.login.model.ForgotPasswordRequestResponse.ForgotPasswordResponse;
import com.auth.login.model.LoginUserRequestResponse.LoginUserResponse;
import com.auth.login.model.LoginUserRequestResponse.LoginUserRequest;
import com.auth.login.model.SignupUserRequestResponse.SignupUserResponse;
import com.auth.login.model.SignupUserRequestResponse.SignupUserRequest;
import com.auth.login.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
@Api(value = "APIs for Login service")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    @ApiOperation(value = "Login User API", response = String.class)
    @ApiResponses({ @ApiResponse(code = 200, message = "Login Successful"),
            @ApiResponse(code = 404, message = "API Not Found") })
    public LoginUserResponse login(@RequestBody LoginUserRequest loginUserRequest) {
        return userService.loginUser(loginUserRequest);
    }

    @PostMapping("signup")
    @ResponseBody
    @ApiOperation(value = "Signup User API", response = SignupUserResponse.class)
    @ApiResponses({ @ApiResponse(code = 200, message = "Registration Successful"),
            @ApiResponse(code = 404, message = "API Not Found") })
    public SignupUserResponse signup(@RequestBody SignupUserRequest registerUserRequest) {
        return userService.createUser(registerUserRequest);
    }

    @PutMapping("login/password")
    @ResponseBody
    @ApiOperation(value = "Forgot password API", response = SignupUserResponse.class)
    @ApiResponses({ @ApiResponse(code = 200, message = "Registration Successful"),
            @ApiResponse(code = 404, message = "API Not Found") })
    public ForgotPasswordResponse forgotPassword(@RequestParam String email) {
         return userService.forgotPassword(email);
    }
}
