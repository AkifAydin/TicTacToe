import org.testng.Assert;
import org.testng.annotations.Test;

public class TicTacToeGameTest extends TicTacToeGame{


    @Test
    public void ersteReihe(){
        String[][] test = {{"x", "x", "x"},{"-", "-", "-"},{"-", "-", "-"}};
        Assert.assertTrue(isWinner(test, "x"));
    }

    @Test
    public void zweiteReihe(){
        String[][] test = {{"-", "-", "-"},{"x", "x", "x"},{"-", "-", "-"}};
        Assert.assertTrue(isWinner(test, "x"));
    }

    @Test
    public void dritteReihe(){
        String[][] test = {{"-", "-", "-"},{"-", "-", "-"},{"x", "x", "x"}};
        Assert.assertTrue(isWinner(test, "x"));
    }

    @Test
    public void kreuzLinksOben(){
        String[][] test = {{"x", "-", "-"},{"-", "x", "-"},{"-", "-", "x"}};
        Assert.assertTrue(isWinner(test, "x"));
    }

    @Test
    public void kreuzRechtsOben(){
        String[][] test = {{"-", "-", "x"},{"-", "x", "-"},{"x", "-", "-"}};
        Assert.assertTrue(isWinner(test, "x"));
    }

    @Test
    public void links(){
        String[][] test = {{"x", "-", "-"},{"x", "-", "-"},{"x", "-", "-"}};
        Assert.assertTrue(isWinner(test, "x"));
    }

    @Test
    public void rechts(){
        String[][] test = {{"-", "-", "x"},{"-", "-", "x"},{"-", "-", "x"}};
        Assert.assertTrue(isWinner(test, "x"));
    }

    @Test
    public void fieldFull(){
        String[][] test = {{"x", "x", "x"},{"x", "x", "x"},{"x", "x", "x"}};
        Assert.assertTrue(allFieldsUsed(test));
    }

    @Test
    public void fielUsed(){
        String[][] test = {{"x", "x", "x"},{"x", "-", "x"},{"x", "x", "x"}};
        Assert.assertTrue(isValidField(1,1,test));
    }

}
