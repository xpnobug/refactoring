package com.kdg.refactoring.kdgservice.travel.entity;

import java.util.List;

/**
 * @author 86136
 */
public class MenuItem {
    private String value;
    private String label;
    private List<MenuItem> children;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<MenuItem> getChildren() {
        return children;
    }

    public void setChildren(List<MenuItem> children) {
        this.children = children;
    }
}
