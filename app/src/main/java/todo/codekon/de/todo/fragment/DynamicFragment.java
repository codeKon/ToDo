package todo.codekon.de.todo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import todo.codekon.de.todo.R;


public class DynamicFragment extends android.support.v4.app.Fragment {

    private LinearLayout mAddLayout;
    private View mView;
    private LayoutInflater mLayoutInflater;
    private ViewGroup mContainer;
    private Button mButton;

    /**
     * new instance
     *
     * @param content
     * @return fragment
     */

    public static DynamicFragment newInstance(String content) {

        DynamicFragment fragment = new DynamicFragment();

        fragment.setRetainInstance(true);
        return fragment;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAddLayout.addView(addRowView());
            }
        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_dynamic, container, false);

        this.mLayoutInflater = inflater;
        this.mContainer = container;

        mAddLayout = (LinearLayout) mView.findViewById(R.id.layout_add);
        mButton = (Button) mView.findViewById(R.id.btn_add);

        return mView;

    }

    /**
     * Add a row view
     *
     * @return rowView
     */
    private View addRowView() {

        View rowView = mLayoutInflater.inflate(R.layout.rowview, mContainer, false);

        final EditText editText = (EditText) rowView.findViewById(R.id.editText);
        final TextView textViewToDo = (TextView) rowView.findViewById(R.id.tv_todo);
        final Button buttonRowAdd = (Button) rowView.findViewById(R.id.btn_add_row);

           buttonRowAdd.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   if ((editText.getText().toString()).equals("") || (editText.getText().toString() )== null) {

                       Toast.makeText(getActivity(), getResources().getString(R.string.add_text), Toast.LENGTH_SHORT).show();

                   } else {
                       textViewToDo.setText(editText.getText().toString());
                       editText.setVisibility(View.GONE);
                       buttonRowAdd.setVisibility(View.GONE);
                   }

               }
           });

            return rowView;

    }

}
