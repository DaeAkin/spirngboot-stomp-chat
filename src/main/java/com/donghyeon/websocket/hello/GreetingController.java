package com.donghyeon.websocket.hello;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {


    @MessageMapping("/hello/{chatRoomId}")
    @SendTo("/topic/greetings/{chatRoomId}")
    public Greeting greeting(@DestinationVariable Long chatRoomId, HelloMessage message) throws Exception {
        System.out.println(message.toString());
        System.out.println("greeting()");
        System.out.println("채팅방 번호 : " + chatRoomId);
        return new Greeting(HtmlUtils.htmlEscape(message.getName()));
    }

}
