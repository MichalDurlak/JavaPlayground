package pl.michaldurlak.JavaPlayground.logs;

import org.apache.commons.logging.Log;

import java.util.logging.Logger;


public class Log_app1 {

    private static final Logger LOG = Logger.getLogger(Logger.class.getName());

    public static void main(String[] args) {

        LOG.info("info");
        LOG.warning("warrning");

    }
}
