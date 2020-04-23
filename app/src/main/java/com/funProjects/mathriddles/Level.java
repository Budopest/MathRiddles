package com.funProjects.mathriddles;

public class Level {
    private int levelNumber;
    private String solution;
    private String hint;
    private int status;

    public Level(int levelNumber, String solution, String hint, int status){
        this.levelNumber = levelNumber;
        this.solution = solution;
        this.hint = hint;
        this.status = status;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
