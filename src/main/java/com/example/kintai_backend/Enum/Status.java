package com.example.kintai_backend.Enum;

public enum Status {
    NOT_WORKING,
    WORKING,
    LEFT,
    BREAK,
    ABSENT;

    public boolean canTransitionTo(Status next) {
        return switch (this) {
            case NOT_WORKING -> next ==WORKING;
            case WORKING -> (next == BREAK || next == LEFT);
            case BREAK -> next == WORKING;
            case LEFT -> false;
            case ABSENT -> false;
        };
    }
}
