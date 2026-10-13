
package com.itb.inf2em.vitrine.model.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@JsonPropertyOrder({
        "id",
        "ddd",
        "numero"
})

@Embeddable
public class Telefone {

    @Column(name = "ddd", length = 2, nullable = false)
    private String ddd;

    @Column(name = "numero", length = 9, nullable = false)
    private String numero;


    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}