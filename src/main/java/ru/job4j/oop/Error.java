package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Текущие ошибки: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error errorDefault = new Error();
        errorDefault.printInfo();
        Error error5 = new Error(true, 7, "ошибка номер 5");
        error5.printInfo();
        Error errorAgain = new Error(false, 666, "Усё! Карачун тебе, Церетели! (с)");
        errorAgain.printInfo();
    }
}
