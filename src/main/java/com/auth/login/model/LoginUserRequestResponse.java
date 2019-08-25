package com.auth.login.model;


public interface LoginUserRequestResponse {

    public class LoginUserRequest extends BaseRequestResponse.BaseRequest {

        private String email;

        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public class LoginUserResponse extends BaseRequestResponse.BaseResponse {

        private String email;

        private String userName;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }


    }
}
