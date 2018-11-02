package tw.brad.app.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private SimpleAdapter simpleAdapter;
    private int[] to = {R.id.item_title, R.id.item_date};
    private String[] from = {"brad", "sakura"};
    private LinkedList<HashMap<String,String>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        initListView();
    }

    private void initListView(){
        data = new LinkedList<>();

        for (int i=0; i<100; i++) {
            HashMap<String, String> row = new HashMap<>();
            row.put(from[0], "事件: " + i);
            row.put(from[1], "2018-10-23");
            data.add(row);
        }

        simpleAdapter = new SimpleAdapter(this,
                data,
                R.layout.item,
                from,
                to);

        listView.setAdapter(simpleAdapter);
    }

}
