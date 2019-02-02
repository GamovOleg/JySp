package com.gelo.store.service;


import com.gelo.store.model.Stok;
import org.springframework.stereotype.Service;


@Service
public interface StokService {
    Stok create(Stok stok);
    Stok read(String stokId);
    void update(String stokId, Stok stok);
    void delete(String stokId);
}
