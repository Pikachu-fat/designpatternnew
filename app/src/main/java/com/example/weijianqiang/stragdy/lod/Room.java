package com.example.weijianqiang.stragdy.lod;

/**
 * Created by weijianqiang
 * On 2019/6/23
 * Description:
 */
public class Room {

    //面积
    private float area;
    //价格
    private float price;

    public Room(float area,float price){
        this.area = area;
        this.price = price;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
