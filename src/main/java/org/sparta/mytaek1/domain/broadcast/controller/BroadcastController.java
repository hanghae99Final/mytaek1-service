package org.sparta.mytaek1.domain.broadcast.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sparta.mytaek1.domain.broadcast.dto.BroadcastRequestDto;
import org.sparta.mytaek1.domain.broadcast.service.BroadcastService;
import org.sparta.mytaek1.global.message.SuccessMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/broadcasts")
@Slf4j
public class BroadcastController {

    private final BroadcastService broadcastService;

    @PostMapping
    public ResponseEntity<String> createBroadcast(@AuthenticationPrincipal UserDetails auth,
                                                  @RequestPart @Valid BroadcastRequestDto requestDto,
                                                  @RequestPart MultipartFile imageFile) {
        broadcastService.createBroadcast(auth, requestDto, imageFile);
        return new ResponseEntity<>(SuccessMessage.BROADCAST_START_MESSAGE.getSuccessMessage(), HttpStatus.CREATED);
    }

    @PatchMapping("/{broadcastId}/end")
    public ResponseEntity<String> endBroadcast(@PathVariable long broadcastId) {
        broadcastService.endBroadcast(broadcastId);
        return new ResponseEntity<>(SuccessMessage.BROADCAST_END_MESSAGE.getSuccessMessage(), HttpStatus.OK);
    }
}
