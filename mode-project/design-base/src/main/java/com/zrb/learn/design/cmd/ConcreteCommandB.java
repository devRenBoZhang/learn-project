package com.zrb.learn.design.cmd;

public class ConcreteCommandB implements Command {
    private ReceiveB receiveB;
    @Override
    public void invoke(Object object) {
        receiveB.action(object);
    }

    public ReceiveB getReceiveB() {
        return receiveB;
    }

    public void setReceiveB(ReceiveB receiveB) {
        this.receiveB = receiveB;
    }
}
