package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.example.demo.dto.ProductoDTO;

import com.example.demo.entity.Producto;

import com.example.demo.repository.ProductoRepository;


//Especificar que esta clase funcionará como servicio
@Service

public class ProductoService {
	
	
	
	@Autowired 
	//qualifier para especificar la clase a inyectar
	@Qualifier("productoRepository")
	private ProductoRepository productoRepository;
	
	//Constructor para inicializar Repositorio
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	
	//GUARDAR PRODUCTO Y ACTUALIZAR
	public ResponseEntity<Object> guardarProducto( ProductoDTO productoDto) {	
		
		//Variale tipo Domicilio que almacenará todos los campos de domicilio
		Optional<Producto> res = productoRepository.findProductoByDescripcionAndPrecioNormalAndPrecioRebajadoAndIdCategoriaAndStockAndTallaAndGeneroAndMarcaAndColor
				(productoDto.getDescripcion() , productoDto.getPrecioNormal(), productoDto.getPrecioRebajado(),productoDto.getIdCategoria(),
				 productoDto.getStock(), productoDto.getTalla(), productoDto.getGenero(), productoDto.getMarca(), productoDto.getColor()) ;
		
		//Mostrar mensaje con pares clave-valor
		HashMap<String,Object> mensaje =new HashMap <>();
		
		//Compara todo el objeto producto recibido para verificar si ya existe		
		if ( res.isPresent()  && productoDto.getId_producto() ==null ) {
			
			//Mostrar mensaje de que ya existe un domicilio con ese email
			mensaje.put("error", true);
			mensaje.put("message","Ya existe un producto igual registrado");
			
			return new ResponseEntity<>(mensaje,HttpStatus.CONFLICT );
			
		}		
		
		//Agregar al mensaje que se registró correctamente
		mensaje.put("message","Se registró producto correctamente");
				
		
		
		//ACTUALIZAR PRODUCTO
		
		//Para verificar si el repositorio no está vacío y se quiere actualizar un domicilio y se cambian los mensajes
		if (res.isPresent()==false  && productoDto.getId_producto() !=null && productoRepository.count()==0   ) {
			mensaje.put("error", true);
			mensaje.put("message","Domicilio no encontrado");
			
			return new ResponseEntity<>(mensaje,HttpStatus.CONFLICT );
		}		
		
		//Si llega el id sería para actualizar el domicilio. Ya no es necesario verificar si el repositorio está vacío por lo anterior
		// se cambian los mensajes
		if(productoDto.getId_producto()  !=null ) {
			mensaje.put("message","Se actualizó producto correctamente");
		}
		
		
		//SI no entra a ninguno de los if anteriores, significa que se creará un nuevo Producto
		//Nuevo objeto tipo Producto
		Producto producto= new Producto ();
		
		//Guardar el objeto producto en el repositorio
		producto.setId_producto(productoDto.getId_producto());
		producto.setDescripcion(productoDto.getDescripcion());
		producto.setPrecioNormal(productoDto.getPrecioNormal());
		producto.setPrecioRebajado(productoDto.getPrecioRebajado());
		producto.setIdCategoria(productoDto.getIdCategoria());
		producto.setStock(productoDto.getStock());
		producto.setTalla(productoDto.getTalla());
		producto.setGenero(productoDto.getGenero());
		producto.setMarca(productoDto.getMarca());
		producto.setColor(productoDto.getColor());
			
		
		//Guardar Producto
		productoRepository.save(producto);
		
		//Mostrar mensaje de que se registró el producto correctamente
		mensaje.put("datos", producto);
		
		//Regresar respuesta con mensaje final
		return new ResponseEntity<>(mensaje, HttpStatus.CREATED );
		
	}		
	
	

	//OBTENER DOMICILIO POR id
	public Producto obtenerporID(Integer id_producto) {
		//Llama al metodo definido findById
		return this.productoRepository.findById(id_producto).get();
			
		}
			
	
	// ELIMINAR UN DOMICILIO POR id
		 
	public void  borrar_por_id( Integer id){	
		//Llama al metodo definido deleteByID
		productoRepository.deleteById(id);
		  
		  }
	 	
	
	//LISTAR TODOS LOS PRODUCTOS
	
	public List<Producto> listarProductos (){
		//Llama al metodo definido findAll
		return productoRepository.findAll();
	}	
	
	
		
	

}
