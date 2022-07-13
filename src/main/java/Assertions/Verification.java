package Assertions;

import org.assertj.core.api.BooleanAssert;
import org.assertj.core.api.SoftAssertions;

import org.jsoup.select.Evaluator;

public class Verification {


    SoftAssertions softAssertions=new SoftAssertions();

    public void verifyEquals(String value){
        if(!value.isEmpty()) {
            softAssertions.assertThat(value).isEqualTo(value);

        }

    }


    public BooleanAssert verifyElementNotDisplayed(boolean conditions){
        return softAssertions.assertThat(conditions).isFalse();
    }


    public BooleanAssert verifyElementDisplayed(boolean conditions){
        return softAssertions.assertThat(conditions).isTrue();
    }

    public void verifyDisabled(String value){


    }



}
