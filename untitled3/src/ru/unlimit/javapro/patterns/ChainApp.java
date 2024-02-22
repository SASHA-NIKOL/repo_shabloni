package ru.unlimit.javapro.patterns;
public class ChainApp {
    public static void main(String[] args){
        Logger logger0 = new SMSLogger(Level.ERROR);
        Logger logger1 = new FileLogger(Level.DEBUG);
        Logger logger2 = new EmailLogger(Level.INFO);
        logger0.setNext(logger1);
        logger1.setNext(logger2);
        logger0.writeMessage("Все хорошо", Level.INFO);
        logger0.writeMessage("идет режим отладки", Level.DEBUG);
        logger0.writeMessage("Система упала", Level.ERROR);
    }
}
