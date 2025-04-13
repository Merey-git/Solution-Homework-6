package CommandPattern;
import java.util.*;

public class MainSmartHome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Инициализация устройств
        Light light = new Light();
        Thermostat thermostat = new Thermostat();
        Door door = new Door();

        // Команды
        Command turnOnLight = new TurnOnLightCommand(light);
        Command setThermostat = new SetThermostatCommand(thermostat, 22);
        Command lockDoor = new LockDoorCommand(door);

        // Макрокоманда "Goodnight"
        List<Command> goodnightCommands = Arrays.asList(turnOnLight, setThermostat, lockDoor);
        Command goodnightMode = new MacroCommand(goodnightCommands);

        // Пульт
        SmartHomeRemoteControl remote = new SmartHomeRemoteControl(3);
        remote.assignCommand(0, turnOnLight);
        remote.assignCommand(1, setThermostat);
        remote.assignCommand(2, goodnightMode);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Turn on the light");
            System.out.println("2. Set thermostat to 22°C");
            System.out.println("3. Goodnight mode (turn off light, set thermostat, lock door)");
            System.out.println("4. Undo last command");
            System.out.println("5. Redo last undone command");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    remote.pressButton(0);
                    break;
                case 2:
                    remote.pressButton(1);
                    break;
                case 3:
                    remote.pressButton(2);
                    break;
                case 4:
                    remote.undoButton(0);
                    break;
                case 5:
                    remote.redoButton();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
            }
        }
    }
}