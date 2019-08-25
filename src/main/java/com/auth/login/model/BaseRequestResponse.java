package com.auth.login.model;

public interface BaseRequestResponse {

    public class BaseRequest {
        /**
         * Basic Request Template
         */
    }

    /**
     * Basic Response Response of all Response models.
     */
    public class BaseResponse {

        private String code;

        private String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }
}
