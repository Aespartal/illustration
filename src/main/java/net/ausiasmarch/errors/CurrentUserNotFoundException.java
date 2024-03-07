package net.ausiasmarch.errors;

public class CurrentUserNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public CurrentUserNotFoundException() {
        super("Current user login not found");
    }
}
