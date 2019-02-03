package jp.ry2kojima.autorun01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.Toast;

public class AutorunReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        // ブロードキャストの種類を取得
        String action = intent.getAction();

        Log.d("Autorun", action);
        Toast toast = Toast.makeText(context, "Autorun01: " + action, Toast.LENGTH_LONG);
        toast.show();

        // 起動完了の処理
        if (Intent.ACTION_BOOT_COMPLETED.equals(action)) {
            PackageManager packageManager = context.getPackageManager();
            Intent intent1 = packageManager.getLaunchIntentForPackage("com.android.calculator2");
            if (intent1 == null) {
                intent1 = packageManager.getLaunchIntentForPackage("com.google.android.calculator");
            }

            if (intent1 != null) {
                Toast.makeText(context, "Autorun01: START calculator", Toast.LENGTH_LONG).show();
                context.startActivity(intent1);
            } else {
                Toast.makeText(context, "Autorun01: 電卓が見つかりません", Toast.LENGTH_LONG).show();
            }
        }
    }
}
