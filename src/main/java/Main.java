import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws AWTException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        Robot robot = new Robot();

        System.out.print("Enter the message you want to send: ");
        StringSelection stringSelection = new StringSelection(sc.nextLine());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        System.out.print("Enter how many times you want to send the message: ");
        int repeats = sc.nextInt();

        System.out.println("You have 10 seconds to refocus the text input area of your messaging app!");
        TimeUnit.SECONDS.sleep(10);

        for (int i = 1; i <= repeats; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
        }
    }
}
