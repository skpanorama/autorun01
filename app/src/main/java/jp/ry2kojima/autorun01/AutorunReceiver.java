package jp.ry2kojima.autorun01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

public class AutorunReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        // ブロードキャストの種類を取得
        String action = intent.getAction();

        // 起動完了の処理
        if (Intent.ACTION_BOOT_COMPLETED.equals(action)) {
            PackageManager packageManager = context.getPackageManager();
            Intent intent1 = packageManager.getLaunchIntentForPackage("com.android.calculator2");
            context.startActivity(intent1);
        }
    }
}
