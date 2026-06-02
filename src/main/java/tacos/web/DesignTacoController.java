package tacos.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.Taco;
import tacos.TacoOrder;
import tacos.User;
import tacos.data.IngredientRepository;
import tacos.data.TacoRepository;
import tacos.data.UserRepository;

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;
    private final TacoRepository tacoRepo;
    private final UserRepository userRepo;

    public DesignTacoController(IngredientRepository ingredientRepo,
                                TacoRepository tacoRepo,
                                UserRepository userRepo) {
        this.ingredientRepo = ingredientRepo;
        this.tacoRepo = tacoRepo;
        this.userRepo = userRepo;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        for (Type type : Type.values()) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(type));
        }
    }

    @ModelAttribute(name = "order")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @ModelAttribute(name = "user")
    public User user(Principal principal) {
        if (principal == null) {
            return null;
        }
        return userRepo.findByUsername(principal.getName());
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(@Valid @ModelAttribute("taco") Taco taco,
                              Errors errors,
                              @ModelAttribute("order") TacoOrder order) {
        if (errors.hasErrors()) {
            return "design";
        }
        Taco savedTaco = tacoRepo.save(taco);
        order.addTaco(savedTaco);
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(Type type) {
        List<Ingredient> filtered = new ArrayList<>();
        for (Ingredient ingredient : ingredientRepo.findAll()) {
            if (ingredient.getType() == type) {
                filtered.add(ingredient);
            }
        }
        return filtered;
    }
}
