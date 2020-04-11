package com.learning.higashino.components;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * 商品マスタ
 */
@Entity
@Table(name = "m_item")
public class ItemMaster {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 商品名
     */
    @NotNull
    @Column(name = "item_name")
    private String itemName;

    /**
     * 商品種別
     */
    @NotNull
    @Column(name = "item_type")
    private String itemType;

    /**
     * 価格
     */
    @NotNull
    @Column(name = "price")
    private Integer price;

    /**
     * 画像(バイナリコード)
     */
    @Column(name = "image_code")
    private String imageCode;

    /**
     * 作成日
     */
    @Column(name = "create_date")
    private Timestamp createDate;

    /**
     * 更新日
     */
    @Column(name = "update_date")
    private Timestamp updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }
}
