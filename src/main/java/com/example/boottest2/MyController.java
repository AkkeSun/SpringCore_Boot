package com.example.boottest2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    @GetMapping("paramTest")
    @ResponseBody
    public String paramTest(String a, String b, Model model){
        model.addAttribute("model", a+b);
        return "paramTest";
    }

    @GetMapping("/validationTest")
    @ResponseBody
    public List<String> validationTest(@Validated(MyDto.group2.class) MyDto dto,
                                       BindingResult bindingResult){

        List<String> list = new ArrayList<>();
        if(bindingResult.hasErrors()){
            List<String> errMsgs = new ArrayList<>();
            for(ObjectError e : bindingResult.getAllErrors()) {
                String errMsg = e.getDefaultMessage();
                errMsgs.add(errMsg);
            }
            return errMsgs;
        }
        list.add(dto.toString());
        return list;
    }

    @GetMapping("/formatterTest/{pwd}")
    @ResponseBody
    public String formatterTest(@PathVariable("pwd") MyDto dto){
        return dto.getId() + dto.getPwd();
    }

    //-----------------------------------------------------------

    @Autowired
    MyService myService;


    @GetMapping("/aopTest")
    @ResponseBody
    public String aopTest(){
        myService.myMethod();
        return "AOP TEST";
    }
}
