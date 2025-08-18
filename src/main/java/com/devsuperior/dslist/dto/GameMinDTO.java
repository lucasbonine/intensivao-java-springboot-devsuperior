package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import lombok.Builder;
import lombok.Data;

@Data
public class GameMinDTO {
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO(Game game){
        id = game.getId();
        title = game.getTitle();
        year = game.getYear();
        imgUrl = game.getImgUrl();
        shortDescription = game.getShortDescription();
    }
}
