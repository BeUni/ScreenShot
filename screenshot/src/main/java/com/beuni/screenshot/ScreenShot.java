package com.beuni.screenshot;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

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
    private String fileNameWithExtension;
    private int compressType;

    public ScreenShot(Context context, View view, String path, int quality, String fileNameWithExtension, int compressType) {
        this.context = context;
        this.view = view;
        this.path = path;
        this.quality = quality;
        this.fileNameWithExtension = fileNameWithExtension;
        this.compressType = compressType;
    }

    public String getScreenShotFileAddress() {
        try {
            view.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
            view.setDrawingCacheEnabled(false);

            File filePath = new File(path);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }

            File file = new File(filePath, fileNameWithExtension);

            FileOutputStream fileOutputStream = new FileOutputStream(file);

            if (CompressType.JPEG == compressType){
                bitmap.compress(Bitmap.CompressFormat.JPEG, quality, fileOutputStream);
            } else if (CompressType.PNG == compressType){
                bitmap.compress(Bitmap.CompressFormat.PNG, quality, fileOutputStream);
            } else {
                bitmap.compress(Bitmap.CompressFormat.WEBP, quality, fileOutputStream);
            }
            fileOutputStream.flush();
            fileOutputStream.close();

            return file.getAbsolutePath();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }


    public static class Builder {

        private Context context;
        private View view;
        private String path;
        private int quality;
        private String fileNameWithExtension;
        private int compressType;

        public Builder(Context context) {
            this.context = context;
        }


        public Builder setView(View view) {
            this.view = view;
            return this;
        }

        public Builder setPath(String path) {
            this.path = path;
            return this;
        }

        public Builder setQuality(int quality) {
            this.quality = quality;
            return this;
        }

        public Builder setFileNameWithExtension(String fileNameWithExtension) {
            this.fileNameWithExtension = fileNameWithExtension;
            return this;
        }

        public Builder setFileCompressType(int compressType) {
            this.compressType = compressType;
            return this;
        }

        public ScreenShot build() {
            return new ScreenShot(context, view, path, quality, fileNameWithExtension, compressType);
        }
    }


}
