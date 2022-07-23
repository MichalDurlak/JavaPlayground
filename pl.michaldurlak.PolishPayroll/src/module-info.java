module pl.michaldurlak.PolishPayroll {

    requires pl.michaldurlak.PayrollService;

    provides pl.michaldurlak.payroll.PayrollService with pl.michaldurlak.polishpayroll.PayrollServiceImpl;
}