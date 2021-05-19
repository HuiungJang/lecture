package com.websocket.controller;

import com.google.gson.Gson;
import com.websocket.model.vo.MessageTest;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class JsonDecoder implements Decoder.Text<MessageTest> {

    @Override
    public MessageTest decode(String s) throws DecodeException {


        return new Gson().fromJson(s,MessageTest.class);
    }

    @Override
    public boolean willDecode(String s) {
        // false이면 디코딩이 되지 않는다.
        // true로 바꿔주자
        return true;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
