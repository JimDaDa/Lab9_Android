package com.example.bai_2;

import java.io.Serializable;
import android.os.Build.VERSION_CODES;
import androidx.annotation.RequiresApi;
import java.util.Objects;

public class MediaFile implements Serializable {
    String path;
    String title;
    String duration;

    public MediaFile() {
    }
    public MediaFile(String path, String title, String duration) {
        this.path = path;
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }



}
