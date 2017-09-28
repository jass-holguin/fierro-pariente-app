package com.nearsoft.application.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.StringJoiner;

@RedisHash("fierro_messages")
@JsonIgnoreProperties(ignoreUnknown = true)
public class FierroMessage {

    @Id
    private String id;
    private String msg;

    public FierroMessage() {
    }

    public FierroMessage(String msg) {
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("id = " + id)
                .add("msg = " + msg)
                .toString();
    }
}


