package com.test.sp;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;



@Controller

public class JsonTest {
    @RequestMapping(value = "/postjson")
    @ResponseBody
    public String postJson(HttpServletRequest request){
        return "this is postjson";
    }

    @RequestMapping(value = "/readjson",method = RequestMethod.POST)
    @ResponseBody
    public String readJson(HttpServletRequest request){
        String jsonstr = request.getParameter("jsonstr");

        Object obj = JSON.parseObject(jsonstr);
        System.out.println(obj);
        return jsonstr;
    }
}
