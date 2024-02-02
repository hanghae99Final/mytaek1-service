package org.sparta.mytaek1.domain.broadcast.dto;

import lombok.Getter;
import org.sparta.mytaek1.domain.broadcast.entity.Broadcast;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class BroadcastResponseDto {

    private final String broadCastTitle;

    private final String broadCastDescription;

    private final String userName;

    private final String productName;

    public BroadcastResponseDto(Broadcast broadcast) {
        this.broadCastTitle = broadcast.getBroadcastTitle();
        this.broadCastDescription = broadcast.getBroadcastDescription();
        this.userName = broadcast.getUser().getUserName();
        this.productName = broadcast.getProduct().getProductName();
    }

    public static List<BroadcastResponseDto> fromBroadcastList(List<Broadcast> broadcastList) {
        return broadcastList.stream()
                .map(BroadcastResponseDto::new)
                .collect(Collectors.toList());
    }
}