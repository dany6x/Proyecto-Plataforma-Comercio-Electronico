package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dto.ProductoDTO;

import com.example.demo.entity.Producto;

import com.example.demo.service.ProductoService;

//Indicar que esta clase va a servir para recibir peticiones del cliente 
@RestController


public class ProductoController {
	
	//Inyectar como dependencia el servicio al controlador con autowired
	@Autowired
	public ProductoService productoService;
	
		
	//GUARDAR PRODUCTO
	@PostMapping ("/guardarProductoDTO")
	public ResponseEntity<Object> guardarProducto(@RequestBody ProductoDTO productoDto) {
				
		try {
			return productoService.guardarProducto(productoDto);
			
		} catch(Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}	
	
	//OBTENER PRODUCTO A TRAVÉS DEL id (GET)
	/**
	 * @param id
	 * @return
	 */
	@GetMapping ("/obtenerProductoDTO/{id_producto}")
	
	//retorna objeto que puede ser los datos del domicilio o mensaje de error
	public ResponseEntity<Object> obtenerProducto(@PathVariable("id_producto") Integer id_producto){
		
		try {
			Producto producto= this.productoService.obtenerporID(id_producto);
			
			//mandar los datos a traves del DataDTO
			ProductoDTO datos= new ProductoDTO(producto);
			
			//retornar el estatus como respuesta asumiendo que la petición es positiva
			return ResponseEntity.status(HttpStatus.OK).body(datos);
		} catch(Exception e) {
			//return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: Producto no encontrado");
			
		}
		
	  }	
	
	
	//ACTUALIZAR Producto - Usa el mismo método que guardar 
		@PutMapping("/actualizarProductoDTO")
		public ResponseEntity<Object>actualizarProducto(@RequestBody ProductoDTO productoDto){
			try {
				return productoService.guardarProducto(productoDto);
				
			} catch(Exception e) {
				//return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: Producto no encontrado");
			}
		}
		
	
	
	//ELIMINAR PRODUCTO POR id
		@DeleteMapping ("/borrarProducto/{id}")

		private ResponseEntity <String> borrarProducto (@PathVariable("id") Integer id) {
			try {
				productoService.borrar_por_id (id);
				return ResponseEntity.status(HttpStatus.OK).body("Producto eliminado correctamente");
				//return ResponseEntity.ok().build();
			} catch(Exception e) {
				//return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: Producto no encontrado");
			}

		}	
	
	//LISTAR TODOS LOS PRODUCTOS
		
	@GetMapping("/listarProductos")
	public ResponseEntity<List<Producto>> listarProductos(){
		
		//Crear lista vacia
		List<Producto> respuesta=null; 
		
		try {
			respuesta = productoService.listarProductos();
			return ResponseEntity.ok().body(respuesta);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 			
		}
		
	}
	
	

	
	
	
	
	
	
	
	
	
}
