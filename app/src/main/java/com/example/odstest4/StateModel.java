package com.example.odstest4;

public class StateModel {

    String statename,statecm;
    int flag;

    public StateModel(String statename, String statecm, int flag) {
        this.statename = statename;
        this.statecm = statecm;
        this.flag = flag;
    }

    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }

    public String getStatecm() {
        return statecm;
    }

    public void setStatecm(String statecm) {
        this.statecm = statecm;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
