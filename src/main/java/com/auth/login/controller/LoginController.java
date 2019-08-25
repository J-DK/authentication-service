package com.auth.login.controller;

import com.auth.login.model.User;
import com.auth.login.service.MailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Api(value = "APIs for Login service")
public class LoginController {

    @Autowired
    private MailService mailService;

    @Autowired
    private User receiver;

    @Value("${login.receiver.email}")
    private String receiverMail;

    @GetMapping(value = "mail")
    @ApiOperation(value = "Login User API", response = String.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully Logged in"),
            @ApiResponse(code = 404, message = "API Not Found") })
    public String sendMail() {
        receiver.setEmailAddress(receiverMail);

        try {
            mailService.sendEmail(receiver);
        } catch (MailException mailException) {
            System.out.println(mailException.getLocalizedMessage());
        }
        return "Congratulations! Your mail has been sent to the mail" + receiverMail;
    }
}
