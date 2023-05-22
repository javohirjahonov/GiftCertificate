package uz.pdp.giftcertificate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import uz.pdp.giftcertificate.DTO.GiftCreateDto;
import uz.pdp.giftcertificate.entity.GiftEntity;
import uz.pdp.giftcertificate.exceptions.GiftNameNotTrueException;
import uz.pdp.giftcertificate.exceptions.GiftNotFoundException;
import uz.pdp.giftcertificate.exceptions.GiftPriceNotTrueException;
import uz.pdp.giftcertificate.service.GiftService.GiftService;
import org.apache.commons.lang3.StringUtils;
import uz.pdp.giftcertificate.service.TagService.TagService;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/gifts")
public class GiftController {

    private final GiftService giftService;
    private final TagService tagService;
    @PostMapping("/add-gift")
    @ResponseBody
        public ResponseEntity<Object> addGift(
            @RequestBody GiftCreateDto giftCreateDto
    ) {
        String price = String.valueOf(giftCreateDto.getPrice());
        if (giftCreateDto.getName().isBlank()) {
            throw new GiftNameNotTrueException();
        }
        if (!isNumeric(Double.toString(giftCreateDto.getPrice())) && giftCreateDto.getPrice()==0) {
            throw new GiftPriceNotTrueException();
        }
        if (giftCreateDto.getTags().isEmpty()) {
            throw new GiftNameNotTrueException();
        }
        giftService.add(giftCreateDto);
        return new ResponseEntity<>("Gift added", HttpStatus.OK);
    }

    @DeleteMapping("/delete-gift/{id}")
    @ResponseBody
    public GiftEntity deleteGift(
            @PathVariable UUID id
    ) {
        giftService.deleteById(id);
        return null;

    }

    @GetMapping("/get-all-gift")
    @ResponseBody
    public List<GiftEntity> getAllGifts(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam boolean sortByPrice
    ) {
        return giftService.getAllByPageSize(page, size, sortByPrice);
    }

    @GetMapping("/get-all")
    @ResponseBody
    public List<GiftEntity> getAll(
    ) {
        List<GiftEntity> all = giftService.getAll();
        if (all.isEmpty()) {
            throw new GiftNotFoundException();
        }
        return all;

    }

    @PutMapping("/update-gift/{id}")
    @ResponseBody
    public GiftEntity updateGiftById(
            @PathVariable UUID id,
            @RequestBody GiftCreateDto giftCreateDto
    ) {
        String price = String.valueOf(giftCreateDto.getPrice());
        if (price.matches("^[0-9]+$")) {
            return giftService.update(giftCreateDto, id);
        } else {
            return null;
        }
    }

    public boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c) && c != '.' && c != ',') {
                return false;
            }
        }

        if (str.chars().filter(ch -> ch == '.' || ch == ',').count() > 1) {
            return false;
        }

        if (str.endsWith(".") || str.endsWith(",")) {
            return false;
        }

        return true;
    }


    @GetMapping("/get-gift-by-tag-name/{tag}")
    @ResponseBody
    public List<GiftEntity> getGiftsByTags(
            @PathVariable String tag
    ) {

        List<GiftEntity> giftEntityByTags = giftService.getGiftEntityByTags(tag);
        if (giftEntityByTags.isEmpty()) {
            throw new GiftNameNotTrueException();
        }
        return giftEntityByTags;
    }

    @GetMapping("/get-gifts-by-name/{name}")
    @ResponseBody
    public List<GiftEntity> getGiftsByName(
            @PathVariable String name
    ) {
        return giftService.getAllByName(name);
    }


    @GetMapping("/get-gifts-by-description/{description}")
    @ResponseBody
    public List<GiftEntity> getGiftsByDescription(
            @PathVariable String description
    ) {
        List<GiftEntity> allByDescription = giftService.getAllByDescription(description);
        if (allByDescription.isEmpty()) {
            throw new GiftNotFoundException();
        }
        return allByDescription;
    }

}
