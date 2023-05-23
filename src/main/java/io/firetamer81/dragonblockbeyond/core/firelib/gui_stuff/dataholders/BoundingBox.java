package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.dataholders;

public class BoundingBox {

    int[] boundsData = new int[4];

    public BoundingBox(int leftBound, int topBound, int rightBound, int bottomBound) {
        boundsData[0] = leftBound;      //Smaller X-Value
        boundsData[1] = topBound;       //Smaller Y-Value
        boundsData[2] = rightBound;     //Larger X-Value
        boundsData[3] = bottomBound;    //Larger Y-Value
    }

    //<editor-fold desc="Get Methods">
    public int[] getBoundsData() { return boundsData; }

    public int  getLeftBound() {
        int[] boundsData = getBoundsData();

        return boundsData[0];
    }

    public int  getTopBound() {
        int[] boundsData = getBoundsData();

        return boundsData[1];
    }

    public int  getRightBound() {
        int[] boundsData = getBoundsData();

        return boundsData[2];
    }

    public int  getBottomBound() {
        int[] boundsData = getBoundsData();

        return boundsData[3];
    }

    public int  getWidth() {
        int[] boundsData = getBoundsData();

        return boundsData[2] - boundsData[0];
    }

    public int  getHeight() {
        int[] boundsData = getBoundsData();

        return boundsData[3] - boundsData[1];
    }
    //</editor-fold>

    //<editor-fold desc="Set Methods">
    public BoundingBox setBounds(int leftBound, int topBound, int rightBound, int bottomBound) {
        boundsData[0] = leftBound;      //Smaller X-Value
        boundsData[1] = topBound;       //Smaller Y-Value
        boundsData[2] = rightBound;     //Larger X-Value
        boundsData[3] = bottomBound;    //Larger Y-Value

        return this;
    }

    public BoundingBox changeSize(int deltaWidth, int deltaHeight) {
        boundsData[2] = boundsData[2] + deltaWidth;     //Larger X-Value
        boundsData[3] = boundsData[3] + deltaHeight;    //Larger Y-Value

        return this;
    }

    public BoundingBox changePosition(int deltaX, int deltaY) {
        boundsData[0] = boundsData[0] + deltaX;      //Smaller X-Value
        boundsData[1] = boundsData[1] + deltaY;      //Smaller Y-Value
        boundsData[2] = boundsData[2] + deltaX;      //Larger X-Value
        boundsData[3] = boundsData[3] + deltaY;      //Larger Y-Value

        return this;
    }
    //</editor-fold>
}
