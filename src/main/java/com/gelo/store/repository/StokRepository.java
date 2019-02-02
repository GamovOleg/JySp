package com.gelo.store.repository;

import com.gelo.store.model.Stok;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StokRepository extends JpaRepository<Stok, Long> {
    Stok create (Stok stok);
    Stok read (String stokId);
    void update (String stokId, Stok stok);
    void delete(String stokId);
}
