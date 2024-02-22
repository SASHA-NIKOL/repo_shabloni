package ru.unlimit.javapro.patterns;

public class AbstractFactiryApp {

    public static void main(String[] args) {

        DeviseFactory factory = getFactoryByCountryCode("EN");
        Mouse       m = factory.getMouse();
        keyboard    k = factory.getkeyboard();
        touchpad    t = factory.gettouchpad();

        m.click();
        k.print();
        k.printeln();
        t.track(10, 35);
    }
    private static DeviseFactory getFactoryByCountryCode(String lang){
        switch (lang){
            case "RU":
                return new RuDeviceFactory();
            case "EN":
                return new EnDeviceFactory();
            default:
                throw new RuntimeException("Unsupported Country Code: " + lang);

        }
    }
}

interface Mouse {
    void click();
    void dblclick();
    void scroll(int derection);
}
interface keyboard {
    void print();
    void printeln();
}
interface touchpad{
    void track(int deltaX, int deltaY);
}
interface DeviseFactory{
    Mouse getMouse();
    keyboard getkeyboard();
    touchpad gettouchpad();

}

class RuMouse implements Mouse{
    public void click() {System.out.println("Щелчок мышью");}
    public void dblclick() {System.out.println("Двойной щелчок мышью");}
    public void scroll(int direction) {
        if (direction>0)
            System.out.println("Скроллим вверх");
        else if (direction<0)
            System.out.println("Скроллим вниз");
        else
            System.out.println("Не скроллим");
    }
}
class Rukeyboard implements keyboard{
    public void print() {System.out.println("Печатаем строку");}
    public void printeln() {System.out.println("Печатаем строку с переводом строки");}
}

class Rutouchpad implements touchpad {
    public void track(int deltaX, int deltaY) {
        int s =(int) Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaY, 2));
        System.out.println("Передвинулись на " + s + " пикселей");

    }
}

class EnMouse implements Mouse{
    public void click() {System.out.println("Mouse click");}
    public void dblclick() {System.out.println("Mouse double click");}
    public void scroll(int direction) {
        if (direction>0)
            System.out.println("Scroll Up");
        else if (direction<0)
            System.out.println("Scroll Down");
        else
            System.out.println("No scrolling");
    }
}
class Enkeyboard implements keyboard{
    public void print() {System.out.println("Print");}
    public void printeln() {System.out.println("Print Line");}
}

class Entouchpad implements touchpad {
    public void track(int deltaX, int deltaY) {
        int s =(int) Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaY, 2));
        System.out.println("Moved " + s + " pixels");

    }
}

class EnDeviceFactory implements DeviseFactory {
    public Mouse getMouse(){
        return new EnMouse();
    }
    public keyboard getkeyboard(){
        return new Enkeyboard();
    }
    public touchpad gettouchpad(){
        return new Entouchpad();
    }
}
class RuDeviceFactory implements DeviseFactory{
    public Mouse getMouse(){
        return new RuMouse();
    }
    public keyboard getkeyboard(){
        return new Rukeyboard();
    }
    public touchpad gettouchpad(){
        return new Rutouchpad();
    }
}