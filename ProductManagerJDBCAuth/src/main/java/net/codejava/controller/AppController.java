package net.codejava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.model.Cart;
import net.codejava.model.Financial;
import net.codejava.model.Product;
import net.codejava.model.Users;
import net.codejava.service.CartService;
import net.codejava.service.FinancialService;
import net.codejava.service.ProductService;
import net.codejava.service.UsersService;

@Controller
public class AppController {
	@Autowired
	private ProductService productservice;
	
	@Autowired
	private UsersService usersservice;
	
	@Autowired
	private CartService cartservice;
	
	@Autowired
	private FinancialService financialservice;
	
	
	@RequestMapping("/")
	public String viewHomePage() {
		return "index";
	}
	
	//index
	@RequestMapping("/manager")
	public String viewFromManager(Model model) {
		List<Users> listUsers = usersservice.listAll();
		model.addAttribute("listUsers", listUsers);
		
		List<Product> listProducts = productservice.listAll();
		model.addAttribute("listProducts", listProducts);
		
		List<Financial> listFinancial = financialservice.listAll();
		model.addAttribute("listFinancial", listFinancial);
		
		
		return "manager";
	}
	
	@RequestMapping("/employee")
	public String viewFromEmployee(Model model) {
		List<Product> listProducts = productservice.listAll();
		model.addAttribute("listProducts", listProducts);
		
		
		List<Cart> listCart= cartservice.listAll();
		model.addAttribute("listCart", listCart);
		
		List<Users> listUsers = usersservice.listAll();
		model.addAttribute("listUsers", listUsers);

		
		return "employee";
	}
	
	
	//Products
	@RequestMapping("/newproduct")
	public String showNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "new_product";
	}
	
	@RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		productservice.save(product);
		return "redirect:/";
	}
	
	
	@RequestMapping("/editproduct/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_product");
		
		Product product = productservice.get(id);
		mav.addObject("product", product);
		
		return mav;
	}	
	
	@RequestMapping("/deleteproduct/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		productservice.delete(id);
		return "redirect:/";
	}
	
	

	//Users
	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public String saveUsers(@ModelAttribute("users") Users users) {
		usersservice.save(users);
		return "redirect:/";
	}
	
	@RequestMapping("/editusers/{user_id}")
	public ModelAndView showEditUsersForm(@PathVariable(name = "user_id") Long id) {
		ModelAndView mav = new ModelAndView("edit_user");
		Users users = usersservice.get(id);
		mav.addObject("users", users);
		return mav;
	}	
	
	@RequestMapping("/deleteusers/{user_id}")
	public String deleteUsers(@PathVariable(name = "user_id") Long id) {
		usersservice.delete(id);
		
		return "redirect:/";
	}
	
	//Carts
	@RequestMapping("/edit_cart/{id}")
	public String showEditCartForm(@PathVariable(name = "id") Long id,Model model) {
		Cart cart = new Cart();
		model.addAttribute("cart", cart);
		
		Product product = productservice.get(id);
		model.addAttribute("product", product);

		List<Users> listUsers = usersservice.listAll();
		model.addAttribute("listUsers", listUsers);
		
		return "edit_cart";
	}	
	
	
	@RequestMapping(value = "/savecart", method = RequestMethod.POST)
	public String saveCart(@ModelAttribute("cart") Cart cart) {
		cartservice.save(cart);

		return "redirect:/";
	}
		
	@RequestMapping("/deletecart/{cart_id}")
	public String deleteCart(@PathVariable(name = "cart_id") Long id) {
		cartservice.delete(id);
		
		return "redirect:/";
	}
	
	
	
	
	//financial
	@RequestMapping("/newfinancial")
	public String viewFromfinancial(Model model) {
		Financial financial = new Financial();
		model.addAttribute("financial", financial);
		
		List<Cart> listCart = cartservice.listAll();
		model.addAttribute("listCart", listCart);

		float sum = 0;
		for(int i=0; i < listCart.size(); i++) {
			
			sum = sum + listCart.get(i).getTotal_price();
		}
		//System.out.println(sum); 
		model.addAttribute("sum", sum);
		
		return "new_financial";
	}
	
	@RequestMapping(value = "/savefinancial", method = RequestMethod.POST)
	public String savefinancial(@ModelAttribute("financial") Financial financial,Model model) {
		financialservice.save(financial);
		
		List<Cart> listCart = cartservice.listAll();
		model.addAttribute("listCart", listCart);
		
		for(int i=0; i < listCart.size(); i++) {
			cartservice.delete(listCart.get(i).getCart_id());
		}
		
		return "redirect:/";
	}
	
}
