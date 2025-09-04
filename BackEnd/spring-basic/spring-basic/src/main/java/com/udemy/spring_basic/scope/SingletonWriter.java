package com.udemy.spring_basic.scope;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Component
public class SingletonWriter {
    private final ObjectProvider<PrototypeNote> noteProvider;

    public SingletonWriter(ObjectProvider<PrototypeNote> noteProvider) {
        this.noteProvider = noteProvider;
    }

    public void writeTwice(String a, String b){
        PrototypeNote note1 = noteProvider.getObject();
        note1.write(a);
        note1.close();

        PrototypeNote note2 = noteProvider.getObject();
        note2.write(b);
        note2.close();
    }
}
