package com.donghyeon.websocket.controller;

import com.donghyeon.websocket.chat.ChatRoom;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.donghyeon.websocket.repository.ChatRoomRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("chat")
@AllArgsConstructor
public class ChatRoomController {

    private final ChatRoomRepository chatRoomRepository;

    @PostConstruct
    public void initChatRoom(){

        List<ChatRoom> chatRoomList = Arrays.asList(
                new ChatRoom("개발자만!!",0L),
                new ChatRoom("일자리 구합니다.",0L)
        );
        chatRoomRepository.saveAll(chatRoomList);


    }

    @GetMapping("")
    public String moveChatListPage(Model model) {
        List<ChatRoom> chatRoomList = chatRoomRepository.findAll();
        model.addAttribute("chatRoomList",chatRoomList);
        return "chat";
    }

    @GetMapping("/{chatRoomId}")
    public String moveChatRoom(Model model, @PathVariable("chatRoomId") Long chatRoomId) {
        List<ChatRoom> chatRoomList = chatRoomRepository.findAll();
        model.addAttribute("chatRoomId", chatRoomId);
        return "chat_room";
    }

}
