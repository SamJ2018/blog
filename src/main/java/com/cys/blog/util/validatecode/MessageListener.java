package com.cys.blog.util.validatecode;

import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-18-11:48
 **/
@Component
public class MessageListener {

    @Autowired
    private MessageSender messageSender;

    public MessageListener() { }

    public void readMessage(Map<String, String> dataMap) throws ClientException {
        this.messageSender.sendSms((String)dataMap.get("signName"), (String)dataMap.get("templateCode"), (String)dataMap.get("mobile"), (String)dataMap.get("param"));
    }
}
