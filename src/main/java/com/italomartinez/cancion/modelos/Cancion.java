package com.italomartinez.cancion.modelos;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "canciones")
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String artista;
    private String album;
    private String genero;
    private String idioma;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    public Cancion() {
    }

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now();
        this.fechaActualizacion = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.fechaActualizacion = LocalDateTime.now();
    }

    public Long getId() {
        return id; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public String getTitulo() { 
        return titulo; 
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo; 
    }

    public String getArtista() {
        return artista; 
    }

    public void setArtista(String artista) { this.artista = artista; }
    public String getAlbum() {
        return album; 
    }

    public void setAlbum(String album) { 
        this.album = album; 
    }

    public String getGenero() { 
        return genero; 
    }

    public void setGenero(String genero) { 
        this.genero = genero; 
    }

    public String getIdioma() { 
        return idioma; 
    }

    public void setIdioma(String idioma) { 
        this.idioma = idioma; 
    }

    public LocalDateTime getFechaCreacion() { 
        return fechaCreacion; 
    }

    public LocalDateTime getFechaActualizacion() { 
        return fechaActualizacion; 
    }
}