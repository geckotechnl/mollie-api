package nl.stil4m.mollie.concepts;

import nl.stil4m.mollie.Client;
import nl.stil4m.mollie.ResponseOrError;
import nl.stil4m.mollie.domain.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

import static nl.stil4m.mollie.TestUtil.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SubscriptionIntegrationTest {

    private Subscriptions subscriptions;

    @Before
    public void before() throws InterruptedException, IOException {
        Thread.sleep(TEST_TIMEOUT);
        Client client = strictClientWithApiKey(VALID_API_KEY);

        String uuid = UUID.randomUUID().toString();
        Map<String, Object> defaultMetadata = new HashMap<>();
        defaultMetadata.put("foo", "bar");
        defaultMetadata.put("id", uuid);

        String name = "Test Customer " + uuid;
        Customer customer = client.customers().create(new CreateCustomer(name, uuid + "@foobar.com", Optional.empty(), defaultMetadata)).getData();
        subscriptions  = client.subscriptions(customer.getId());
    }

    @Test
    public void testListSubscriptions() throws IOException, URISyntaxException {
        ResponseOrError<Page<Subscription>> all = subscriptions.all(Optional.empty(), Optional.empty());
        assertThat(all.getSuccess(), is(true));
    }

    @Test
    @Ignore
    public void testCreateSubscription() throws IOException {

        /*
         * FIXME: #32 Recurring payment integration test
         * Requires Mandate to be set up. See CustomerPaymentsIntegrationTest#testCreateRecurringPayment.
         */
        Date beforeTest = new Date();

        CreateSubscription createSubscription = new CreateSubscription(1.0d, Optional.of(1), CreateSubscription.Interval.days(1), new Date(), "description", Optional.empty(), Optional.of("http://example.com"));
        ResponseOrError<Subscription> subscription = subscriptions.create(createSubscription);

        assertThat(subscription.getSuccess(), is(true));
        assertWithin(beforeTest, subscription.getData().getCreatedDatetime(), new Date(), 5000L);
        assertThat(subscription.getData().getInterval(), is("1 days"));
    }

}
