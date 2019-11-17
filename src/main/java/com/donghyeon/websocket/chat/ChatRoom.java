package com.donghyeon.websocket.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatRoomId;

    private String chatTitle;

    private Long chatMemberCount;

    public ChatRoom(String chatTitle, Long chatMemberCount) {
        this.chatTitle = chatTitle;
        this.chatMemberCount = chatMemberCount;
    }
}
