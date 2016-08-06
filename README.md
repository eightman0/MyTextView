# MyTextView

Installation
Gradle
  
In top level gradle file, add this

allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}

dependencies {
    compile 'com.github.eightman0:MyTextView:0.1'
}


Usage

<com.app.eightman.mytextview.MyTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:customFont="fonts/your_font" //your_font must be ttf
        android:text="Hello World!" />
        
LICENSE
The MIT License (MIT)
    
