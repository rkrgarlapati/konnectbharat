package com.kb.sms;

/**
 * Created by garlapati on 6/17/2017.
 */
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
public class HttpUrlPush {
    public static void main(String ...args)throws IOException {
        HttpClient client=null;
        PostMethod post=null;
        String sURL;
        client = new HttpClient(new MultiThreadedHttpConnectionManager());
/* Set your proxy settings */
        //client.getHostConfiguration().setProxy("Your Proxy", ProxyPort);
        client.getHttpConnectionManager().getParams().setConnectionTimeout(30000);//set
        //your time
        sURL = " http://smslane.com/vendorsms/pushsms.aspx";
        //sURL = "http://apps.smslane.com/vendorsms/pushsms.aspx";
        post = new PostMethod(sURL);
        //give all in string
        post.addParameter("user", "hex123");
        post.addParameter("password", "hex1234?");
        post.addParameter("msisdn", "919562862929");
        post.addParameter("msg", "This is to inform that 211 thanks.");
        post.addParameter("sid","ACCINF");
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
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            post.releaseConnection();
        }
    }
}