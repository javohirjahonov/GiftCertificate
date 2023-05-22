package uz.pdp.giftcertificate.service.GiftService;

import uz.pdp.giftcertificate.DTO.GiftCreateDto;
import uz.pdp.giftcertificate.entity.GiftEntity;
import uz.pdp.giftcertificate.service.BaseService;

import java.util.List;
import java.util.UUID;

public interface GiftService extends BaseService<GiftEntity, GiftCreateDto> {
    boolean checkPrice(String price);

    List<GiftEntity> getAllByPageSize(int size, int page, boolean sortByPrice);

    List<GiftEntity> getAllByName(String name);

    List<GiftEntity> getAllByDescription(String description);

    List<GiftEntity> getGiftEntityByTags(String tag);

    List<GiftEntity> getGiftsByPrice(double price);
    List<GiftEntity> getAll();

}
