<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools"
android:layout_width="match_parent"
android:layout_height="match_parent"
tools:context=".NotificationView">


    <TextView
        android:id="@+id/textView2"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:text="your detail of notification..."
        android:textAppearance="@style/Base.TextAppearance.AppCompat.Medium"
        tools:layout_editor_absoluteX="0dp"
        tools:layout_editor_absoluteY="154dp" />

    <TextView
    android:id="@+id/textView"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_marginBottom="8dp"
    android:layout_marginTop="8dp"
    android:textAppearance="@style/Base.TextAppearance.AppCompat.Medium"/>
</androidx.constraintlayout.widget.ConstraintLayout>
