package com.zhangweinan;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.zhangweinan.model.enums.WebsiteCodeEnum;
import com.zhangweinan.model.exception.WebsiteException;
import com.zhangweinan.util.CodesUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LegoApplicationTests {

	@Test
	public void contextLoads() {

	}

	String accessId = "LTAIFzlFvqfN2kmi";

	String accessKey = "Q9H62dfWXSbHcEeXONZQJKjbVEDAc0";
	@Test
	public void testException(){
		DefaultProfile profile = DefaultProfile.getProfile("default", accessId, accessKey);
		IAcsClient client = new DefaultAcsClient(profile);

		CommonRequest request = new CommonRequest();
		//request.setProtocol(ProtocolType.HTTPS);
		request.setMethod(MethodType.POST);
		request.setDomain("dysmsapi.aliyuncs.com");
		request.setVersion("2017-05-25");
		request.setAction("SendSms");
		request.putQueryParameter("PhoneNumbers", "15657161560");
		request.putQueryParameter("RegionId", "default");
		request.putQueryParameter("SignName", "lego");
		request.putQueryParameter("TemplateCode", "SMS_162739150");
        HashMap<String, String> map = new HashMap<>();
        map.put("code", CodesUtil.getCodex(4));
        request.putQueryParameter("TemplateParam", JSON.toJSONString(map));
		try {
			CommonResponse response = client.getCommonResponse(request);
			System.out.println(response.getData());
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}

	@Test
    public void test2(){
        DefaultProfile profile = DefaultProfile.getProfile("default", "LTAIFzlFvqfN2kmi", "Q9H62dfWXSbHcEeXONZQJKjbVEDAc0");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", "15657161560");
        request.putQueryParameter("SignName", "lego");
        request.putQueryParameter("TemplateCode", "SMS_162739150");
        HashMap<String, String> map = new HashMap<>();
        map.put("code", CodesUtil.getCodex(4));
        request.putQueryParameter("TemplateParam", JSON.toJSONString(map));
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

}
