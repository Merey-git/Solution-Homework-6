package CommandPattern;
import java.util.Stack;

public class SmartHomeRemoteControl {
    private Command[] commandSlots;
    private Stack<Command> commandHistory;
    private Stack<Command> redoHistory;

    public SmartHomeRemoteControl(int numSlots) {
        commandSlots = new Command[numSlots];
        commandHistory = new Stack<>();
        redoHistory = new Stack<>();
    }

    public void assignCommand(int slot, Command command) {
        commandSlots[slot] = command;
    }

    public void pressButton(int slot) {
        commandSlots[slot].execute();
        commandHistory.push(commandSlots[slot]);
        redoHistory.clear();
    }

    public void undoButton(int slot) {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
                redoHistory.push(lastCommand);
            }
    }

    public void redoButton() {
        if (!redoHistory.isEmpty()) {
            Command lastUndoneCommand = redoHistory.pop();
            lastUndoneCommand.execute();
            commandHistory.push(lastUndoneCommand);
        }
    }
}

