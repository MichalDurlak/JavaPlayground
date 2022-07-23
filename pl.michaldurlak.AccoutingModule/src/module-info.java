module pl.michaldurlak.AccoutingModule {
    requires java.logging;
    requires pl.michaldurlak.PayrollService;
    requires pl.michaldurlak.PolishPayroll;

    exports pl.michaldurlak.accouting;

    uses pl.michaldurlak.payroll.PayrollService;
}