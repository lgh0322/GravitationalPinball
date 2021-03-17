package vacaYes.vaca;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

public class MainActivity extends Activity {
    xx xxc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get a Display object to access screen details
        Display display = getWindowManager().getDefaultDisplay();

        // Load the resolution into a Point object
        Point size = new Point();
        display.getSize(size);
        xxc=new xx(this,size.x, size.y);
        setContentView(xxc);
    }
    @Override
    protected void onResume() {
        super.onResume();
        xxc.resume();
    }

    // Stop the thread in snakeEngine
    @Override
    protected void onPause() {
        super.onPause();
        xxc.pause();
    }
}
