package com.gmail.madivoso.lib.managers;

import com.gmail.madivoso.lib.assets.MListener;

import java.util.ArrayList;
import java.util.List;

public class ListenerManager {

    private List<MListener> listeners;

    public ListenerManager() {
        listeners = new ArrayList<>();
    }

    public void addListener(MListener listener) {
        listeners.add(listener);
    }

    public List<MListener> getListeners() {
        return listeners;
    }

}
