package com.company;

class Line {

    private int first;
    private int second;
    private char znak;

    Line() { }

    Line(int first, char znak, int second) {
        this.first = first;
        this.znak = znak;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public char getZnak() {
        return znak;
    }

    public void setZnak(char znak) {
        this.znak = znak;
    }
}
