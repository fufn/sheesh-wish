package kz.wishify.service;

import kz.wishify.dto.WishDto;
import kz.wishify.mapper.WishMapper;
import kz.wishify.repository.WishRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class WishService {

    private final WishRepository wishRepository;
    private final WishMapper wishMapper;

    public List<WishDto> getAllWishes(String userName) {
        log.debug("Getting all wishes for user: {}", userName);
        return wishMapper.toListDto(wishRepository.findAllByUserName(userName));
    }

    public WishDto saveWish(WishDto wishDto) {
        log.debug("Saving wish: {}", wishDto);
        var wishEntity = wishMapper.toEntity(wishDto);
        wishEntity = wishRepository.save(wishEntity);
        return wishMapper.toDto(wishEntity);
    }

    public WishDto updateWish(WishDto wishDto) {
        log.debug("Updating wish: {}", wishDto);
        var existingEntity = wishRepository.findById(wishDto.id())
                .orElseThrow(RuntimeException::new);
        var updatedEntity = wishMapper.updateEntity(existingEntity, wishDto);
        return wishMapper.toDto(wishRepository.save(updatedEntity));
    }

    public void deleteWish(UUID wishId) {
        log.debug("Deleting wish with id: {}", wishId);
        wishRepository.deleteById(wishId);
    }
}
