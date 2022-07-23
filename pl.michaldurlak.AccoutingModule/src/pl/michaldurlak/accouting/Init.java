package pl.michaldurlak.accouting;

import pl.michaldurlak.payroll.PayrollService;

import java.util.ServiceLoader;
import java.util.logging.Logger;

public class Init {

    private static final Logger LOG = Logger.getLogger(Logger.class.getName());

    public static void init(){
        LOG.info("Accounting has been initialized");
        ServiceLoader<PayrollService> services = ServiceLoader.load(PayrollService.class);
        services.findFirst().ifPresent(ser -> LOG.info(ser.getCurrency()));

    }
}
