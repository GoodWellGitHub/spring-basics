package com.org.base.service.impl;

import com.org.base.service.Poem;

public class PoeticJuggler extends Juggler {
    public PoeticJuggler() {
    }

    private Poem poem;

    public PoeticJuggler(Poem poem) {
        super();
        this.poem = poem;
    }

    public PoeticJuggler(int beanBags, Poem poem) {
        super(beanBags);
        this.poem = poem;
    }

    public void perform() {
        super.perform();
        System.out.println("while reciting....");
        poem.recite();
    }

}
