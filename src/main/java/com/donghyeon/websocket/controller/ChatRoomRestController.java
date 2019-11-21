package com.donghyeon.websocket.controller;

import com.donghyeon.websocket.service.ChatRoomService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.ConcurrentLinkedQueue;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/chatroom")
public class ChatRoomRestController {

    private final ChatRoomService chatRoomService;

    /** 채팅방 입장 누르면 호출되는 API */
    @GetMapping("/join")
    public Mono<String> chatRoomJoin() {
        return chatRoomService.joinChatRoom();
    }

}
