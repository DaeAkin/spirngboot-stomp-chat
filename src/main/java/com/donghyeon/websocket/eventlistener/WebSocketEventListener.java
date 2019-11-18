package com.donghyeon.websocket.eventlistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
@Slf4j
public class WebSocketEventListener {



    /** 새로운 클라이언트 세션을 STOMP 커넥션 받게되는 이벤트를 알려줍니다. */
    @EventListener(SessionConnectEvent.class)
    public void handleWebsocketConnectListner(SessionConnectEvent event) {
        MessageHeaders headers = event.getMessage().getHeaders();
        log.info("Header : {}" ,headers.toString());
        log.info("Received a new web socket connection : " + LocalDateTime.now());
//        log.info("Info : {}", event.getMessage());

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
