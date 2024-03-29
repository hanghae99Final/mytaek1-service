package org.sparta.mytaek1.domain.order.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class OrderRequestDto {

    private Integer quantity;
    private Integer totalPrice;

    public OrderRequestDto(int quantity, int totalPrice) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}
