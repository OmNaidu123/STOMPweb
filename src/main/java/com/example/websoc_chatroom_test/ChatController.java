package com.example.websoc_chatroom_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat.SendMessage")
    public void sendMessage(@Payload ChatMessage chatMessage) {
        // Assume chatMessage has a method getChatRoomId() to get the room ID
        String chatRoomId = chatMessage.getChatRoomId();

        // Construct the destination dynamically
        String destination = "/topic/public/" + chatRoomId;
        System.out.println("reached ");
        // Optionally save the message to the database here

        // Send the message to the dynamically constructed destination
        messagingTemplate.convertAndSend(destination, chatMessage);
    }

    @GetMapping("dummy")
    public String dummy(){
        return "just a dummy url";
    }
}
