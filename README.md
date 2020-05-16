# ScreenShot Library

This is our first Open Source Library in Android for capture screenshot.

## Installation

First give permission to write file in Android Manifest file:
```bash
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
```

Add it in your root build.gradle at the end of repositories:

```Java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Add following dependency:

```Java
dependencies {
	        implementation 'com.github.BeUni:ScreenShot:v0.2'
	}
```

## Usage

```
   String getFileAddress = new ScreenShot.Builder(getApplicationContext())
                        .setQuality(Quality.HIGH)
                        .setView(getWindow().getDecorView().getRootView())
                        .setPath(Environment.getExternalStorageDirectory()+"/testScreenShot")
                        .setFileCompressType(CompressType.JPEG)
                        .setFileNameWithExtension(System.currentTimeMillis()+".jpg")
                        .build().getScreenShotFileAddress();

                Log.e("Address Msg", getFileAddress);
```

All fields are compulsory to set, showing in usage


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## If this library helps you in anyway, show your love ❤️ by putting a ⭐ on this project ✌️

