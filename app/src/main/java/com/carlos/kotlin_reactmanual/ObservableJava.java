package com.carlos.kotlin_reactmanual;

import java.util.ArrayList;
import java.util.List;

public class ObservableJava<T> {

    private final T value;

    private final List<Observer<T>> list = new ArrayList<>();

    public ObservableJava (T value){
        this.value = value;
    }

    public void subscribe(Observer<T> observer){
        list.add(observer);
        observer.value(value);
        observer.value1(value);
    }

    interface Observer<T>  {
        void value(T value);
        void value1(T value);
    }

}



