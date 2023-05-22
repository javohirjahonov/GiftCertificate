package uz.pdp.giftcertificate.service.GiftService;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.pdp.giftcertificate.DTO.GiftCreateDto;
import uz.pdp.giftcertificate.entity.GiftEntity;
import uz.pdp.giftcertificate.entity.TagEntity;

import uz.pdp.giftcertificate.repsitory.GiftRepository.GiftRepository;
import uz.pdp.giftcertificate.repsitory.TagRepository.TagRepository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GiftServiceImpl implements GiftService{

    private final GiftRepository giftRepository;
    private final TagRepository tagRepository;
    private final ModelMapper modelMapper;

    @Override
    public GiftEntity add(GiftCreateDto giftCreateDto) {
        GiftEntity giftEntity = modelMapper.map(giftCreateDto, GiftEntity.class);

        List<TagEntity> tags = giftCreateDto.getTags().stream()
                .map(tagsCreateDto -> modelMapper.map(tagsCreateDto, TagEntity.class))
                .collect(Collectors.toList());

        giftEntity.setTags(tags);

        giftRepository.save(giftEntity);
        return giftEntity;
    }

    @Override
    public void deleteById(UUID id) {
        giftRepository.deleteById(id);
    }

    @Override
    public GiftEntity update(GiftCreateDto giftCreateDto, UUID id) {
        GiftEntity giftEntity = modelMapper.map(giftCreateDto, GiftEntity.class);
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime updatedDateTime = LocalDateTime.now();
        giftEntity.setId(id);
        giftEntity.setCreatedDate(localDateTime);
        giftEntity.setLastUpdatedDate(updatedDateTime);
        giftRepository.save(giftEntity);
        return giftEntity;
    }

    @Override
    public boolean checkPrice(String price) {
        if (price.matches("^[0-9]+$")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<GiftEntity> getAllByPageSize(int page, int size,  boolean sortByPrice) {
        if (sortByPrice) {
            Sort sort =  Sort.by(Sort.Direction.ASC, "price");
            Pageable pageable = PageRequest.of(page, size, sort);
            return giftRepository.findAll(pageable).getContent();
        }
        Pageable pageable = PageRequest.of(page, size);
        return giftRepository.findAll(pageable).getContent();
    }

    @Override
    public List<GiftEntity> getAllByName(String name) {
        return giftRepository.findGiftEntityByName(name);
    }

    @Override
    public List<GiftEntity> getAllByDescription(String description) {
        return giftRepository.findGiftEntityByDescription(description);
    }

    @Override
    public List<GiftEntity> getGiftsByPrice(double price) {
         giftRepository.findGiftEntityByPrice(price);
        return null;
    }


    @Override
    public List<GiftEntity> getGiftEntityByTags(String tag) {
        List<TagEntity> tags = tagRepository.searchTagEntityByName(tag);
        List<GiftEntity> giftEntities = new ArrayList<>();

        for (TagEntity tagEntity : tags) {
            List<GiftEntity> gifts = giftRepository.findGiftEntityByTagsIn(Collections.singletonList(tagEntity));
            giftEntities.addAll(gifts);
        }

        return giftEntities;
    }
//
//    @Override
//    public List<GiftEntity> getGiftEntityByTags(String tag) {
//        List<TagEntity> tags = tagRepository.searchTagEntityByName(tag);
//        return giftRepository.findGiftEntityByTagsIn(tags);
//    }

    @Override
    public List<GiftEntity> getAll() {
        return giftRepository.findAll();
    }
}
