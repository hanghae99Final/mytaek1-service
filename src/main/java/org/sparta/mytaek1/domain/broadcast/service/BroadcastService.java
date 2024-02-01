package org.sparta.mytaek1.domain.broadcast.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sparta.mytaek1.domain.broadcast.dto.BroadcastResponseDto;
import org.sparta.mytaek1.domain.broadcast.dto.BroadcastRequestDto;
import org.sparta.mytaek1.domain.broadcast.entity.Broadcast;
import org.sparta.mytaek1.domain.broadcast.repository.BroadcastRepository;
import org.sparta.mytaek1.domain.product.entity.Product;
import org.sparta.mytaek1.domain.product.repository.ProductRepository;
import org.sparta.mytaek1.domain.product.service.ProductService;
import org.sparta.mytaek1.domain.user.entity.User;
import org.sparta.mytaek1.domain.user.repository.UserRepository;
import org.sparta.mytaek1.global.security.UserDetailsImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class BroadcastService {

    private final BroadcastRepository broadcastRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ProductService productService;

    @Transactional(readOnly = true)
    public List<BroadcastResponseDto> getAllBroadCast() {
        List<Broadcast> broadcastList = broadcastRepository.findAllByOnAirTrue();
        return BroadcastResponseDto.fromBroadcastList(broadcastList);
    }

    public BroadcastResponseDto createBroadcast(UserDetailsImpl auth, BroadcastRequestDto requestDto) {
        Optional<User> optionalUser = userRepository.findByUserEmail(auth.getUsername());
        User user = optionalUser.orElseThrow();

        Product product = productService.createProduct(requestDto);

        Broadcast broadcast = new Broadcast(requestDto.getBroadcastTitle(), requestDto.getBroadcastDescription(), user, product);
        broadcastRepository.save(broadcast);
        BroadcastResponseDto responseDto = new BroadcastResponseDto(broadcast);
        return responseDto;
    }

    public BroadcastResponseDto endBroadcast(long broadcastId) {
        Optional<Broadcast> optionalBroadcast = broadcastRepository.findById(broadcastId);
        Broadcast broadCast = optionalBroadcast.orElseThrow();

        broadCast.endBroadcast();
        BroadcastResponseDto responseDto = new BroadcastResponseDto(broadCast);
        return responseDto;
    }
}
