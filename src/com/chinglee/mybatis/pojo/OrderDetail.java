package com.chinglee.mybatis.pojo;

/**
 * 订单明细:订单号,所有的明细号,明细数量
 */
public class OrderDetail {
 private int id;
 private int ordersId;
 private  int itemsId;
 private int itemsNum;

 //多对多映射，一个明细对应一个商品
    private Items items;



    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }
    public void setItemsId(int itemsId) {
        this.itemsId = itemsId;
    }
    public int getItemsId() {
        return itemsId;
    }

    public int getItemsNum() {
        return itemsNum;
    }

    public void setItemsNum(int itemsNum) {
        this.itemsNum = itemsNum;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", ordersId=" + ordersId +
                ", itemsId=" + itemsId +
                ", itemsNum=" + itemsNum +
                '}';
    }
}
