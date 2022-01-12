package com.example.bottomnavigationactivity.ui.itemEditor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemEditorViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ItemEditorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}