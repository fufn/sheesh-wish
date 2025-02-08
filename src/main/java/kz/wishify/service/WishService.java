package kz.wishify.service;

import kz.wishify.dto.WishDto;
import kz.wishify.entity.WishEntity;
import kz.wishify.exception.ExceptionType;
import kz.wishify.exception.ServiceException;
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
        return wishMapper.toListDto(wishRepository.findAllByUsername(userName));
    }

    public WishDto saveWish(WishDto wishDto) {
        log.debug("Saving wish: {}", wishDto);
        var wishEntity = wishMapper.toEntity(wishDto);
        wishEntity = wishRepository.save(wishEntity);
        return wishMapper.toDto(wishEntity);
    }

    public WishDto updateWish(UUID id, WishDto wishDto) {
        log.debug("Updating wish: {}", wishDto);
        var existingEntity = getWishById(id);
        var updatedEntity = wishMapper.updateEntity(existingEntity, wishDto);
        return wishMapper.toDto(wishRepository.save(updatedEntity));
    }

    public WishEntity getWishById(UUID id) {
        return wishRepository.findById(id)
                .orElseThrow(() -> new ServiceException(ExceptionType.WISH_NOT_FOUND));
    }

    public void deleteWish(UUID wishId) {
        log.debug("Deleting wish with id: {}", wishId);
        wishRepository.deleteById(wishId);
    }
}
