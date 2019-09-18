package com.cys.blog.util.validatecode;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-18-11:50
 **/
@Component
public class MessageSender {
    static final String product = "Dysmsapi";
    static final String domain = "dysmsapi.aliyuncs.com";
    @Autowired
    private Environment environment;

    public MessageSender() {
    }

    public SendSmsResponse sendSms(String signName, String templateCode, String mobile, String param) throws ClientException {
        String accessKeyId = this.environment.getProperty("accessKeyId");
        String accessKeySecret = this.environment.getProperty("accessKeySecret");
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dysmsapi", "dysmsapi.aliyuncs.com");
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(mobile);
        request.setSignName(signName);
        request.setTemplateCode(templateCode);
        request.setTemplateParam(param);
        request.setOutId("yourOutId");
        SendSmsResponse sendSmsResponse = (SendSmsResponse) acsClient.getAcsResponse(request);
        return sendSmsResponse;
    }

    public QuerySendDetailsResponse querySendDetails(String bizId, String mobile) throws ClientException {
        String accessKeyId = this.environment.getProperty("accessKeyId");
        String accessKeySecret = this.environment.getProperty("accessKeySecret");
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dysmsapi", "dysmsapi.aliyuncs.com");
        IAcsClient acsClient = new DefaultAcsClient(profile);
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        request.setPhoneNumber(mobile);
        request.setBizId(bizId);
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        request.setSendDate(ft.format(new Date()));
        request.setPageSize(10L);
        request.setCurrentPage(1L);
        QuerySendDetailsResponse querySendDetailsResponse = (QuerySendDetailsResponse) acsClient.getAcsResponse(request);
        return querySendDetailsResponse;
    }
}
