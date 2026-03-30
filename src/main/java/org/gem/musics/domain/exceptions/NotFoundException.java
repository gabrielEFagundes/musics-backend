package org.gem.musics.domain.exceptions;

public class NotFoundException extends Exception{

    Integer code;

    public NotFoundException(String message){
        super(message);
        this.code = 404;
    }

}
