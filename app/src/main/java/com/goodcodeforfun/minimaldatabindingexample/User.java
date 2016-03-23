package com.goodcodeforfun.minimaldatabindingexample;

import android.databinding.ObservableField;

/**
 * Created by snigavig on 23.03.16.
 */
public class User {
    public final ObservableField<String> name = new ObservableField<>();
    public int messageCount;

    public User() {
    }
}