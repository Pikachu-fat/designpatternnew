package com.example.weijianqiang.stragdy.lod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weijianqiang
 * On 2019/6/23
 * Description:
 */
public class Mediator {

    private List<Room> list;
    private List<Room> suitRooms = new ArrayList<>();
    private float diffArea;
    private float diffPrice;

    public Mediator() {
        init();
    }

    /**
     * 初始化模拟数据
     */
    private void init() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Room room = new Room(14 + i, (14 + i) * 150);
            list.add(room);
        }
    }

    /**
     * 客户发布租房条件
     * @param area
     * @param price
     * @param diffArea
     * @param diffPrice
     * @return
     */
    public List rentRoom(float area, float price, float diffArea, float diffPrice) {
        this.diffArea = diffArea;
        this.diffPrice = diffPrice;

        for (int i = 0; i < list.size(); i++) {
            Room room = list.get(i);
            if (suiteRoom(room, area, price)) {
                suitRooms.add(room);
            }
        }
        return suitRooms;
    }

    /**
     * 判断是否符合要求
     * @param room
     * @param area
     * @param price
     * @return
     */
    private boolean suiteRoom(Room room, float area, float price) {
        if (room == null)
            return false;

        if (Math.abs(room.getArea() - area) < diffArea && Math.abs(room.getPrice() - price) < diffPrice) {
            return true;
        }
        return false;
    }
}
