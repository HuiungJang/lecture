package com.websocket.controller;

import com.google.gson.Gson;
import com.websocket.model.vo.MessageTest;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class JsonEncoder implements Encoder.Text<MessageTest> {

    @Override
    public String encode(MessageTest messageTest) throws EncodeException {
        return new Gson().toJson(messageTest);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
