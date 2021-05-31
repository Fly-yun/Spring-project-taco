package tacos.Bean;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author Fly
 * @date 2021/5/31
 * Bean：原料类
 */

@Data
@RequiredArgsConstructor
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public static enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
