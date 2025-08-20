package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.GameList;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(){

    }

    public  GameListDTO(GameList entity){
        BeanUtils.copyProperties(entity, this);
    }
}