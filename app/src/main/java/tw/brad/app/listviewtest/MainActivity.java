package tw.brad.app.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //doItem(i);
                Log.v("brad", "itemClick");
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Item "+i, Toast.LENGTH_SHORT).show();
                return true; //false;
            }
        });

    }

    private void doItem(int i){
        Toast.makeText(this, data.get(i).get(from[0]), Toast.LENGTH_SHORT).show();
    }


    public void addData(View view) {
        HashMap<String,String> newdata = new HashMap<>();
        newdata.put(from[0], "新事件");
        newdata.put(from[1], "2019-01-02");
        data.add(0, newdata);

        simpleAdapter.notifyDataSetChanged();

    }

    public void removeData(View view) {
        data.remove(0);
        simpleAdapter.notifyDataSetChanged();
    }
}
