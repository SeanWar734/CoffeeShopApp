package co.grandcircus.CoffeeShopDB;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.CoffeeShopDB.Dao.ProductsRepository;
import co.grandcircus.CoffeeShopDB.Dao.UsersDao;
import co.grandcircus.CoffeeShopDB.Objects.Products;
import co.grandcircus.CoffeeShopDB.Objects.UserPreference;
import co.grandcircus.CoffeeShopDB.Objects.Users;

@Controller
public class coffeeController {

	@Autowired
	private ProductsRepository productsdao;
	@Autowired
	private UsersDao usersdao;
	@Autowired
	private HttpSession sesh;

	@RequestMapping("/")
	public ModelAndView index(@SessionAttribute(name = "preference", required = false) UserPreference userPref) {
		List<Products> listOfProducts = productsdao.findAll();
		ModelAndView mav = new ModelAndView("index");

		if (userPref != null) {
			mav.addObject("preference", userPref);
		}
		mav.addObject("products", listOfProducts);
		return mav;
	}

	@PostMapping("/")
	public ModelAndView saveSession(UserPreference pref) {
		sesh.setAttribute("preference", pref);
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping("/clear")
	public ModelAndView clearSession(UserPreference pref) {
		sesh.setAttribute("preference", null);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/admin")
	public ModelAndView admin() {
		List<Products> listOfProducts1 = productsdao.findAll();
		return new ModelAndView("admin", "products", listOfProducts1);
	}

	@RequestMapping("/users")
	public ModelAndView users() {
		List<Users> listOfUsers = usersdao.findAll();
		return new ModelAndView("users", "users", listOfUsers);
	}

	@RequestMapping("/add")
	public ModelAndView newUser() {
		return new ModelAndView("add");
	}

	@RequestMapping("/addItem")
	public ModelAndView newItem() {
		return new ModelAndView("addItem");
	}

	@RequestMapping("/product/update")
	public ModelAndView productPage(@RequestParam("id") Long id) {
		ModelAndView mv = new ModelAndView("product");
		mv.addObject("product", productsdao.findById(id).orElse(null));
		return mv;
	}

	@PostMapping("/product/confirm")
	public ModelAndView submitEditForm(Products product) {
		productsdao.save(product);
		return new ModelAndView("redirect:/admin");
	}

	@PostMapping("/product/add")
	public ModelAndView submitAddForm(Products product) {
		productsdao.save(product);
		return new ModelAndView("redirect:/admin");
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

	@RequestMapping("/product/delete")
	public ModelAndView delete(@RequestParam("id") Long id) {
		productsdao.deleteById(id);
		return new ModelAndView("redirect:/admin");
	}

}
