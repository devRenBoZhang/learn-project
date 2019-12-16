package com.zrb.learn.design.cmd;

public class CommandMain {
    public static void main(String[] args) {
        ReceiveA receiveA = new ReceiveA();
        ConcreteCommandA concreteCommandA = new ConcreteCommandA();
        concreteCommandA.setReceiveA(receiveA);
        Invoker invoker = new Invoker();
        invoker.setCommand(concreteCommandA);

        invoker.execute();
    }
}
