package GameSettings;

import javafx.scene.paint.Color;

public abstract class GameSettings {
    abstract void readSettingsData();

    abstract void updateSettingsData();
}

class TimerSettings extends GameSettings {

    boolean timerIsOn;
    int timeInSecond;

    public void setTimerIsOn(boolean isOn) {
        this.timerIsOn = isOn;
    }

    public boolean getTimerIsOn() {
        return timerIsOn;
    }

    public int getTimeInSecond() {
        return timeInSecond;
    }

    public void setTimeInSecond(int timeInSecond) {
        this.timeInSecond = timeInSecond;
    }

    @Override
    public void readSettingsData() {

    }

    @Override
    public void updateSettingsData() {

    }
}

class PieceSettings extends GameSettings {

    Color pieceColor;

    public void setPieceColor(Color pieceColor) {
        this.pieceColor = pieceColor;
    }

    public Color getPieceColor() {
        return pieceColor;
    }

    @Override
    public void readSettingsData() {

    }

    @Override
    public void updateSettingsData() {

    }
}

class CompleteSettings {

}

class GameOverSettings extends GameSettings {
    int minimumNumberOfGoat;

    public void setMinimumNumberOfGoat(int minimumNumberOfGoat) {
        this.minimumNumberOfGoat = minimumNumberOfGoat;
    }

    public int getMinimumNumberOfGoat() {
        return minimumNumberOfGoat;
    }

    @Override
    void readSettingsData() {

    }

    @Override
    void updateSettingsData() {

    }
}