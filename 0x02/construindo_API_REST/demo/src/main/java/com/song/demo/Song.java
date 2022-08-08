package com.song.demo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Song {

    private Integer id;
    private String nome;
    private String artista;
    private String album;
    private String anoLancamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    /*public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Song song)) return false;
        if (!super.equals(object)) return false;

        if (getId() != null ? !getId().equals(song.getId()) : song.getId() != null) return false;
        if (getNome() != null ? !getNome().equals(song.getNome()) : song.getNome() != null) return false;
        if (getArtista() != null ? !getArtista().equals(song.getArtista()) : song.getArtista() != null) return false;
        if (getAlbum() != null ? !getAlbum().equals(song.getAlbum()) : song.getAlbum() != null) return false;
        return getAnoLancamento() != null ? getAnoLancamento().equals(song.getAnoLancamento()) : song.getAnoLancamento() == null;
    }*/

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getArtista() != null ? getArtista().hashCode() : 0);
        result = 31 * result + (getAlbum() != null ? getAlbum().hashCode() : 0);
        result = 31 * result + (getAnoLancamento() != null ? getAnoLancamento().hashCode() : 0);
        return result;
    }


    public String toString() {
        return "Song{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", artista='" + artista + '\'' +
                ", album='" + album + '\'' +
                ", anoLancamento='" + anoLancamento + '\'' +
                '}';
    }
}
