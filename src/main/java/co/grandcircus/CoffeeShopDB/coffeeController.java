package co.grandcircus.CoffeeShopDB;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.CoffeeShopDB.Dao.ProductsDao;
import co.grandcircus.CoffeeShopDB.Dao.UsersDao;
import co.grandcircus.CoffeeShopDB.Objects.Products;
import co.grandcircus.CoffeeShopDB.Objects.Users;

@Controller
public class coffeeController {

	@Autowired
	private ProductsDao productsdao;
	@Autowired
	private UsersDao usersdao;

	@RequestMapping("/")
	public ModelAndView index() {
		List<Products> listOfProducts = productsdao.findAll();
		return new ModelAndView("index", "products", listOfProducts);
	}

	@RequestMapping("/add")
	public ModelAndView newUser() {
		return new ModelAndView("add");
	}

	@RequestMapping("/confirm")
	public ModelAndView confirmUser(@RequestParam("first_name") String first_name,
			@RequestParam("last_name") String last_name, @RequestParam("email") String email,
			@RequestParam("phone_number") String phone_number, @RequestParam("password") String password) {

		Users user = new Users(first_name, last_name, email, phone_number, password);
		usersdao.create(user);

		ModelAndView mv = new ModelAndView("confirm");

		mv.addObject("first_name", first_name);
		mv.addObject("last_name", last_name);
		mv.addObject("email", email);
		mv.addObject("phone_number", phone_number);
		mv.addObject("password", password);

		return mv;
	}

}
