package com.example.rabbitmq_demo.controller;

import com.example.rabbitmq_demo.mq.Consumer;
import com.example.rabbitmq_demo.mq.Sender;
import com.example.rabbitmq_demo.pojo.DataMQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.example.rabbitmq_demo.util.TxtUtil.readFile;
import static com.example.rabbitmq_demo.util.TxtUtil.txtMapUtil;

@RequestMapping("/user")
@RestController
public class mqController {

    @Autowired
    private Sender sender;

    @Autowired
    private Consumer consumer;

    @RequestMapping("/send")
    public Map<Object,Object> send(){
        String m=readFile("C:\\Users\\chenming\\Desktop\\data.txt");
        Map<Object,Object> map=txtMapUtil(m);
        sender.send(map);
        return map;
    }



}
