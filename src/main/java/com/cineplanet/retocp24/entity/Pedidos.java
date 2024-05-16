package com.cineplanet.retocp24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nroPedido;

    private Long codigoProducto;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    // Constructor por defecto
    public Pedidos() {
    }

    // Constructor con parámetros
    public Pedidos(Long codigoProducto, Integer cantidad, Cliente cliente) {
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.cliente = cliente;
    }

    // Getters y Setters
    public Long getNroPedido() {
        return nroPedido;
    }

    public void setNroPedido(Long nroPedido) {
        this.nroPedido = nroPedido;
    }

    public Long getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Long codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Método toString (opcional)
    @Override
    public String toString() {
        return "Pedidos{" +
                "nroPedido=" + nroPedido +
                ", codigoProducto=" + codigoProducto +
                ", cantidad=" + cantidad +
                ", cliente=" + cliente +
                '}';
    }
}