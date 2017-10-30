package io.thread;

import java.io.PipedOutputStream;

/**
 * @author 天启 zhouj@dtdream.com
 */
public class Send implements Runnable{
    private PipedOutputStream pos = null;
    public Send(){
        this.pos = new PipedOutputStream();
    }
    public PipedOutputStream getPos(){
        return pos;
    }
    @Override
    public void run() {
        String str = "zhejianggongshangdaxue";
        try {
            this.pos.write(str.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.pos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}