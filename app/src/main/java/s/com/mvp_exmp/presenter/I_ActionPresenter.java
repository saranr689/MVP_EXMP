package s.com.mvp_exmp.presenter;

import android.content.Context;

public interface I_ActionPresenter  {

    void storeValues(Context context,String name , String number);
    String retriveValues();
    boolean checkvalidValues(String name , String number);
}
