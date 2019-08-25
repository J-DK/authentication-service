package com.auth.login.model;


public interface SignupUserRequestResponse {

    public class SignupUserRequest extends BaseRequestResponse.BaseRequest {

        private String firstName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

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

        private String lastName;

        private String mobile;

        private String email;

        private String password;
    }

    public class SignupUserResponse extends BaseRequestResponse.BaseResponse {

    }
}
