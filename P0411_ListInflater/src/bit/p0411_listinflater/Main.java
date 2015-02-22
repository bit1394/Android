package bit.p0411_listinflater;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main extends Activity {
	
	String[] name = {"Ivan", "Maria", "Anton", "Jane", "Bob"};
	String[] position = {"Director", "Coder", "Security", "Manager", "Cleaner"};
	int[] salary = {20000, 15000, 13000, 10000, 7000};
	int[] colors = new int[2];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
	colors[0] = Color.parseColor("#559966cc");
	colors[1] = Color.parseColor("#663399aa");
	
	LinearLayout linLay = (LinearLayout) findViewById (R.id.linLay);
	LayoutInflater lInflater = getLayoutInflater();
	
	for (int i = 1; i < name.length; i++) {
		Log.d("myLogs", "i = " + i);
		View item = lInflater.inflate(R.layout.item, linLay, false);
		
		TextView tvName = (TextView)item.findViewById(R.id.tvName);
		TextView tvPosition = (TextView)item.findViewById(R.id.tvPosition);
		TextView tvSalary = (TextView)item.findViewById(R.id.tvSalary);
		
		tvName.setText("Name: " + name[i]);
		tvPosition.setText("Position: " + position[i]);
		tvSalary.setText("Salary: " + String.valueOf(salary[i]));
		
		item.getLayoutParams().width = LayoutParams.MATCH_PARENT;
		item.setBackgroundColor(colors[i%2]);
		linLay.addView(item);		
	}
	}

}
