package com.donghyeon.websocket.service;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class ChatRoomServiceTests {

    @Autowired
    ChatRoomService chatRoomService;

    @Test
    public void 채팅방_조인_테스트() {
        //when
        // chatRoomId와 chatRoomId2는 같은 채팅방 안에 있음.
        Mono<String> chatRoomId = chatRoomService.joinChatRoom();
        Mono<String> chatRoomId2 = chatRoomService.joinChatRoom();

        //chatRoomId3 는 채팅방을 만들고 대기중..
        Mono<String> chatRoomId3 = chatRoomService.joinChatRoom();

        log.info("chatRoomId : {}" ,chatRoomId.block());
        log.info("chatRoomId2 : {}" ,chatRoomId2.block());
        log.info("chatRoomId3 : {}" ,chatRoomId3.block());

        //then
        assertThat(chatRoomId.block()).isEqualTo(chatRoomId2.block());
        assertThat(chatRoomId.block()).isNotEqualTo(chatRoomId3.block());
    }
}
