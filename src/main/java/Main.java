import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

import javax.security.auth.login.LoginException;

public class Main {
    public static JDA jda;

    public static void main(String[] args) throws LoginException {
        jda = new JDABuilder(AccountType.BOT).setToken("Nzc0MDU2OTU1NTg4Mzc4Njc1.X6SOtw.gNZ20alwYR4C7Lz4UrjKxjfwjbU").build();
        jda.getPresence().setStatus(OnlineStatus.IDLE);

        jda.addEventListener(new commands());
    }
}
