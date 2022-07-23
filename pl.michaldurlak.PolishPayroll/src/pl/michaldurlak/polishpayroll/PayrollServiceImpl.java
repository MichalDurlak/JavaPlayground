package pl.michaldurlak.polishpayroll;

import pl.michaldurlak.payroll.PayrollService;

public class PayrollServiceImpl implements PayrollService {
    @Override
    public String getCurrency() {
        return "PLN";
    }
}
