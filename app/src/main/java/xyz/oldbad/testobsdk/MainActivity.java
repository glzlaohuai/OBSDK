package xyz.oldbad.testobsdk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import xyz.oldbad.obsdk.utils.OBConfig;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      OBConfig.enableAllLog();

   }

}
