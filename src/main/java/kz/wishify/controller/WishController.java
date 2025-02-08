package kz.wishify.controller;

import kz.wishify.dto.WishDto;
import kz.wishify.service.WishService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static kz.wishify.util.HttpUtil.API_V1;

@RestController
@RequestMapping(API_V1 + "/wishes")
@RequiredArgsConstructor
public class WishController {

    private final WishService wishService;

    @GetMapping
    public List<WishDto> getAllWishes(@RequestParam String username) {
        return wishService.getAllWishes(username);
    }

    @PostMapping
    public WishDto saveWish(@RequestBody WishDto wishDto) {
        return wishService.saveWish(wishDto);
    }

    @PutMapping
    public WishDto updateWish(@RequestBody WishDto wishDto) {
        return wishService.updateWish(wishDto);
    }

    @DeleteMapping("/{wishId}")
    public void deleteWish(@PathVariable UUID wishId) {
        wishService.deleteWish(wishId);
    }
}
