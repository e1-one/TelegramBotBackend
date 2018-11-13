package com.eone.bot.web;

import com.eone.bot.messages.HelloProcessor;
import com.eone.bot.web.WebHookHandler;
import com.pengrad.telegrambot.TelegramBot;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;

public class JettyWebServerStarter {

    public static int getWebServerPort(String portStr) {
        int port = 8080;
        if (portStr != null) {
            try {
                port = Integer.parseInt(portStr);
            } catch (Exception e) {
                System.out.println("Could not parse port: " + port);
            }
        }
        return port;
    }

    public static void start(int port, TelegramBot telegramBot) throws Exception {
        Server server = new Server(port);

        ContextHandler context = new ContextHandler();
        context.setContextPath("/webHook");
        context.setResourceBase(".");
        context.setClassLoader(Thread.currentThread().getContextClassLoader());
        server.setHandler(context);

        context.setHandler(new WebHookHandler(new HelloProcessor(telegramBot)));

        server.start();
        server.join();
    }

}
