package com.example.illya.studentexpandablegroup;


public class ChildSelectionState {
     private int groupPosition;
    private int childPosition;
    private boolean state;

    public ChildSelectionState(int groupPosition, int childPosition, boolean state) {
        this.groupPosition = groupPosition;
        this.childPosition = childPosition;
        this.state = state;
    }

    public int getGroupPosition() {

        return groupPosition;
    }

    public void setGroupPosition(int groupPosition) {
        this.groupPosition = groupPosition;
    }

    public int getChildPosition() {
        return childPosition;
    }

    public void setChildPosition(int childPosition) {
        this.childPosition = childPosition;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
