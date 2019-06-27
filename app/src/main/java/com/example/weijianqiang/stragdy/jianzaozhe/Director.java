package com.example.weijianqiang.stragdy.jianzaozhe;

/**
 * Created by weijianqiang
 * On 2019/6/26
 * Description:
 */
public class Director {
    public Builder builder;
    public Director(Builder builder){
        this.builder = builder;
    }

    public Computer contretue(String board,String display,String os){
        if (builder != null){
            builder.buildBoard(board);
            builder.buildDisplay(display);
            builder.buildOs(os);
            return builder.create();
        }
        return null;
    }
}
