package s.com.mvp_exmp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import s.com.mvp_exmp.presenter.ActionPresenterClass;
import s.com.mvp_exmp.presenter.ViewUpdatePresenter;

public class HomeActivity extends AppCompatActivity implements ViewUpdatePresenter {

    EditText id_num_et, id_name_et;
    TextView id_value_tv;
    Button id_setvalue_btn, id_getvalue_btn;
    ActionPresenterClass actionPresenterClass;
    String name, number;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionPresenterClass = new ActionPresenterClass();
        progressDialog = new ProgressDialog(HomeActivity.this);
        progressDialog.setMessage("Loading...");


        id_num_et = (EditText) findViewById(R.id.id_num_et);
        id_name_et = (EditText) findViewById(R.id.id_name_et);
        id_value_tv = (TextView) findViewById(R.id.id_value_tv);
        id_setvalue_btn = (Button) findViewById(R.id.id_setvalue_btn);
        id_getvalue_btn = (Button) findViewById(R.id.id_getvalue_btn);


        id_setvalue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = id_name_et.getText().toString();
                number = id_num_et.getText().toString();

                if (actionPresenterClass.checkvalidValues(name, number)) {
                    actionPresenterClass.storeValues(HomeActivity.this, name, number);
                    Toast.makeText(HomeActivity.this, "Stored sucessfullyo", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(HomeActivity.this, "Not valid", Toast.LENGTH_SHORT).show();
                }

            }
        });

        id_getvalue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                id_value_tv.setText(actionPresenterClass.retriveValues());

            }
        });


    }

    @Override
    public void showLoadingprogress() {
        progressDialog.show();
    }

    @Override
    public void disableLoadingprogress() {

        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
