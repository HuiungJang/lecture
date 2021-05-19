package com.websocket.model.vo;

public class MessageTest {
    private String sender;
    private String receiver;
    private String msg;

    public MessageTest() {
    }

    public MessageTest(String sender, String receiver, String msg) {
        this.sender = sender;
        this.receiver = receiver;
        this.msg = msg;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return  "sender='" + sender +
                ", receiver='" + receiver +
                ", msg='" + msg;
    }
}
