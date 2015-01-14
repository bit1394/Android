package bit.p_032_mybrowser;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

public class MyBrowser extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mybrowser);
		
		WebView webView = (WebView) findViewById (R.id.webView);
		
		Uri data = getIntent().getData();
		webView.loadUrl(data.toString());
		
	}
	
}
