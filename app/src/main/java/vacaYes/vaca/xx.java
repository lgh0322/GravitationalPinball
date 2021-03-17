package vacaYes.vaca;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class xx extends SurfaceView implements Runnable {
    private long t;
    long a=System.currentTimeMillis();
    float b=0;
    int z=0;
    int bbx=100;
    Paint ff    =new Paint();
    volatile boolean yes=true;
    SurfaceHolder aa;
    Canvas ss;
    // The size of the screen in pixels
    int mScreenX;
    int mScreenY;
    private Thread thread = null;
    public xx(Context ax, int x, int y){
        super(ax);
        // Set the screen width and height
        mScreenX = x;
        mScreenY = y;
        aa=getHolder();
    }

    private class fuckaa{
        public float a;
        public float b;
        public fuckaa(float a3,float a4){
            a=a3;
            b=a4;
        }
        private float dis(fuckaa a1,fuckaa a2){
            float x1,x2;
            x1=a1.a-a2.a;
            x2=a1.b-a2.b;
            return (float)Math.sqrt(x1*x1+x2*x2);
        }
        private fuckaa mmx(fuckaa a1,fuckaa a2){
            return new fuckaa(a1.a*a2.a-a1.b*a2.b,a1.a*a2.b+a1.b*a2.a);
        }

        private fuckaa addx(fuckaa a1,fuckaa a2){
            return new fuckaa(a1.a+a2.a,a1.b+a2.b);
        }

        private fuckaa m2(fuckaa sd,long tt){
            return new fuckaa(sd.a*t,sd.b*t);
        }


        private fuckaa m3(fuckaa sd,float tt){
            return new fuckaa(sd.a*tt,sd.b*tt);
        }
        private fuckaa minusx(fuckaa a1,fuckaa a2){
            return new fuckaa(a1.a-a2.a,a1.b-a2.b);
        }
        private fuckaa minusx2(fuckaa a11,fuckaa a22){
            float dx=dis(a11,a22);
            return new fuckaa((a11.a-a22.a)/dx,(a11.b-a22.b)/dx);
        }
        private fuckaa mm1(fuckaa a1,fuckaa a2){
            return new fuckaa(a1.a*a2.a-a1.b*a2.b,a1.a*a2.b+a1.b*a2.a);
        }

        private float dotx(fuckaa a1,fuckaa a2){
            return a1.a*a2.a+a1.b*a2.b;
        }


        private float im(fuckaa xx){
            return xx.b;
        }
        private float re(fuckaa xx){
            return xx.a;
        }

    }
    public class ball{
        private fuckaa cc;
        private fuckaa dd;
        private fuckaa ee=new fuckaa(0,0);
        private float  r;
        private float massx;
        private int a,b,c;

        public ball(fuckaa qq,fuckaa ww,float r2,float jk,int z,int x, int c2){
            cc=qq;
            dd=ww;
            r=r2;
            massx=jk;
            a=z;
            b=x;
            c=c2;
        }
    }

    public void drawball(fuckaa xx,float r,int a, int b,int c){
        ff.setARGB(255,a,b,c);
        ss.drawArc(xx.a-r,xx.b-r,xx.a+r,xx.b+r,0,360,true,ff);
    }

    public void drawball2(ball er){
        drawball(er.cc,er.r,er.a,er.b,er.c);
    }








    @Override
    public void run() {

        ff.setARGB(255,255,0,0);
        ball c1=new ball(new fuckaa(1300,500),new fuckaa(0,-50),50,10,255,0,0);
        ball c2=new ball(new fuckaa(500,500),new fuckaa(0,50),50,10,0,255,0);
        ball c3=new ball(new fuckaa(1700,800),new fuckaa(0,50),50,10,0,0,255);
fuckaa df,df2,df3;float ty,ty2,ty3;
        while(yes){
            if (aa.getSurface().isValid()) {
                ss=aa.lockCanvas();
                ss.drawColor(Color.argb(255, 226, 128, 182));


                t=System.currentTimeMillis()-a;
                a=System.currentTimeMillis();


                drawball2(c1);
                drawball2(c2);
                drawball2(c3);
                ty=c1.cc.dis(c1.cc,c2.cc);
                df=c1.dd.minusx2(c1.cc,c2.cc);
                ty2=c1.cc.dis(c1.cc,c3.cc);
                df2=c1.dd.minusx2(c1.cc,c3.cc);
                ty3=c1.cc.dis(c2.cc,c3.cc);
                df3=c1.dd.minusx2(c2.cc,c3.cc);
                c1.ee=c1.cc.addx(c1.cc.m3(df,-10000000.0f/(ty*ty)),c1.cc.m3(df2,-10000000.0f/(ty2*ty2)));
                c2.ee=c1.cc.addx(c1.cc.m3(df,10000000.0f/(ty*ty)),c1.cc.m3(df3,-10000000.0f/(ty3*ty3)));
                c3.ee=c1.cc.addx(c1.cc.m3(df2,10000000.0f/(ty2*ty2)),c1.cc.m3(df3,10000000.0f/(ty3*ty3)));


                c1.dd=c1.dd.addx(c1.dd,c1.ee.m3(c1.ee,t*0.001f));
                c2.dd=c2.dd.addx(c2.dd,c2.ee.m3(c2.ee,t*0.001f));
                c3.dd=c3.dd.addx(c3.dd,c3.ee.m3(c3.ee,t*0.001f));
                c1.cc=c1.cc.addx(c1.cc,c1.dd.m3(c1.dd,t*0.001f));
                c2.cc=c2.cc.addx(c2.cc,c2.dd.m3(c2.dd,t*0.001f));
                c3.cc=c3.cc.addx(c3.cc,c3.dd.m3(c3.dd,t*0.001f));

                aa.unlockCanvasAndPost(ss);

            }
        }
    }
    public void pause() {
        yes=false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            // Error
        }
    }

    public void resume() {
        thread = new Thread(this);
        thread.start();
    }
}
