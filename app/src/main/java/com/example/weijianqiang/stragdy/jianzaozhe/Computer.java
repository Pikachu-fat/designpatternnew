package com.example.weijianqiang.stragdy.jianzaozhe;

/**
 * Created by weijianqiang
 * On 2019/6/26
 * Description:
 */

public abstract class Computer {
    protected String mBoard;
    protected String mDisplay;
    protected String mOs;

    public void setmBoard(String mBoard){
        this.mBoard = mBoard;
    }

    public void setmDisplay(String mDisplay){
        this.mDisplay = mDisplay;
    }

    public abstract void setmOs(String mOs);

    @Override
    public String toString() {
        return "computer{mboard:"+mBoard+",mdisplay:"+mDisplay+",mOs:"+mOs+"}";
    }
}
