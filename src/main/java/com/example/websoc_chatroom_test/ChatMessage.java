package com.example.websoc_chatroom_test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatMessage {
    private String sender;
    private String msg;
    private String chatRoomId;
}
