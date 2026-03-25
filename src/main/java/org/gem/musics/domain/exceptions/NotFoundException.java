package org.gem.musics.domain.exceptions;

public class NotFoundException extends Exception{

    public NotFoundException(String message, Integer code){
        super(message);
    }

}
