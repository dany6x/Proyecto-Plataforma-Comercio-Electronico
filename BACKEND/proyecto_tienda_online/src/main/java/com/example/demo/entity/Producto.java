package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Indicar que esta clase es una entidad con:
@Entity

//Indicar la tabla a la que hace referencia
@Table (name="producto", schema="public")

public class Producto {
	//Indicar que id va a trabajar como llave primaria
		@Id
		//Indicar el valor autoincrementable 
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		
		
		//ATRIBUTOS
		@Column(name = "id_producto")
		private Integer id_producto;
		@Column(name = "descripcion")
		private String descripcion;
		@Column(name = "precio_normal")
		private Float precioNormal;
		@Column(name = "precio_rebajado")
		private Float precioRebajado;
		@Column(name = "id_categoria")
		private Integer idCategoria;
		@Column(name = "stock")
		private Integer stock;
		@Column(name = "talla")
		private String talla;
		@Column(name = "genero")
		private String genero; 
		@Column(name = "marca")
		private String marca; 
		@Column(name = "color")
		private String color;


		//campo unico para verificar antes de registrarlo
		//@Column (unique=true)
		//private String email;
			
		
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
				
		
		
		
		
		
		
	
	

}
