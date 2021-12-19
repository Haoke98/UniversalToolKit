package io.github.Haoke98.util.sms;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import io.github.Haoke98.model.templates.ali.AliTemplate;
import lombok.Setter;

@Setter
public class SmsAli {


    public static CommonResponse DomesticSend(String accessKeyId, String accessKeySecret, String sign, String tel, AliTemplate template) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", tel);
        request.putQueryParameter("SignName", sign);
        request.putQueryParameter("TemplateCode", template.getCode());
        request.putQueryParameter("TemplateParam", template.getParamsAsJson());
        System.out.println(template.getParamsAsJson());
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return response;
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }
}
