package project.cyberdemon.myworkout.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * /*
 * Copyright 2018 cyberdemon
 * Created by Giuseppe D'Agostino on 30/01/2018.
 */

public class ExerciseModel extends RealmObject {
    @PrimaryKey
    private int id;
    private String ex_name;
    private String ex_muscle;
    private int num_series;
    private RealmList<SeriesModel> series_list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEx_name() {
        return ex_name;
    }

    public void setEx_name(String ex_name) {
        this.ex_name = ex_name;
    }

    public String getEx_muscle() {
        return ex_muscle;
    }

    public void setEx_muscle(String ex_muscle) {
        this.ex_muscle = ex_muscle;
    }

    public int getNum_series() {
        return num_series;
    }

    public void setNum_series(int num_series) {
        this.num_series = num_series;
    }

    public RealmList<SeriesModel> getSeries_list() {
        return series_list;
    }

    public void setSeries_list(RealmList<SeriesModel> series_list) {
        this.series_list = series_list;
    }

    public ExerciseModel(){};
}
