
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Drawing extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("MyLittlePony");
        Pane root = new Pane();

        Rectangle body = new Rectangle(200,200,80,40);
        body.setFill(Color.BROWN);

        Rectangle legLeft = new Rectangle(180,250,50,15);
        legLeft.setFill(Color.BLACK);
        legLeft.setRotate(110);

        Rectangle legRight = new Rectangle(250,250,50,15);
        legRight.setFill(Color.BLACK);
        legRight.setRotate(70);

        //Settings
        root.getChildren().addAll(body,legLeft,legRight);
        primaryStage.setScene(new Scene(root,600,600));
        primaryStage.show();

        moveHorseMove(root,body,legLeft,legRight);


    }

    private static void moveHorseMove(Pane root,Rectangle body,Rectangle legLeft,Rectangle legRight){

        Thread thread = new Thread(Runnable() {
            public void run() {
                boolean b =true;
                int leftLegStart = 110;
                int rightLegStart = 90;
                int countLeft = 0;
                int countRight = 0;

                while (b){
                    legLeft.setRotate(leftLegStart-countLeft);
                    legRight.setRotate(rightLegStart+countRight);

                    root.getChildren().remove(legLeft);
                    root.getChildren().remove(legRight);

                    root.getChildren().addAll(legLeft,legRight);
                    countLeft = countLeft+1;
                    countRight = countRight+1;

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //b=false;
                }
            }
        };
        );
    }

}
