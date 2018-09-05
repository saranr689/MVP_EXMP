package s.com.mvp_exmp.presenter;

import android.content.Context;
import android.os.AsyncTask;

import s.com.mvp_exmp.database.DataModel;
import s.com.mvp_exmp.database.UserDatabase;

public class ActionPresenterClass implements I_ActionPresenter {

    private String name, number;
    private Context context;
    private ViewUpdatePresenter viewUpdatePresenter;


    @Override
    public void storeValues(Context context, String name, String number) {

        this.name = name;
        this.number = number;
        this.context = context;
        viewUpdatePresenter = (ViewUpdatePresenter) context;
        DataModel userDataModel = new DataModel();
        userDataModel.setName(name);
        userDataModel.setNumber(number);

        new StoreValueOnDB(context,userDataModel).execute();
        System.out.println(this.name +" , " +   this.number);
    }

    @Override
    public String retriveValues() {

        System.out.println(this.name +" , " +   this.number);
        return this.name + ", " + this.number;
    }

    @Override
    public boolean checkvalidValues(String name, String number) {
        if (name != null && number != null || !name.isEmpty() && !number.isEmpty()) {
            return true;
            }
        return false;
    }


    private class StoreValueOnDB  extends AsyncTask<Void,Void,Void>{

        DataModel dataModel ;
        Context context;

        public StoreValueOnDB(Context context, DataModel userDataModel) {

            dataModel = userDataModel;
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            viewUpdatePresenter.showLoadingprogress();

        }

        @Override
        protected Void doInBackground(Void... voids) {

            UserDatabase roomDatabase = UserDatabase.getRoomDatabase(context);
            roomDatabase.i_databaseAccess().insertAll(dataModel);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            viewUpdatePresenter.disableLoadingprogress();
        }
    }
}
