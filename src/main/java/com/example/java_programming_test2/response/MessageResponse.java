package com.example.java_programming_test2.response;

public class MessageResponse {

    private String message;

    public MessageResponse(String message){
        this.message = message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
