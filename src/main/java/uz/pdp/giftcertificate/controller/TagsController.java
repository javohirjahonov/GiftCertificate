package uz.pdp.giftcertificate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.giftcertificate.DTO.TagsCreateDto;
import uz.pdp.giftcertificate.entity.TagEntity;
import uz.pdp.giftcertificate.service.TagService.TagService;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tags")
public class TagsController {

    private final TagService tagService;

    @PostMapping("/add-tag")
    @ResponseBody
    public TagEntity addTag(
            @RequestBody TagsCreateDto tagsCreateDto
    ) {
        return tagService.add(tagsCreateDto);
    }


    @DeleteMapping("/delete-tag/{id}")
    @ResponseBody
    public TagEntity deleteTagById(
            @PathVariable UUID id
            ) {
         tagService.deleteById(id);
         return null;
    }

    @GetMapping("/get-all-tags")
    @ResponseBody
    public List<TagEntity> getAllTags() {
        return tagService.getAll();
    }
}
