package com.poker.userservice.message.inbound.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameCreatedEvent implements Serializable {
    private String id;
    private String userId;
    private Integer summary;
}