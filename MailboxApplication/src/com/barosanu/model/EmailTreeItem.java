package com.barosanu.model;

import javafx.scene.control.TreeItem;

/**
 * Created by DELL on 2020-06-02.
 */
public class EmailTreeItem<String> extends TreeItem<String> {

    private String name;

    public EmailTreeItem(String name) {
        super(name);
        this.name = name;
    }
}
