package uz.pdp.giftcertificate.service.TagService;

import uz.pdp.giftcertificate.DTO.TagsCreateDto;
import uz.pdp.giftcertificate.entity.GiftEntity;
import uz.pdp.giftcertificate.entity.TagEntity;
import uz.pdp.giftcertificate.service.BaseService;

import java.util.List;
import java.util.UUID;

public interface TagService extends BaseService<TagEntity, TagsCreateDto> {
    List<TagEntity> getAll();

    List<TagEntity> getAllByName(String name);

    List<TagEntity> getAllByDescription(String description);
}
