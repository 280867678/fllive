package com.slzhibo.library.analytics;

import android.os.Looper;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes6.dex */
public class UIThreadSet<T> {
    private Set<T> mSet = new HashSet();

    public void add(T t) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.mSet.add(t);
            return;
        }
        throw new RuntimeException("Can't add an activity when not on the UI thread");
    }

    public void remove(T t) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.mSet.remove(t);
            return;
        }
        throw new RuntimeException("Can't remove an activity when not on the UI thread");
    }

    public Set<T> getAll() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return Collections.unmodifiableSet(this.mSet);
        }
        throw new RuntimeException("Can't remove an activity when not on the UI thread");
    }

    public boolean isEmpty() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return this.mSet.isEmpty();
        }
        throw new RuntimeException("Can't check isEmpty() when not on the UI thread");
    }
}
