package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;

import model.Producto;
import service.productService;

@CrossOrigin(origins = "*")
@Controller
public class ProductController {

	@Autowired
	productService productService;
	
	
	@GetMapping(value = "Listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Producto> buscar() {
       return productService.findAll();
        
    }

    @PostMapping(value = "Alta")
    public String aniadirProducto(@ModelAttribute Producto product) {
        productService.create(product);
        return "datos";
    }

    @GetMapping(value = "Eliminar")
    public String eliminarProducto(@RequestParam("idProducto") int idProducto) {
        productService.delete(idProducto);
        return "datos";
    }

	@GetMapping(value = "ListarSeccion", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Producto> buscarPorSeccion(@RequestParam("seccion") String seccion) {
       return productService.findBySeccion(seccion);
        
    }
	
}
