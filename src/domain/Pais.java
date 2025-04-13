/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author agust
 */
public class Pais {
    private final String nombre;
    private final String codigoIso;

    public Pais(String nombre, String codigoIso) {
        this.nombre = nombre;
        this.codigoIso = codigoIso;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigoIso() {
        return codigoIso;
    }
     public String toString() {
        return nombre; // Retorna el nombre del país
    }
}
