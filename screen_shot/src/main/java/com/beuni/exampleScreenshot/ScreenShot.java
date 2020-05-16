package com.beuni.exampleScreenshot;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class ScreenShot {

    private Context context;
    private View view;
    private String path;
    private int quality;

    public ScreenShot(Context context, View view, String path, int quality) {
        this.context = context;
        this.view = view;
        this.path = path;
        this.quality = quality;
    }

    public String getScreenShotFileAddress(){
        try {
        Date date = new Date();
        String screenShotName = String.valueOf(date.getTime());

        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);


        String newPath = path+"/"+screenShotName+".jpg";

        File file = new File(newPath);


        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();

        return newPath;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }


    public static class Builder{

        private Context context;
        private View view;
        private String path;
        private int quality;

        public Builder(Context context) {
            this.context = context;
        }


        public Builder setView(View view){
            this.view = view;
            return this;
        }

        public Builder setPath(String path){
            this.path = path;
            return this;
        }

        public Builder setQuality(int quality){
            this.quality = quality;
            return this;
        }

        public ScreenShot build() {
           return new ScreenShot(context, view, path, quality);
        }
    }


}
