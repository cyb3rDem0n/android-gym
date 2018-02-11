package project.cyberdemon.myworkout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import project.cyberdemon.myworkout.model.ExerciseModel;
import project.cyberdemon.myworkout.model.SeriesModel;
import project.cyberdemon.myworkout.model.WorkOutModel;

public class MainActivity extends AppCompatActivity {
    private Button btnselect, btninsert;
    private TextView textViewData, textViewNumEx;
    private static int id = 1;
    private static MainActivity instance;
    private Realm myRealm;
    private static ArrayList<WorkOutModel> alWotkOut = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btnselect = findViewById(R.id.buttonSelectAll);
         btninsert = findViewById(R.id.buttonInsert);
         textViewData = findViewById(R.id.textViewData);
         textViewNumEx = findViewById(R.id.textViewNumEx);



        myRealm = Realm.getInstance(MainActivity.this);
        instance = this;
    }



    public static MainActivity getInstance() {
        return instance;
    }

    private void getAllWO() {
        RealmResults<WorkOutModel> results = myRealm.where(WorkOutModel.class).findAll();

        myRealm.beginTransaction();

        for (int i = 0; i < results.size(); i++) {

            textViewData.setText(results.get(i).getDate().toString());
            textViewNumEx.setText(results.get(i).getExList().size());
            alWotkOut.add(results.get(i));
        }

        if(results.size()>0)
            id = myRealm.where(WorkOutModel.class).max("id").intValue() + 1;
        myRealm.commitTransaction();
    }

    private void addDataToRealm(WorkOutModel model) {
        myRealm.beginTransaction();

        WorkOutModel workOutModel = myRealm.createObject(WorkOutModel.class);
        workOutModel.setId(id);
        workOutModel.setDate(model.getDate());
        workOutModel.setExList(model.getExList());

        myRealm.commitTransaction();
        id++;
    }

    public void goSelect(View v) {
        getAllWO();
    }
    public void goInsert(View v) {
        // WO Object creation - START
        WorkOutModel workOutModel = new WorkOutModel();
        ExerciseModel exerciseModel = new ExerciseModel();
        SeriesModel seriesModel = new SeriesModel();

        seriesModel.setId(1);
        seriesModel.setRep(5);
        seriesModel.setWeight(30);

        RealmList<SeriesModel> seriesModelsLs = new RealmList<>();
        seriesModelsLs.add(seriesModel);

        exerciseModel.setId(1);
        exerciseModel.setEx_name("SPINTE PP - MAN");
        exerciseModel.setEx_muscle("PETTO");
        exerciseModel.setNum_series(5);
        exerciseModel.setSeries_list(seriesModelsLs);

        RealmList<ExerciseModel> exerciseModelsLs = new RealmList<>();
        exerciseModelsLs.add(exerciseModel);
        Date currentDate = new Date(System.currentTimeMillis());
        workOutModel.setId(1);
        workOutModel.setDate(currentDate);
        workOutModel.setExList(exerciseModelsLs);
        // WO Object creation - FINISH

        addDataToRealm(workOutModel);
    }}