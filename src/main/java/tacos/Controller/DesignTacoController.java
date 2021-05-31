package tacos.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import tacos.Bean.Ingredient;
import tacos.Bean.Taco;
import tacos.Bean.Ingredient.Type;

import javax.validation.Valid;

/**
 * @author Fly
 * @date 2021/5/31
 * 设计Taco控制器
 */
//Lombok提供的Logger日志注解
@Slf4j
@Controller
@RequestMapping("/design")      //通用的请求处理
public class DesignTacoController {

    //对RequestMapping的进一步细化类似于 RequestMapping(method=RequestMethod.Get)
    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredientList = Arrays.asList(
                new Ingredient("FLTO","Flour Tortilla", Type.WRAP),
                new Ingredient("COTO","Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF","Ground Beef", Type.PROTEIN),
                new Ingredient("CARN","Carnitas", Type.PROTEIN),
                new Ingredient("TMTO","Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC","Lettuce", Type.VEGGIES),
                new Ingredient("CHEN","Cheddar", Type.CHEESE),
                new Ingredient("JACK","Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA","Salsa", Type.SAUCE),
                new Ingredient("SRCR","Sour Cream", Type.SAUCE)
        );
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),filterByType(ingredientList,type));
        }
        model.addAttribute("design",new Taco());
        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    //处理前端提交的数据
    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors){
        if (errors.hasErrors()){
            return "design";
        }
        //Save the taco design
        //We'll do thid in chapter 3
        log.info("Processing design: " + design);

        return "redirect:/orders/current";
    }
}
