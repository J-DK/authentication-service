package com.auth.login.service.impl;

import com.auth.login.entity.User;
import com.auth.login.model.LoginUserRequestResponse.LoginUserResponse;
import com.auth.login.model.LoginUserRequestResponse.LoginUserRequest;
import com.auth.login.model.SignupUserRequestResponse.SignupUserRequest;
import com.auth.login.model.SignupUserRequestResponse.SignupUserResponse;
import com.auth.login.repository.UserRepository;
import com.auth.login.service.UserService;
import com.auth.login.util.EncryptionUtil;
import com.auth.login.util.MailSenderUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailSenderUtil mailSenderUtil;

    @Override
    public SignupUserResponse createUser(SignupUserRequest signupUserRequest) {
        SignupUserResponse registerUserResponse = new SignupUserResponse();

        User existingUser = userRepository.findByEmail(signupUserRequest.getEmail());
        if (null != existingUser) {
            registerUserResponse.setCode("1001");
            registerUserResponse.setMessage("There exists a user already with the given email");
        } else {
            User user = new User();
            user.setEmail(signupUserRequest.getEmail());
            user.setFirstName(signupUserRequest.getFirstName());
            user.setLastName(signupUserRequest.getLastName());
            user.setUserName(signupUserRequest.getFirstName() + "_" + signupUserRequest.getLastName()
                    .trim().replace(" ", ""));
            user.setMobile(signupUserRequest.getMobile());
            try {
                if (null != signupUserRequest.getPassword() && !signupUserRequest.getPassword().isEmpty()) {
                    user.setPassword(EncryptionUtil.encrpyt(signupUserRequest.getPassword()));
                }
            } catch (Exception e) {
                LOGGER.debug("Password Encryption Error");
            }


            try {
                userRepository.save(user);
                registerUserResponse.setCode("200");
                registerUserResponse.setMessage("You have been successfully registered");
                String subject = "Welcome to our world!!";
                String content = "Thanks for signing up!! " + user.getUserName() + " is your user name.";
                mailSenderUtil.sendEmail(user.getEmail(), subject, content);
            } catch (Exception ex) {
                registerUserResponse.setCode("1002");
                registerUserResponse
                        .setMessage("It seems that there is an issue while signing up. Please try again");
            }
        }
        return registerUserResponse;

    }

    @Override
    public LoginUserResponse loginUser(LoginUserRequest loginUserRequest) {

        LoginUserResponse loginUserResponse = new LoginUserResponse();


        String email = loginUserRequest.getEmail();
        String password = loginUserRequest.getPassword();
        User user = userRepository.findByEmail(email);
        if (null != user) {
            try {
                String encryptLoginPassword = EncryptionUtil.encrpyt(password);
                if (user.getPassword().equals(encryptLoginPassword)) {
                    loginUserResponse.setUserName(user.getFirstName() + " " + user.getLastName());
                    loginUserResponse.setEmail(email);
                    loginUserResponse.setCode("200");
                    loginUserResponse.setMessage("Successfully logged in!!");
                    String subject = "Welcome to our world!!";
                    String content = "Someone (hopefully you) have been logged in";
                    mailSenderUtil.sendEmail(user.getEmail(), subject, content);
                } else {
                    loginUserResponse.setCode("1003");
                    loginUserResponse.setMessage("Invalid Username or Password");
                }

            } catch (Exception e) {
                LOGGER.debug("{}", e.getLocalizedMessage());
            }
        } else {
            loginUserResponse.setCode("1004");
            loginUserResponse
                    .setMessage("There exists no user registered with the given email-id. Please Sign up first!!");
        }

        return loginUserResponse;
    }
}
