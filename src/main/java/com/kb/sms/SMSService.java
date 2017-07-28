package com.kb.sms;

/**
 * Created by garlapati on 6/17/2017.
 */
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Component
public class SMSService {

    @Value("${sms.enable}")
    private Boolean smsEnable;

    @Value("${sms.url}")
    private String smsURL;

    @Value("${sms.userId}")
    private String smsUserId;

    @Value("${sms.password}")
    private String smsPassword;

    //public static void main(String ...args)throws IOException {
    public void sendSMS(String smsType, String... smsParams){
        if(smsEnable) {
            HttpClient client = null;
            PostMethod post = null;
            String sURL;
            client = new HttpClient(new MultiThreadedHttpConnectionManager());
/* Set your proxy settings */
            //client.getHostConfiguration().setProxy("Your Proxy", ProxyPort);
            client.getHttpConnectionManager().getParams().setConnectionTimeout(30000);//set
            //your time
            //sURL = "http://apps.smslane.com/vendorsms/pushsms.aspx";
            post = new PostMethod(smsURL);
            //give all in string
            post.addParameter("user", smsUserId);
            post.addParameter("password", smsPassword);
            post.addParameter("msisdn", "91" + smsParams[0]);

            switch (smsType) {
                case "bride":
                    post.addParameter("msg", "Dear " + smsParams[1] + ", Greetings from KonnectBharat. Thanks for referring the profile related to " +smsParams[2] + ".");
                    post.addParameter("sid", "KTBHBR");
                    break;
                case "groom":
                    post.addParameter("msg", "Dear " + smsParams[1] + ", Greetings from KonnectBharat. Thanks for referring the profile related to " + smsParams[2] + ".");
                    post.addParameter("sid", "KTBHGR");
                    break;
                case "sell":
                    if (smsParams.length == 4) {
                        post.addParameter("msg", "Dear " + smsParams[1] + ", Greetings from KonnectBharat. Thanks for referring the seller party " + smsParams[2] + ". Property located at " + smsParams[3] + ".");
                    } else {
                        post.addParameter("msg", "Dear " + smsParams[1] + ", Greetings from KonnectBharat. Thanks for referring the seller party " + smsParams[2] + ".");
                    }
                    post.addParameter("sid", "KTBHSL");
                    break;
                case "buy":
                    post.addParameter("msg", "Dear " + smsParams[1] + ", Greetings from KonnectBharat. Thanks for referring the buyer party " + smsParams[2] + ".");
                    post.addParameter("sid", "KTBHBY");
                    break;
                case "registration":
                    post.addParameter("msg", "Dear " + smsParams[1] + ", Greetings from KonnectBharat. Your registration is successful.");
                    post.addParameter("sid", "KNTBHA");
                    break;
            }
            //post.addParameter("msg", "Dear Siva, Thanks for referring the profile of groom Balakrishna.");
            //post.addParameter("sid","KTBHGR");
            post.addParameter("fl", "0");
            post.addParameter("gwid", "2");

 /* PUSH the URL */
            try {
                int statusCode = client.executeMethod(post);
                System.out.println(post.getStatusLine().toString());
                if (statusCode != HttpStatus.SC_OK) {
                    System.err.println("Method failed: " + post.getStatusLine());
                }
                System.out.println(post.getResponseBodyAsString());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                post.releaseConnection();
            }
        }
    }
}