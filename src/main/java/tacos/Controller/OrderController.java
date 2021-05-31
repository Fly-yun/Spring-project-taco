package tacos.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.Bean.Order;

import javax.validation.Valid;

/**
 * @author Fly
 * @date 2021/5/31
 * 订单类
 */

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    //展示当前订单
    @GetMapping("/current")
    public String orderForm(Model model){
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    //处理taco提交的表单
    @PostMapping
    public String processOrder(@Valid Order order, Errors errors){
        if (errors.hasErrors()){
            return "orderForm";
        }
        log.info("Order submitted:" + order);
        return "redirect:/";
    }
}
