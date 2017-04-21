package com.example.toey_kirati.myapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //Explicit
    ListView listView;
    private int[] ints = new int[]{R.drawable.traffic_01, R.drawable.traffic_02, R.drawable.traffic_03, R.drawable.traffic_04, R.drawable.traffic_05,
            R.drawable.traffic_06, R.drawable.traffic_07, R.drawable.traffic_08, R.drawable.traffic_09, R.drawable.traffic_10,
            R.drawable.traffic_11, R.drawable.traffic_12, R.drawable.traffic_13, R.drawable.traffic_14, R.drawable.traffic_15,
            R.drawable.traffic_16, R.drawable.traffic_17, R.drawable.traffic_18, R.drawable.traffic_19, R.drawable.traffic_20};

    private String[] titleStrings,detailStrings, shortStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initial View ผูกตัวแปรกับ ID ของ View
        listView = (ListView) findViewById(R.id.livTraffic);

        // Get Value เอาค่าจาก xml file ที่ file my_content มาแสดงผล
        titleStrings = getResources().getStringArray(R.array.title);
        detailStrings = getResources().getStringArray(R.array.detail);

        //SubString detailString ตัดคำใน detailString เพื่อให้มีข้อความไม่เกิน 30 character
        shortStrings = new String[detailStrings.length]; // จองพื้นที่ให้หน่วยความจำ shortString
        for (int i = 0; i<detailStrings.length; i++ ) {
            shortStrings[i] = detailStrings[i].substring(0,29)+"...";
        }
        // end for

        //Create ListView
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, ints, titleStrings, shortStrings);
        listView.setAdapter(myAdapter);

        // Active when click List View ลิ้งไปหน้า detail เมื่อคลิกเลือกไอเทม
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Detail.class);// ส่งข้อมูลจากหน้า Detail ไปหน้า Mainโดย put ข้อมูลไป 3 ค่า
                intent.putExtra("Title",titleStrings[position]);
                intent.putExtra("Detail",detailStrings[position]);
                intent.putExtra("Image", ints[position]);
                startActivity(intent);

            } // เมื่อมีการคลิกข้อมูลตำแหน่งใดจะเก็บข้อมูลจากการคลิก
        });

    } //Main Method onCreate

    public void onClickMoreInfo(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.dlt.go.th/th/dlt-knowledge/view.php?_did=111"));
        startActivity(intent);



    }

    public void onClickAboutme (View view){
        Intent intent = new Intent(MainActivity.this, Aboutme.class);
        startActivity(intent);

    }
}
