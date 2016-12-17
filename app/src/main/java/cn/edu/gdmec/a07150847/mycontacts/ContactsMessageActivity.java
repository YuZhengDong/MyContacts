package cn.edu.gdmec.a07150847.mycontacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by asus on 2016/11/16.
 */
public class ContactsMessageActivity extends AppCompatActivity{
    private TextView nameEditText1;
    private TextView mobileEditText1;
    private TextView qqEditText1;
    private TextView danweiEditText1;
    private TextView addressEditText1;
    private User user;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_message);

        nameEditText1= (TextView) findViewById(R.id.name);
        mobileEditText1= (TextView) findViewById(R.id.mobile);
        danweiEditText1= (TextView) findViewById(R.id.danwei);
        qqEditText1= (TextView) findViewById(R.id.qq);
        addressEditText1= (TextView) findViewById(R.id.address);

        Bundle locauBudle = getIntent().getExtras();
        int id= locauBudle.getInt("user_ID");
        ContactsTable ct = new ContactsTable(this);
        user = ct.getUserByID(id);

        nameEditText1.setText("姓名："+user.getName());
        mobileEditText1.setText("电话："+user.getMobile());
        qqEditText1.setText("QQ:"+user.getQq().toString());
        danweiEditText1.setText("单位："+user.getDanwei());
        addressEditText1.setText("地址："+user.getAddress());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"返回");
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case 1:
               finish();
               break;
       }

        return super.onOptionsItemSelected(item);
    }
}
