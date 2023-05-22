package uz.pdp.giftcertificate.service;

import uz.pdp.giftcertificate.entity.GiftEntity;

import java.util.List;
import java.util.UUID;

public interface BaseService<T, E> {
    T add(E e);

    void deleteById(UUID id);

    T update(E e, UUID id);


}
