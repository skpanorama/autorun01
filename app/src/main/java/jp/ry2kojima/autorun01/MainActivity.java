package jp.ry2kojima.autorun01;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // リストビューのためのカスタムアダプタを準備
        AppListAdapter appListAdapter = new AppListAdapter(MainActivity.this);

        //リストビューの準備
        ListView listView = findViewById(R.id.myListView);
        listView.setOnItemClickListener(this);
        listView.setAdapter(appListAdapter);

        // 端末にインストール済のアプリケーション一覧情報を取得
        PackageManager manager = getPackageManager();
        List<ApplicationInfo> infos = manager.getInstalledApplications(0);
        for (ApplicationInfo app : infos) {

            // 起動可能なアプリだけをリストに表示
            if (manager.getLaunchIntentForPackage(app.packageName) != null) {
                appListAdapter.add(app);
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        // クリックしたアイテムを起動する
        ApplicationInfo item = (ApplicationInfo)adapterView.getItemAtPosition(i);
        PackageManager manager = getPackageManager();
        Intent intent = manager.getLaunchIntentForPackage(item.packageName);
        startActivity(intent);
    }
}
