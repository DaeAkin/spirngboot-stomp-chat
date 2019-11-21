package com.donghyeon.websocket.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
@Slf4j
public class ChatRoomService {

    private ConcurrentLinkedQueue<String> chatRoomQueue = new ConcurrentLinkedQueue<>();

    public Mono<String> joinChatRoom() {
        if(chatRoomQueue.size() == 0){
            //채팅방을 만든들어서 대기열에 집어넣는다.
            String chatRoomId = UUID.randomUUID().toString();
            chatRoomQueue.add(chatRoomId);
            return Mono.just(chatRoomId);

        } else {
            //존재하는 채팅방이 있으면, Queue에서 빼고, 거기로 이동시켜준다.
            String willEnterChatRoom = chatRoomQueue.poll();
            return Mono.just(willEnterChatRoom);
        }
    }
}
