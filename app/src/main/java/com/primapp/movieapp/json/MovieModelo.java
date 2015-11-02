package com.primapp.movieapp.json;

/**
 * Created by Moises on 02/11/2015.
 */
public class MovieModelo {

    private int id;
    private String titulo, posterRuta;

    public MovieModelo(){
    }

    public int getId(){return id;}

    public void setId(int id) {this.id = id;}

    public String getTitulo() {return titulo;}

    public void setTitulo(String title) {this.titulo = title;}

    public String getPosterRuta() {return posterRuta;}

    public void setPosterRuta(String posterPath) {this.posterRuta = posterPath;}

}
