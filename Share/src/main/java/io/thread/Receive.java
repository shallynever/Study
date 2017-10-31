package io.thread;

import java.io.PipedInputStream;

/**
 * @author 天启 zhouj@dtdream.com
 */
public class Receive implements Runnable{

    private PipedInputStream pis = null;
    public Receive(){
        this.pis = new PipedInputStream();
    }
    public PipedInputStream getPis(){
        return pis;
    }

    @Override
    public void run() {
        byte b[]=new byte[1024];
        int len= 0;
        try {
            len = this.pis.read(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            pis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("接收内容："+new String(b,0,len));
    }


}
