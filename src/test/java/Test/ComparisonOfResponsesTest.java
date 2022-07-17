package Test;

import PageObject.MainPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static Test.Data.Answer.answerList;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ComparisonOfResponsesTest extends BaseUITest {
    private final String questionNumber;
    private final String expected;


    public ComparisonOfResponsesTest(String questionNumber, String expected) {
        this.questionNumber = questionNumber;
        this.expected = expected;
    }

    @Parameterized.Parameters
            public static Object[][] getData() {
                return new Object[][] {
                        {"0", answerList[0]},
                        {"1", answerList[1]},
                        {"2", answerList[2]},
                        {"3", answerList[3]},
                        {"4", answerList[4]},
                        {"5", answerList[5]},
                        {"6", answerList[6]},
                        {"7", answerList[7]},
                };
            }



    @Test
    public void checkFirstAnswer() {
    driver.get(MainPage.URL);

    MainPage mainPage = new MainPage(driver);
    mainPage.ClickButtonAcceptCookies();
    mainPage.scrollToTheQuestionsSection();
    mainPage.clickQuestion(questionNumber);
    String actual = mainPage.getAnswer(questionNumber);

    assertEquals(expected,actual);

    }

}
