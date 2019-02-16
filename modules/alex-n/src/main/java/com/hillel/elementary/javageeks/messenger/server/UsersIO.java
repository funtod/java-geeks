package com.hillel.elementary.javageeks.messenger.server;

public interface UsersIO {

    void msgToAll(String msg);

    void msgToAll(String msg, String user);

    String getUserName();

    void wellComeUser(String username);

    String getUserMsg();

    void close();
}
