package soap;

import android.app.Activity;
import android.os.Bundle;

import ru.nsk.android.R;

public class SoapActivity extends Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.soap_activity);

    Top50 top50 = new Top50();
    new Thread(top50).start();
  }
}