package pragyagui;

import static java.lang.System.exit;
import static java.lang.Thread.sleep;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {
    
     private int magicNumber;
    private int a[] = new int[10];
     @FXML
    private Label magicnumframe;
      @FXML
    private Label magicnumframe1;

    @FXML
    private Label answerframe;

    @FXML
    private TextField answer;
    
   
    public void validateAnswer(ActionEvent event){
        if(Integer.parseInt(answer.getText()) == this.getAnswer()){
            answerframe.setText("SUCCESS");
        }else{
            answerframe.setText("GAME OVER!!!");
//            try{sleep(2000);}catch(Exception e){System.out.println("EXCEPTION");}
//            exit(0);
        }
    }
    
    public void newGame(ActionEvent event){
        System.out.println("NEW GAME");
       this.setQuestion();
    }
     public void setQuestion() {
        Random rand = new Random();
        this.magicNumber = rand.nextInt(9) + 1;
        System.out.println(magicNumber);
        int size = 10;
        String optionsString = "";
        
        for (int i = 0; i <= size - 1; i++) {
            a[i] = rand.nextInt(9) + 0;
            optionsString = optionsString + Integer.toString(a[i]) + " , ";
        }
        optionsString = optionsString.substring(0,optionsString.length()-2);
        magicnumframe.setText(Integer.toString(magicNumber));
        magicnumframe1.setText(optionsString);
    }
     public int getAnswer() {
        int count = 0;
        for (int i = 0; i <= a.length - 1; i++) {
            for (int j = i + 1; j <= a.length - 1; j++) {
                if ((a[i] + a[j]) == magicNumber) {
                    count++;
                }
            }
        }
        return count;
    }
}
