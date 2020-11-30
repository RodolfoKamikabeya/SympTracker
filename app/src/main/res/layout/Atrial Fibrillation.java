<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fadeScrollbars="true"
    android:isScrollContainer="false"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/txtTitle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:text="@string/txtTitle"
        android:textSize="24sp" />

    <TextView
        android:id="@+id/txtSymptom"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/txtTitle"
        android:layout_centerHorizontal="true"
        android:layout_marginStart="-139dp"
        android:layout_marginTop="2dp"
        android:text="@string/txtSymptom" />

    <TextView
        android:id="@+id/tvOverview"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/txtSymptom"
        android:layout_alignLeft="@id/txtSymptom"
        android:layout_marginLeft="-102dp"
        android:layout_marginTop="8dp"
        android:text="Overview"
        android:textStyle="bold" />

    <TextView
        android:id="@+id/txtOverview"
        android:layout_width="342dp"
        android:layout_height="50dp"
        android:layout_below="@id/tvOverview"
        android:layout_alignLeft="@id/tvOverview"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="4dp"
        android:text="@string/txtOverview"
        android:textSize="12sp" />

    <TextView
        android:id="@+id/tvCommon"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/tvOverview"
        android:layout_alignLeft="@id/txtOverview"
        android:layout_marginLeft="35dp"
        android:layout_marginTop="58dp"
        android:text="How Common"
        android:textSize="12sp"
        android:textStyle="bold" />

    <TextView
        android:id="@+id/txthowCommon"
        android:layout_width="262dp"
        android:layout_height="37dp"
        android:layout_below="@id/tvCommon"
        android:layout_alignLeft="@id/tvCommon"
        android:layout_marginLeft="4dp"
        android:layout_marginTop="6dp"
        android:text="@string/txthowCommon"
        android:textSize="12sp" />

    <TextView
        android:id="@+id/txtSymptomView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/tvCommon"
        android:layout_alignLeft="@id/txthowCommon"
        android:layout_marginLeft="0dp"
        android:layout_marginTop="53dp"
        android:text="Symptoms"
        android:textSize="12sp"
        android:textStyle="bold" />

    <TextView
        android:id="@+id/txtSymptoms"
        android:layout_width="268dp"
        android:layout_height="51dp"
        android:layout_below="@id/txtSymptomView"
        android:layout_alignLeft="@id/txtSymptomView"
        android:layout_marginLeft="4dp"
        android:layout_marginTop="5dp"
        android:text="@string/txtSymptoms"
        android:textSize="12sp" />

    <TextView
        android:id="@+id/txtTreatment"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/txtSymptom"
        android:layout_alignLeft="@id/txtSymptom"
        android:layout_marginLeft="-48dp"
        android:layout_marginTop="244dp"
        android:text="Treatments"
        android:textSize="12sp"
        android:textStyle="bold" />

    <TextView
        android:id="@+id/txtStatement"
        android:layout_width="348dp"
        android:layout_height="wrap_content"
        android:layout_below="@id/txtSymptom"
        android:layout_alignLeft="@id/txtSymptom"
        android:layout_marginLeft="-52dp"
        android:layout_marginTop="267dp"
        android:text="@string/txtStatement"
        android:textSize="12sp" />

    <TextView
        android:id="@+id/tvTreatment"
        android:layout_width="331dp"
        android:layout_height="206dp"
        android:layout_below="@id/txtTreatment"
        android:layout_alignLeft="@id/txtTreatment"
        android:layout_marginLeft="0dp"
        android:layout_marginTop="45dp"
        android:text="@string/tvTreatment"
        android:textSize="12sp" />

    <Button
        android:id="@+id/btnQuickoverview"
        android:layout_width="272dp"
        android:layout_height="76dp"
        android:layout_below="@id/txtTreatment"
        android:layout_alignRight="@id/tvTreatment"
        android:layout_alignParentTop="true"
        android:layout_alignParentEnd="true"
        android:layout_marginTop="598dp"
        android:layout_marginEnd="50dp"
        android:layout_marginRight="50dp"
        android:background="#8BC34A"
        android:backgroundTint="#7CB342"
        android:scrollbarAlwaysDrawHorizontalTrack="true"
        android:text="@string/btnQuickoverview"
        android:textAlignment="center"
        android:textColor="#000000"
        android:textSize="22sp"
        android:textStyle="bold|italic" />


</RelativeLayout>


