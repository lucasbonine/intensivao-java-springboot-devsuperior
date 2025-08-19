package com.devsuperior.dslist.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

    @Embeddable
    private class BelongingPK{

        @ManyToOne
        @JoinColumn(name = "game_id")
        private Game game;

        @ManyToOne
        @JoinColumn(name = "list_id")
        private GameList gameList;

        BelongingPK(Game game, GameList gameList) {
            this.game = game;
            this.gameList = gameList;
        }

        BelongingPK(){

        }

        public Game getGame() {
            return this.game;
        }

        public void setGame(final Game game) {
            this.game = game;
        }

        public GameList getGameList() {
            return this.gameList;
        }

        public void setGameList(final GameList gameList) {
            this.gameList = gameList;
        }

        @Override
        public boolean equals(final Object o) {
            if (null == o || this.getClass() != o.getClass()) return false;
            final BelongingPK that = (BelongingPK) o;
            return Objects.equals(this.game, that.game) && Objects.equals(this.gameList, that.gameList);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.game, this.gameList);
        }
    }

    @EmbeddedId
    private BelongingPK belongingPk = new BelongingPK();

    private Integer position;

    public Belonging(Game game, GameList list, Integer position) {
        belongingPk.setGame(game);
        belongingPk.setGameList(list);
        this.position = position;
    }

    public Belonging(){

    }

    public BelongingPK getBelongingPk() {
        return belongingPk;
    }

    public void setBelongingPk(BelongingPK belongingPk) {
        this.belongingPk = belongingPk;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Belonging belonging = (Belonging) o;
        return Objects.equals(belongingPk, belonging.belongingPk);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(belongingPk);
    }
}
