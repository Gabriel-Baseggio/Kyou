package com.kyou.mangas.model;

public enum Status {

    IN_PROGRESS("em andamento"),
    FINISHED("finalizado"),
    HIATUS("hiato"),
    NO_DETAILS("sem informações");

    String status;

    Status(String status) {
        this.status = status;
    }
}
