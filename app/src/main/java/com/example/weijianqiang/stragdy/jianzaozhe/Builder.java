package com.example.weijianqiang.stragdy.jianzaozhe;

/**
 * Created by weijianqiang
 * On 2019/6/26
 * Description:
 */
public abstract class Builder {
    public abstract void buildBoard(String board);
    public abstract void buildDisplay(String display);
    public abstract void buildOs(String os);
    public abstract Computer create();
}
