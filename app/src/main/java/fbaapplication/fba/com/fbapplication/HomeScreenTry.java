package fbaapplication.fba.com.fbapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.*;
import android.widget.AdapterView;
import android.view.*;
import android.widget.Toast;
import java.util.ArrayList;


public class HomeScreenTry extends AppCompatActivity {

    ListView lv1;
  //  String arr[]={"Group 1"," Group 2"," Group 3"," Group 4"," Group 5"," Group 6"," Group 7"," Group 8"};
    ArrayList <RowData>data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_try);

        lv1=(ListView)findViewById(R.id.listTry);
        ListAdapter la= new ArrayAdapter<String>(this, R.layout.tval,arr);
        lv1.setAdapter(la);

        lv1.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                String value = (String)adapter.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();

            }
        });

    }
}

class RowData
{
    String data;
    int image_id=R.mipmap.ic_launcher;
}