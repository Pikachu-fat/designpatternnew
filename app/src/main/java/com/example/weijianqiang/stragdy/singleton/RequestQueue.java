package com.example.weijianqiang.stragdy.singleton;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by weijianqiang
 * On 2019/6/23
 * Description:
 */
public class RequestQueue {
    LinkedBlockingQueue<BitmapRequest> queue = null;

    public RequestQueue(int length){
        queue = new LinkedBlockingQueue<>(length);
    }


    public void add(BitmapRequest bitmapRequest){
        queue.add(bitmapRequest);
    }

    public BitmapRequest take(){
        try {
            return queue.poll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
