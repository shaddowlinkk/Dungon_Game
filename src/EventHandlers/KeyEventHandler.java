package EventHandlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        printEventInfo("Key Pressed", e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    private void printEventInfo(String str, KeyEvent e) {

        System.out.println(str);

        int code = e.getKeyCode();

        System.out.println("   Code: " + KeyEvent.getKeyText(code));

        System.out.println("   Char: " + e.getKeyChar());

        int mods = e.getModifiersEx();

        System.out.println("    Mods: "

                + KeyEvent.getModifiersExText(mods));

        System.out.println("    Location: "

                + keyboardLocation(e.getKeyLocation()));

        System.out.println("    Action? " + e.isActionKey());

    }
    private String keyboardLocation(int keybrd) {

        switch (keybrd) {

            case KeyEvent.KEY_LOCATION_RIGHT:

                return "Right";

            case KeyEvent.KEY_LOCATION_LEFT:

                return "Left";

            case KeyEvent.KEY_LOCATION_NUMPAD:

                return "NumPad";

            case KeyEvent.KEY_LOCATION_STANDARD:

                return "Standard";

            case KeyEvent.KEY_LOCATION_UNKNOWN:

            default:

                return "Unknown";

        }

    }
}
