package nl.stil4m.mollie.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.annotation.Nonnull;
import java.util.Date;
import java.util.Optional;

public class CreateSubscription {

    private final Double amount;
    private final Optional<Integer> times;
    private final String interval;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private final Date startDate;
    private final String description;
    private final Optional<String> method;
    private final Optional<String> webhookUrl;

    public CreateSubscription(@Nonnull Double amount, @Nonnull Optional<Integer> times, @Nonnull String interval, @Nonnull Date startDate, @Nonnull String description, @Nonnull Optional<String> method, Optional<String> webhookUrl) {
        this.amount = amount;
        this.times = times;
        this.interval = interval;
        this.startDate = startDate;
        this.description = description;
        this.method = method;
        this.webhookUrl = webhookUrl;
    }

    @Nonnull
    public Double getAmount() {
        return amount;
    }

    @Nonnull
    public Optional<Integer> getTimes() {
        return times;
    }

    @Nonnull
    public String getInterval() {
        return interval;
    }

    @Nonnull
    public Date getStartDate() {
        return startDate;
    }

    @Nonnull
    public String getDescription() {
        return description;
    }

    @Nonnull
    public Optional<String> getMethod() {
        return method;
    }

    @Nonnull
    public Optional<String> getWebhookUrl() {
        return webhookUrl;
    }

    public static class Interval {

        public static String days(int num) {
            return format(num, "days");
        }

        public static String weeks(int num) {
            return format(num, "weeks");
        }

        public static String months(int num) {
            return format(num, "months");
        }

        private static String format(int num, String unit) {
            return String.format("%s %s", num, unit);
        }
    }
}
