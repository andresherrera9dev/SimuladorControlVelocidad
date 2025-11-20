package com.ITCelaya.simuladorcontrolvelocidad.util;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class CarMovement {
    public static void simulateCarMovement(double targetX, double seconds, ImageView imageCar) {
        double startX = imageCar.getLayoutX();
        double deltaX = targetX - startX;
        TranslateTransition tt = new TranslateTransition(Duration.seconds(seconds), imageCar);
        tt.setFromX(0);
        tt.setToX(deltaX);
        tt.setInterpolator(Interpolator.EASE_BOTH);
        tt.play();
    }
    public static void initCarMovement(ImageView imageCar) {
        TranslateTransition tt = new TranslateTransition(Duration.seconds(1), imageCar);
        tt.setFromX(0);
        tt.setToX(0);
        tt.play();
    }
}
