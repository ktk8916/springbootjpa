package com.example.demo.member.exception;

public class MemberNotFoundException extends NullPointerException{
    public MemberNotFoundException(String s) {
        super(s);
    }
}
