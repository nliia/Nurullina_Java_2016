package ru.kpfu.itis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.model.User;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aleksandrpliskin on 17.02.17.
 */
@Controller
public class IndexController {

    public static List users = new ArrayList<User>();

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("index", "command", new User());
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute
                                  User user,
                          ModelMap model) {
        users.add(user);
        model.addAttribute("list", users);
        return "result";
    }
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(ModelMap model) {
        model.addAttribute("list", users);
        return "result";
    }
}
