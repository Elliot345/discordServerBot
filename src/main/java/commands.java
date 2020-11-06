import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Dictionary;
import java.util.function.Function;

public class commands extends ListenerAdapter {
    systemResources useSystemResources;

    public commands() {
        useSystemResources = new systemResources();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }
        /*if (event.getAuthor().toString().substring(2, 11) != "Elliot345") {
            System.out.println(event.getAuthor().toString().substring(2, 11));
            return;
        }*/

        event.getChannel().sendTyping().queue();

        switch (event.getMessage().getContentDisplay().toLowerCase()) {
            case "get systeminfo" :
                event.getChannel().sendMessage(getSystemInfo()).queue();
                break;
            case "get commands":
                event.getChannel().sendMessage("get systemInfo for system info" + "\n" +
                        "get commands for commands/help").queue();
                break;
            default:
                event.getChannel().sendMessage("command not found: " + event.getMessage().getContentDisplay() +
                        "\n\nfor commands, type \"get commands\"").queue();
                break;
        }
    }

    public String getSystemInfo() {
        String newSection = "---------------------------------------------\n";

        float cpuUsage = (float)useSystemResources.getCpuUsage();

        float physicalMemory = (float)useSystemResources.getPhysicalMemory();
        float physicalMemoryUsed = (float)useSystemResources.getPhysicalMemoryUsed();

        float diskAvailable = (float)useSystemResources.getDiskSize();
        float diskUsed = (float)useSystemResources.getDiskUsed();

        return "cpu:\n" +
                "--usage: " + cpuUsage + "%\n" +
                newSection +
                "memory:\n" +
                "--used: " + physicalMemoryUsed + "\n" +
                "--available: " + physicalMemory + "\n" +
                newSection +
                "disk:\n" +
                "--disk used: " + diskUsed + "\n" +
                "--disk available: " + diskAvailable + "\n" +
                newSection;
    }
}
