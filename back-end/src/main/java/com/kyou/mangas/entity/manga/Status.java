package com.kyou.mangas.entity.manga;

public enum Status {

    FINISHED("finalizado"),
    IN_PROGRESS("em andamento"),
    HIATUS("hiato"),
    NO_DETAILS("sem informações");

    String status;

    Status(String status) {
        this.status = status;
    }
}
