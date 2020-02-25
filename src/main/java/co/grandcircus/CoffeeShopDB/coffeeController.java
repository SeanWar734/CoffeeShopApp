package co.grandcircus.CoffeeShopDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.CoffeeShopDB.Dao.ProductsDao;
import co.grandcircus.CoffeeShopDB.Dao.UsersDao;
import co.grandcircus.CoffeeShopDB.Objects.Users;

@Controller
public class coffeeController {
	
	@Autowired
	private ProductsDao productsdao;
	@Autowired
	private UsersDao usersdao;

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/add")
	public ModelAndView newUser() {
		return new ModelAndView("add");
	}
	
	@RequestMapping("/confirm")
	public ModelAndView confirmUser(
			@RequestParam("first_name") String first_name,
			@RequestParam("last_name") String last_name,
			@RequestParam("email") String email,
			@RequestParam("phone_number") int phone_number,
			@RequestParam("password") String password) {
		
		ModelAndView mv = new ModelAndView("confirm");
		
		mv.addObject("first_name", first_name);
		mv.addObject("last_name", last_name);
		mv.addObject("email", email);
		mv.addObject("phone_number", phone_number);
		mv.addObject("password", password);
		
		return mv;
	}
	
	@RequestMapping("/confirm/yes")
	public ModelAndView iSureHope(
			@RequestParam("first_name") String first_name,
			@RequestParam("last_name") String last_name,
			@RequestParam("email") String email,
			@RequestParam("phone_number") int phone_number,
			@RequestParam("password") String password) {
		
		Users user = new Users();
		
		user.setFirst_name(first_name);
		user.setLast_name(last_name);
		user.setEmail(email);
		user.setPhone_number(phone_number);
		user.setPassword(password);
		
		usersdao.create(user);
		
		return new ModelAndView("Redirect:/");
	}
	
}
