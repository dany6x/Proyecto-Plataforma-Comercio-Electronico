package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.Producto;

public interface ProductoRepository extends JpaRepository <Producto, Integer> {

	Optional<Producto> findProductoByDescripcionAndPrecioNormalAndPrecioRebajadoAndIdCategoriaAndStockAndTallaAndGeneroAndMarcaAndColor (	
	String descripcion,
	Float precioNormal,
	Float precioRebajado,
	Integer idCategoria,
	Integer stock,
	String talla,
	String genero, 
	String marca,
	String color);

}
