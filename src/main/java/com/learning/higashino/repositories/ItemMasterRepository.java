package com.learning.higashino.repositories;

import com.learning.higashino.components.ItemMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 商品マスタリポジトリ
 */
@Repository
public interface ItemMasterRepository extends JpaRepository<ItemMaster, Integer> {
}
