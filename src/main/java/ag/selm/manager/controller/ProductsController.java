package ag.selm.manager.controller;

import ag.selm.manager.controller.payload.NewProductPayload;
import ag.selm.manager.entity.Product;
import ag.selm.manager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/products")
public class ProductsController {
    private final ProductService productService;


    //@RequestMapping(value = "list", method = RequestMethod.GET)
    @GetMapping("list")
    public String getProductsList(Model model){
        model.addAttribute("products", this.productService.findAllProducts());
        return "catalogue/products/list";
    }

    @GetMapping("create")
    public String getNewProductPage(){
        return "catalogue/products/create";
    }

    @PostMapping("create")
    public String createProduct(NewProductPayload payload){
        Product product = this.productService.createProduct(payload.title(),payload.details());
        return "redirect:/catalogue/products/%d".formatted(product.getId());
    }


//    @ModelAttribute("product")
//    public Product product(@PathVariable("productID") int productID){
//        return this.productService.findProduct(productID).orElseThrow();
//    }
//
//
//    @GetMapping("{productID:\\d+}")
//    public String getProduct (@PathVariable("productID") int productID , Model model){
//        model.addAttribute("product", this.productService.findProduct(productID).orElseThrow());
//        return "/catalogue/products/product";
//    }
//
//    @GetMapping("{productID:\\d+}")
//    public String getProductEditPage(@PathVariable("productID") int productID, Model model) {
//        model.addAttribute("product", this.productService.findProduct(productID).orElseThrow());
//        return "/catalogue/products/edit";
//    }
//
//    Второй раз пишем похожий код поэтому делаем отдельный метода для получения по ID

}
