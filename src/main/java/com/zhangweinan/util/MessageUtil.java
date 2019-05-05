package com.zhangweinan.util;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eric on 2019/4/22.
 */
public class MessageUtil {

    private static final String accessId = "LTAIFzlFvqfN2kmi";
    private static final String accessSecret = "Q9H62dfWXSbHcEeXONZQJKjbVEDAc0";
    private static final String SignName = "lego";
    private static final String TemplateCode = "SMS_162739150";


    public static boolean sendMessage(String code, String phoneNumber){

        DefaultProfile profile = DefaultProfile.getProfile("default", accessId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();

        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", SignName);
        request.putQueryParameter("TemplateCode", TemplateCode);
        HashMap<String, String> map = new HashMap<>();
        map.put("code", CodesUtil.getCodex(4));
        request.putQueryParameter("TemplateParam", JSON.toJSONString(map));
        try {
            CommonResponse response = client.getCommonResponse(request);
            Map result = JSON.parseObject(response.getData(), HashMap.class);
            String resultCode = (String) result.get("Code");
            if ("OK".equals(resultCode)){
                return true;
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }
}
