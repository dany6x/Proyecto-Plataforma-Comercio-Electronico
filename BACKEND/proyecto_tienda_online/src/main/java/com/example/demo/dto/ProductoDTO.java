package com.example.demo.dto;
import java.io.Serializable;

import com.example.demo.entity.Producto;

//Serializable para enviar y recibir por red
public class ProductoDTO implements Serializable {
	/**
	 * Para versiones
	 */
	private static final long serialVersionUID = 1L;	
	
	//Agregar los atributos del usuario que se van a ocupar, se pueden agregar/ quitar algunos 
	
	private Integer id_producto;	
	private String descripcion;
	private Float precioNormal;
	private Float precioRebajado;
	private Integer idCategoria;
	private Integer stock;
	private String talla;
	private String genero; 
	private String marca; 
	private String color;
	
	//constructor vacio (No borrar, es necesario)
	public ProductoDTO() {
		
	}
	
	//constructor que reciba como parametro a Domicilio
	public ProductoDTO(Producto producto) {
			
		//Hacer asignacion de los datos de Producto hacia DTO
		this.id_producto = producto.getId_producto();
		this.descripcion = producto.getDescripcion();
		this.precioNormal = producto.getPrecioNormal();
		this.precioRebajado = producto.getPrecioRebajado();
		this.idCategoria = producto.getIdCategoria();
		this.stock = producto.getStock();
		this.talla = producto.getTalla();
		this.genero = producto.getGenero();
		this.marca = producto.getMarca();
		this.color = producto.getColor();			
			
	}


	//GETTERS Y SETTERS
	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecioNormal() {
		return precioNormal;
	}

	public void setPrecioNormal(Float precioNormal) {
		this.precioNormal = precioNormal;
	}

	public Float getPrecioRebajado() {
		return precioRebajado;
	}

	public void setPrecioRebajado(Float precioRebajado) {
		this.precioRebajado = precioRebajado;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
	
	
	
	
	
	
	
}


