package com.scm.helpers;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Message {
    private String content;
    @Builder.Default
    private MessageType type = MessageType.green;
}
