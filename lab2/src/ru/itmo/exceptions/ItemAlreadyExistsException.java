package ru.itmo.exceptions;

public class ItemAlreadyExistsException extends Exception {
    public ItemAlreadyExistsException(String msg) {
        super(msg);
    }
}
