package com.example.weijianqiang.stragdy.lod;

import android.util.Log;

import java.util.List;

/**
 * Created by weijianqiang
 * On 2019/6/23
 * Description:
 */
public class Tenent {

    private static final String TAG = "Tenent";
    private float diffArea = 2.0f;
    private float diffPprice = 400f;

    private float area = 15f;
    private float price = 2350f;

    public Tenent(float area, float price, float diffArea, float diffPprice) {
        this.area = area;
        this.price = price;
        this.diffArea = diffArea;
        this.diffPprice = diffPprice;
    }

    Mediator mediator = new Mediator();

    public void subInfo() {
        List<Room> list = mediator.rentRoom(area, price, diffArea, diffPprice);
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Log.d(TAG, "area: " + list.get(i).getArea() + "\nprice:" + list.get(i).getPrice());
            }
        }
    }

}
