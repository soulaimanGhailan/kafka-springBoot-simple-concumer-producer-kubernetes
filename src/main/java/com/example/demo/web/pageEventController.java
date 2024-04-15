package com.example.demo.web;

import com.example.demo.entities.PageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/page")
public class pageEventController {
    @Autowired
    private StreamBridge streamBridge ;
  @GetMapping("publish/{topic}/{name}")
    private PageEvent send(@PathVariable String name ,@PathVariable String topic){
      PageEvent event = PageEvent.builder()
              .date(new Date()).name("page event 111").userName(name).duration(10000L).build();
     this.streamBridge.send(topic , event) ;
      return event;
  }

}
