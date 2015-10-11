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
import android.content.Intent;
import android.content.Context;
import android.widget.TextView;
import android.widget.ImageView;
import android.app.Activity;

public class HomeScreenTry extends AppCompatActivity {

    ListView lv1;
    String arr[]={"Group 1"," Group 2"," Group 3"," Group 4"," Group 5"," Group 6"," Group 7"," Group 8"};
    ArrayList <RowData>not_list=new ArrayList<RowData>();
    RowData notiL[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_try);

        not_list.add(0, new RowData("Group 1", R.mipmap.ic_launcher));
        not_list.add(1, new RowData("Group 2", R.mipmap.ic_launcher));
        not_list.add(2, new RowData("Group 3", R.mipmap.ic_launcher));
        not_list.add(3, new RowData("Group 4", R.mipmap.ic_launcher));
        not_list.add(4, new RowData("Group 5", R.mipmap.ic_launcher));
        not_list.add(5, new RowData("Group 6", R.mipmap.ic_launcher));
        not_list.add(6, new RowData("Group 7", R.mipmap.ic_launcher));
        not_list.add(7, new RowData("Group 8", R.mipmap.ic_launcher));
        not_list.add(8, new RowData("Group 9", R.mipmap.ic_launcher));




        lv1=(ListView)findViewById(R.id.listTry);
        ListAdapter la= new ArrayAdapterMod(this, R.layout.tval,not_list);
        lv1.setAdapter(la);

        lv1.setOnItemClickListener(new OnItemClickListenerMod());

    }
}

class ArrayAdapterMod extends ArrayAdapter<RowData>
{

    Context mContext;

    int layoutResourceId;

    ArrayList <RowData> data ;

    public ArrayAdapterMod(Context mContext, int layoutResourceId, ArrayList<RowData> data) {



        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;

        this.data = data;

    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){

            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }
        RowData value = data.get(position);
        TextView textViewItem = (TextView) convertView.findViewById(R.id.listTextValue);
        textViewItem.setText(value.data);
        ImageView iv=(ImageView)convertView.findViewById(R.id.listImage);
        iv.setBackgroundResource(value.image_id);
        return convertView;
    }

}

class OnItemClickListenerMod implements OnItemClickListener
{
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Context cc=view.getContext();
        TextView tv1= (TextView) view.findViewById(R.id.listTextValue);
        String output= tv1.getText().toString();
        Toast.makeText(cc,"Out: "+output,Toast.LENGTH_SHORT).show();

    }
}


class RowData
{
    String data;
    int image_id;
    public RowData(String temp,int img)
    {
        data= temp;
        image_id=img;
    }

}