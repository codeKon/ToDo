package todo.codekon.de.todo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import todo.codekon.de.todo.R;
import todo.codekon.de.todo.fragment.DynamicFragment;

public class MainActivity extends FragmentActivity {

    final static String TAG_1 = "DYNAMIC_FRAGMENT";

    private android.support.v4.app.FragmentManager mFagmentManager = getSupportFragmentManager();
    private DynamicFragment mDynamicFragment = new DynamicFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        android.support.v4.app.FragmentTransaction fragmentTransaction = mFagmentManager.beginTransaction();

        fragmentTransaction.add(R.id.frame_layout_main, mDynamicFragment, TAG_1);
        fragmentTransaction.commit();


    }

}
