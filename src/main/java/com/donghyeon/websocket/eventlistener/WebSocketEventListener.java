package com.donghyeon.websocket.eventlistener;

import com.donghyeon.websocket.chat.ChatRoom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
@Slf4j
public class WebSocketEventListener {

    /** TODO
     *  채팅룸 DB연동 안해도 될듯.
     *  UUID 사용하면 될듯.
     *
     */
    //Thread Safe..
    ConcurrentLinkedQueue<String> chatRoomQueue = new ConcurrentLinkedQueue<>();

    /** 새로운 클라이언트 세션을 STOMP 커넥션 받게되는 이벤트를 알려줍니다. */
    @EventListener(SessionConnectEvent.class)
    public void handleWebsocketConnectListner(SessionConnectEvent event) {
        MessageHeaders headers = event.getMessage().getHeaders();
        log.info("Header : {}" ,headers.toString());
        log.info("Received a new web socket connection : " + LocalDateTime.now());
//        log.info("Info : {}", event.getMessage());
        //채팅방이 하나도 없으면..
        if(chatRoomQueue.size() == 0){
            //채팅방을 만든들어서 대기열에 집어넣는다.
            chatRoomQueue.add(UUID.randomUUID().toString());
        } else {
            //존재하는 채팅방이 있으면, Queue에서 빼고, 거기로 이동시켜준다.
            String willEnterChatRoom = chatRoomQueue.peek();

        }


    }

//    @EventListener(SessionSubscribeEvent.class)
//    public void handleWebsocketSubscribeEvent(SessionSubscribeEvent event) {
//        log.info("Subscribe Event : {}", event.getUser().toString());
//    }
    /** 클라이언트와 세션이 끊어졌을 때 */
    @EventListener(SessionDisconnectEvent.class)
    public void handleWebsocketDisconnectListner(SessionDisconnectEvent event) {
        log.info("session closed : " + LocalDateTime.now());

    }
}
