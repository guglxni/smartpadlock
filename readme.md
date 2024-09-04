To create an Android app that sends a signal over Wi-Fi to lock and unlock an IoT device (like your ESP8266-controlled servo motor lock), you'll need to develop the app using Android Studio. Here are the steps for generating the APK, including code for the app that communicates with the ESP8266.

### Step 1: Project Setup
1. Install [Android Studio](https://developer.android.com/studio).
2. Create a new Android project with an empty activity.
3. Add the necessary permissions to the `AndroidManifest.xml` to allow the app to access Wi-Fi and the Internet.

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

### Step 2: Design the UI
Open the `activity_main.xml` file to design the layout of the app, which will have two buttons: Lock and Unlock.


### Step 3: Write the App Logic
In the `MainActivity.java` (or `MainActivity.kt` for Kotlin) file, add code to send the HTTP requests to the ESP8266 when the buttons are clicked.

### Step 4: Build and Generate APK
Once the code is ready, you can generate the APK file:
1. Click on **Build > Build Bundle(s) / APK(s) > Build APK(s)** in the Android Studio menu.
2. Wait for the APK to be generated. The APK file will be located in the `app/build/outputs/apk` directory.

### Step 5: Deploy to Your Phone
- Transfer the generated APK file to your Android device.
- Install the APK, making sure you enable installation from unknown sources in the settings.

### Explanation:
- The app has two buttons: **Lock** and **Unlock**.
- When you click a button, the app sends an HTTP GET request to the ESP8266 with either `/lock` or `/unlock` in the URL.
- The ESP8266 receives the request and triggers the corresponding action (lock or unlock).

### Next Steps:
- Replace the IP address (`http://192.168.1.100`) with the actual IP address of your ESP8266 on your Wi-Fi network.
- Optionally, add feedback or status updates (e.g., showing a message when the lock or unlock command is successful).
