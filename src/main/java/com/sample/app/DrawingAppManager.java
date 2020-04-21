package com.sample.app;

import java.util.Scanner;

public class DrawingAppManager {
	
	DrawingBean drawingBean;
    public DrawingAppManager() {
        drawingBean = new DrawingBean();
    }
    
    public static void main(String[] args) throws NumberFormatException {
        DrawingAppManager app = new DrawingAppManager();
        Scanner scan = new Scanner(System.in);
        String command = new String();
        while(!command.equals("Q")) {
            System.out.println("\nEnter command:");
            command = scan.nextLine();
            app.draw(command);
        }
        System.out.println("Program Exited!");
        scan.close();
    }

    private void draw(String command) throws NumberFormatException {
        char ch = command.charAt(0);
        String[] cmd;
        try {
            switch(ch) {
                case 'C' :
                    cmd = command.split(" ");
                    this.drawingBean = new DrawingBean(Integer.parseInt(cmd[1]),Integer.parseInt(cmd[2]));
                    System.out.println(this.drawingBean.render());
                    break;
                case 'L' :
                    cmd = command.split(" ");
                    this.drawingBean.drawLine(Integer.parseInt(cmd[1]),Integer.parseInt(cmd[2]),Integer.parseInt(cmd[3]),Integer.parseInt(cmd[4]),'X');
                    System.out.println(this.drawingBean.render());
                    break;
                case 'R' :
                    cmd = command.split(" ");
                    this.drawingBean.drawRectangle(Integer.parseInt(cmd[1]),Integer.parseInt(cmd[2]),Integer.parseInt(cmd[3]),Integer.parseInt(cmd[4]),'X');
                    System.out.println(this.drawingBean.render());
                    break;
                case 'B' :
                    cmd = command.split(" ");
                    this.drawingBean.bucketFill(Integer.parseInt(cmd[1]),Integer.parseInt(cmd[2]),cmd[3].charAt(0));
                    System.out.println(this.drawingBean.render());
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nInvalid command. Try again!!\n");
        } catch (Exception e) {
            System.out.println("\nError Occurred : " + e.getMessage() + "\nPlease try again");
        }
    }

}
