package com.example.listviewsample2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ListViewオブジェクトを取得
        ListView lvMenu = findViewById(R.id.lvMenu);
        //リストビューに表示するリストデータ用Listオブジェクトを作成
        List<String> menuList = new ArrayList<>();
        //リストデータの登録
        menuList.add("からあげ定食");
        menuList.add("ハンバーグ定食");
        //アダプタオブジェクトを生成
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,menuList);
        //リストニューにアダプタオブジェクトを設定
        lvMenu.setAdapter(adapter);
        //リストビューにリスナを設定
        lvMenu.setOnItemClickListener(new ListItemClickListener());
    }

    //リストがタップされたときの処理が記述されたメンバクラス
    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //注文確認ダイアログフラグメントオブジェクトを生成
            ConfirmDialogFragment dialogFragment = new ConfirmDialogFragment();
            //ダイアログを表示
            dialogFragment.show(getSupportFragmentManager(),"ConfirmDialogFragment");
        }
    }
}