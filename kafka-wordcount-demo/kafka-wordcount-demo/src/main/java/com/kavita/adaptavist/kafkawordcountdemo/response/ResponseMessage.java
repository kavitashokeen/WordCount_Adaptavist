package com.kavita.adaptavist.kafkawordcountdemo.response;

public class ResponseMessage {
    private String mesg;

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }

    public ResponseMessage() {
    }

    public ResponseMessage(String mesg) {
        super();
        this.mesg = mesg;
    }
}
