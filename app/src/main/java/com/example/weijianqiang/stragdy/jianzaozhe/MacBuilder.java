package com.example.weijianqiang.stragdy.jianzaozhe;

/**
 * Created by weijianqiang
 * On 2019/6/26
 * Description:
 */
public class MacBuilder extends Builder {

    MacComputer macComputer = new MacComputer();

    @Override
    public void buildBoard(String board) {
        macComputer.setmBoard(board);
    }

    @Override
    public void buildDisplay(String display) {
        macComputer.setmDisplay(display);
    }

    @Override
    public void buildOs(String os) {
        macComputer.setmOs(os);
    }

    @Override
    public Computer create() {
        return macComputer;
    }
}
