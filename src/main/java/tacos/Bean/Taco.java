package tacos.Bean;

import lombok.Data;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Fly
 * @date 2021/5/31
 */
@Data
public class Taco {

    @NotNull
    @Size(min =5,message = "Name must be at least 5 characters long")
    private String name;
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<String> ingredients;
}
