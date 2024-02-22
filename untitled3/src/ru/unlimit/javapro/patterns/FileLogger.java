package ru.unlimit.javapro.patterns;

class FileLogger extends Logger {
    public FileLogger(int priority) {super(priority);}
    public void write(String message) {
        System.out.println("Записываем в файл: " +message);
    }
}