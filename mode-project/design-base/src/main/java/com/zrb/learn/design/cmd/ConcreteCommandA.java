package com.zrb.learn.design.cmd;

public class ConcreteCommandA implements Command {
    private ReceiveA receiveA;
    @Override
    public void invoke(Object object) {
        receiveA.action(object);
    }


    public ReceiveA getReceiveA() {
        return receiveA;
    }

    public void setReceiveA(ReceiveA receiveA) {
        this.receiveA = receiveA;
    }
}
