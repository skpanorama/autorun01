package jp.ry2kojima.autorun01;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AppListAdapter extends ArrayAdapter<ApplicationInfo> {

    AppListAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final PackageManager pm = this.getContext().getPackageManager();

        View v;
        if (view != null) {
            v = view;
        } else {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = layoutInflater.inflate(R.layout.approw, null);
        }

        ApplicationInfo info = getItem(i);

        TextView tvLabel = v.findViewById(R.id.label);
        tvLabel.setText(info.loadLabel(pm).toString());

        ImageView iv = v.findViewById(R.id.icon);
        iv.setImageDrawable(info.loadIcon(pm));

        TextView tvpname = v.findViewById(R.id.pname);
        tvpname.setText(info.packageName);

        return v;
    }
}
