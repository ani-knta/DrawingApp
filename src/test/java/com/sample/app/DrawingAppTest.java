package com.sample.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DrawingAppTest {

    @Test
    void testConstructor() {
    	DrawingBean drawingBean  = new DrawingBean(20, 4);
        assertEquals(drawingBean.render(),
        "----------------------\n" +
        "|                    |\n" +
        "|                    |\n" +
        "|                    |\n" +
        "|                    |\n" +
        "----------------------");
    }

    @Test
    void testDrawLine() {
        DrawingBean drawingBean = new DrawingBean(3,5);
        drawingBean.drawLine(1, 2, 1, 4, 'x');
        assertEquals(drawingBean.render(),
        "-----\n" +
            "|   |\n" +
            "|x  |\n" +
            "|x  |\n" +
            "|x  |\n" +
            "|   |\n" +
            "-----");
    }

    @Test
    void testDrawRectangle() {
    	DrawingBean drawingBean = new DrawingBean(8,4);
        drawingBean.drawRectangle(2, 1, 6, 3, 'x');
        assertEquals(drawingBean.render(),
            "----------\n" +
            "| xxxxx  |\n" +
            "| x   x  |\n" +
            "| xxxxx  |\n" +
            "|        |\n" +
            "----------");
    }

    @Test
    void testBucketFill() {
    	DrawingBean drawingBean = new DrawingBean(8,4);
        drawingBean.drawRectangle(2, 1, 6, 3, 'x');
        drawingBean.bucketFill(3,2, 'o');
        assertEquals(drawingBean.render(),
    "----------\n" +
            "| xxxxx  |\n" +
            "| xooox  |\n" +
            "| xxxxx  |\n" +
            "|        |\n" +
            "----------");
    }
}