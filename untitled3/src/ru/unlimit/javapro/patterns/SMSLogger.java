package ru.unlimit.javapro.patterns;

class SMSLogger extends Logger{
    public SMSLogger(int priority) {super(priority);}

    public void write(String message) {
        System.out.println("СМС: " +message);
    }
}