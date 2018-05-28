package com.course.model;

import lombok.Data;

@Data
public class LoginCase {
        private int id;
        private String userName;
        private String passwd;
        private String expected;

        public String getExpected() {
                return expected;
        }
}
