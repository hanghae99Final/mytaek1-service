package org.sparta.mytaek1.domain.broadcast.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sparta.mytaek1.domain.broadcast.dto.BroadcastResponseDto;
import org.sparta.mytaek1.domain.broadcast.dto.BroadcastRequestDto;
import org.sparta.mytaek1.domain.broadcast.service.BroadcastService;
import org.sparta.mytaek1.global.message.SuccessMessage;
import org.sparta.mytaek1.global.security.UserDetailsImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/broadcasts")
@Slf4j
public class BroadcastController {

    private final BroadcastService broadcastService;

    @PostMapping
    public ResponseEntity<String> createBroadcast(@AuthenticationPrincipal UserDetailsImpl auth,
                                                  @RequestBody BroadcastRequestDto requestDto) {
        BroadcastResponseDto responseDto = broadcastService.createBroadcast(auth, requestDto);
        return new ResponseEntity<>(SuccessMessage.BROADCAST_START_MESSAGE.getSuccessMessage(), HttpStatus.CREATED);
    }

    @PostMapping("/{broadcastId}/end")
    public ResponseEntity endBroadcast(@PathVariable long broadcastId) {
        BroadcastResponseDto responseDto = broadcastService.endBroadcast(broadcastId);
        return new ResponseEntity<>(SuccessMessage.BROADCAST_END_MESSAGE.getSuccessMessage(), HttpStatus.OK);
    }
}
