package project.cyberdemon.myworkout.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Giuseppe D'Agostino on 03/02/2018.
 */

public class WorkOutModel extends RealmObject {
    @PrimaryKey
    private int id;
    private Date date;
    private RealmList<ExerciseModel> exList;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public WorkOutModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public RealmList<ExerciseModel> getExList() {
        return exList;
    }

    public void setExList(RealmList<ExerciseModel> exList) {
        this.exList = exList;
    }
}
