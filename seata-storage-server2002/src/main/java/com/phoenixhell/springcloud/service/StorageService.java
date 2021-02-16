package com.phoenixhell.springcloud.service;

public interface StorageService {
    void decrease(Long productId, Integer count);
}
