package bro.task;

import bro.BroException;
import bro.Parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private LocalDateTime byStore;
    protected String by;
    private boolean isMonthFormat;

    /**
     * Constructor of Deadline class.
     * @param description The title of the task to be done.
     * @param by Time of the task to be done.
     * @throws BroException If the time format is invalid.
     */
    public Deadline(String description, String by) throws BroException {
        super(description);
        this.by = by;
        isMonthFormat = false;
        if (by.trim().split(" ").length == 4) {
            isMonthFormat = true;
        } else {
            byStore = Parser.deadlineParser(by);
        }
    }
    @Override
    public String getTaskType() {
        return "bro.task.Deadline";
    }

    @Override
    public String toString() {
        if(isMonthFormat) {
            return "[D]" + super.toString() + " (by: " + by + ")";
        } else {
            return "[D]" + super.toString() + " (by: " +
                    byStore.format(DateTimeFormatter.ofPattern("MMM dd yyyy kkmm")) + ")";
        }
    }
}

