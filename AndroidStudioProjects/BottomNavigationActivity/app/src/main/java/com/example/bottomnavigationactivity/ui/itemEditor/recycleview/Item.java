package com.example.bottomnavigationactivity.ui.itemEditor.recycleview;

public class Item {
    private String type;
    private String fileName;

    public Item(String type, String fileName) {
        this.type = type;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
