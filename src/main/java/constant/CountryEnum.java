package constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author wuzhenfei
 * @Description
 * @Date 2020/4/6 21:43
 **/

@Getter
@AllArgsConstructor
public enum CountryEnum {

    ONE(1, "齐"),
    TWO(2, "楚"),
    THREE(3, "燕"),
    FOUR(4, "韩"),
    FIVE(5, "赵"),
    SIX(6, "魏");

    private Integer retCode;
    private String retMessage;

    public static CountryEnum getBycode(Integer code){
        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum element : myArray) {
            if(element.getRetCode().equals(code)){
                return element;
            }
        }
        return null;
    }
}
