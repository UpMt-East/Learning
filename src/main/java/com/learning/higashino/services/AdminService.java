package com.learning.higashino.services;

import com.learning.higashino.components.ItemMaster;
import com.learning.higashino.repositories.ItemMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理画面サービス
 */
@Service
public class AdminService {

    /**
     * 商品マスタリポジトリ
     */
    @Autowired
    private ItemMasterRepository itemMasterRepository;

    /**
     * 商品情報登録
     *
     * @param itemMaster 商品マスタモデル
     * @throws Exception 商品登録エラー
     */
    public void insertItemMasterInfo(ItemMaster itemMaster) throws Exception {
        try {
            itemMasterRepository.save(itemMaster);
        } catch (Exception e) {
            throw new Exception("商品登録に失敗しました。");
        }
    }

    /**
     * TODO お試しで作っただけ（商品情報のID=1のデータを取得する）
     */
    public ItemMaster getTopItemMasterInfo() throws Exception {
        return itemMasterRepository.findById(1).get();
    }
}
